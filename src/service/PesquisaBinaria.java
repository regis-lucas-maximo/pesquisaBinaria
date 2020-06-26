/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Arrays;
import java.util.Random;

/**
 *
 * @author regis
 */
public class PesquisaBinaria {

    // objeto que será utilizado para gerar números aleatórios.
    private Random random = new Random();
    private int dados[]; // array de dados do tipo inteiro

    // contrutor da classe inicializa o array de dados com números aleatório de 
    // 10 à 99.
    // o conntrutor irá receber um valor do tipo inteiro para inicilizar o array 
    // de acordo com o valor sugerido pelo usuário.
    public PesquisaBinaria(int size) {
        dados = new int[size]; // inicializa o array dados.

        // laço que vai atribuir cada valor aleatório de acordo com o tamanho 
        // informado pelo usuário.
        for (int i = 0; i < dados.length; i++) {
            dados[i] = 10 + random.nextInt(90);
        }

        // método static da classe Arrayz para poder ordenar o array dados 
        Arrays.sort(dados);
    } // fim do construtor da classe

    // método para buscar o valor informado pelo usuário, esse método retornará
    // a posição exata da chave.
    public int buscarChave(int chave) {

        int localizacao = -1; // variável de armazenar o valor da chave caso seja
        int inicio = 0; // variável para pegar posições de início do array.
        int fim = dados.length - 1; // variável para pegar posições de fim do array.
        int meio = (inicio + fim + 1) / 2; // calculo para pegar o meio do array.
        // encontrada.

        // laço (do while) para percorrer o array e ir dividindo o array caso não encontre
        // a chave na primeira iteração.
        do {
            // mostra o array ao ser inicializado o objeto PesquisaBinaria.
            System.out.print(mostrarArray(inicio, fim));

            // imprime uma marcação para informar o meio do array.
            for (int i = inicio; i < meio; i++) {
                System.out.print("   ");
            }
            System.out.println("* "); // marca o meio do array.

            // Se o valor da chave estiver no meio retorna para chamador o valor da
            // localização.
            if (chave == dados[meio]) {
                localizacao = meio;
            } // caso o valor da chave seja maior que o elemento da posição do meio
            // a variável "inicio" começa atrás do meio uma posição atrás.
            else if (chave < dados[meio]) {
                fim = meio - 1;
            } // Senão a chave é maior e assim fica com a metade maior do "meio"
            else {
                inicio = meio + 1;
            }

            // reecalcula o meio de novo do array assim dividindo ele pela metade de novo.
            meio = (inicio + fim + 1) / 2;

        } while ((inicio <= fim) && (localizacao == -1));

        return localizacao; // retorna localização caso não seja encontrado retornará -1.
    } // fim do método BuscarArray.

    private String mostrarArray(int inicio, int fim) {
        // objeto para poder formatar a saída do array
        StringBuilder sb = new StringBuilder();

        // laço para mostrar os dados dos elementos do array
        for (int i = inicio; i <= fim; i++) {
            sb.append(dados[i]).append(" ");
        }
        sb.append("\n");

        return sb.toString(); // retorna o objeto StringBuider formatado com os valores do array
    } // fim do método mostrarArray.

    // método toString para gerar saída do array em sua criação
    @Override
    public String toString() {
        return mostrarArray(0, dados.length - 1); // retorna com os valores 
        // formatados com a chamada do méto mostrarArray
    } // fim do método toString.
} // fim da classe PesquisaBinaria.
