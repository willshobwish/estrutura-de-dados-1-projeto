/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Willian
 */
public class StringDinamica {

    carectere cabeca;

    static class carectere {

        char elemento;
        carectere proximo;
        carectere anterior;

        carectere(char elementoCaractere) {
            elemento = elementoCaractere;
            proximo = null;
            anterior = null;
        }
    }

    /**
     *
     * @param lista
     * @param data
     * @return
     */
    public static StringDinamica inserirCaractere(StringDinamica lista, char data) {
        //Cria um novo caractere com o dado passado por parametro
//        System.out.println("Inserindo: %c".formatted(data));
        carectere novoCaractere = new carectere(data);
        //Caso a lista duplamente encadeada seja vazia, ele define como a cabeca
        if (lista.cabeca == null) {
            lista.cabeca = novoCaractere;
        } else {
            //Caso a lista nao seja vazia, ele percorre ate o ultimo elemento
            carectere ultimo = lista.cabeca;
            while (ultimo.proximo != null) {
                ultimo = ultimo.proximo;
            }
            //Redefine os ponteiros para apontar corretamente
            novoCaractere.anterior = ultimo;
            ultimo.proximo = novoCaractere;
        }
        //Retorna a lista
        return lista;
    }

    public static void delete(StringDinamica list) {
        carectere ultimo = list.cabeca;
        while (ultimo.proximo != null) {
            ultimo = ultimo.proximo;
        }
        if (ultimo.anterior == null) {
//            Nao ha como deixar null para caractere em Java, portanto utilizamos a constante que o Java fornece para que seja nulo
            list.cabeca.elemento = Character.MIN_VALUE;
        } else {
            ultimo.anterior.proximo = null;
        }
//        return getString(list);
    }

    /**
     *
     * @param list
     * @return
     */
    public static String getString(StringDinamica list) {
        carectere caractereAtual = list.cabeca;
        String stringConvertido = "";
        while (caractereAtual != null) {
//            Enquanto o atual for diferente de nulo, ele vai para o proximo, caso contrario ele para
            stringConvertido += caractereAtual.elemento;
            caractereAtual = caractereAtual.proximo;
        }
        return stringConvertido;
    }
}
