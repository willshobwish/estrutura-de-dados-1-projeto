/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;
import javax.swing.JOptionPane;
import model.StringDinamica;
import view.MainWindow;

/**
 *
 * @author Willian
 */
public class Controller {

    private static final Controller controller = new Controller();
    private static StringDinamica stringDinamica = new StringDinamica();
    private MainWindow mainWindow = new MainWindow();
    private int quantidadeAnterior = 0;

    private Controller() {
        mainWindow.setVisible(true);
    }

    /**
     * Instanciacao de apenas um controlador do modelo MVC
     *
     * @return a instancia unica do controlador
     */
    public static Controller getInstance() {
        return controller;
    }

    /**
     * Converte uma string em uma estrutura de dados de string dinamica
     *
     * @param entrada um objeto do tipo string para ser convertido na estrutura
     * de dado string dinamica
     * @param espaco booleano para verificar a adicao de espaco entre as
     * insercoes
     * @param quebraDeLinha booleano para verificar a adicao de quebra de linha
     * entre as insercoes
     */
    public void converterString(String entrada) {
        char[] caracteres = entrada.toCharArray();
//      Converte o objeto string para um vetor de caracteres
//      O for percorre o vetor de char, previamente convertido do objeto string e insere na estrutura de dado "string dinamica"
        for (int i = quantidadeAnterior; i < caracteres.length; i++) {
//      O vetor de caracteres eh processado por esse for, atribuindo na estrutura de dados "string dinamica"
            stringDinamica = stringDinamica.inserirCaractere(stringDinamica, caracteres[i]);
        }
        quantidadeAnterior = entrada.length();
    }

    /**
     * Faz com que forme uma string a partir da estrutura de dados "string
     * dinamica"
     *
     * @return retorna uma string com os caracteres alocados na estrutura de
     * dados "string dinamica"
     */
    public String imprime() {
        return stringDinamica.getString(stringDinamica);
    }

    public void apagar(String entrada) {
        stringDinamica.delete(stringDinamica);
        quantidadeAnterior = entrada.length();
    }

    public void abrirTexto(String caminho) {
        File arquivo = new File(caminho);
        try {
            Scanner escaner = new Scanner(arquivo);
            while (escaner.hasNext()) {
                converterString(escaner.nextLine());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        mainWindow.getTextEditor().setText(stringDinamica.getString(stringDinamica));
    }

    public void salvarTexto(String caminho) {
        File arquivo = new File(caminho + ".txt");
        try {
            if (arquivo.createNewFile()) {
                FileWriter escritor = new FileWriter(arquivo);
                escritor.write(stringDinamica.getString(stringDinamica));
                escritor.close();
                JOptionPane.showMessageDialog(null,
                        "O arquivo %s foi criado e salvo com sucesso".formatted(arquivo.getName()),
                        "Arquivo criado e salvo",
                        JOptionPane.WARNING_MESSAGE);
            } else {
                FileWriter escritor = new FileWriter(arquivo);
                escritor.write(stringDinamica.getString(stringDinamica));
                escritor.close();
                JOptionPane.showMessageDialog(null,
                        "O arquivo %s foi salvo com sucesso".formatted(arquivo.getName()),
                        "Arquivo salvo",
                        JOptionPane.WARNING_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,
                    "Ocorreu um erro ao salvar o arquivo %s".formatted(arquivo.getName()),
                    "Erro",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }

    }
}
