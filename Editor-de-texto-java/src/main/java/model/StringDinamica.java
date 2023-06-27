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
        }
    }

    /**
     *
     * @param list
     * @param data
     * @return
     */
    public static StringDinamica inserirCaractere(StringDinamica list, char data) {
        // Create a new node with given data
        System.out.println("Inserindo: %c".formatted(data));
        carectere novoCaractere = new carectere(data);
        // If the Linked List is empty,
        // then make the new node as head
        if (list.cabeca == null) {
            list.cabeca = novoCaractere;
        } else {
            // Else traverse till the last node
            // and insert the new_node there
            carectere ultimo = list.cabeca;
            while (ultimo.proximo != null) {
                ultimo = ultimo.proximo;
            }
            // Insert the new_node at last node
            novoCaractere.anterior = ultimo;
            ultimo.proximo = novoCaractere;
        }

        // Return the list by head
        return list;
    }

    public static String delete(StringDinamica list) {
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
        return getString(list);
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
