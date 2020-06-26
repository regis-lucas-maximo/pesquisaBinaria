/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pesquisabinaria;

import java.util.Scanner;
import service.PesquisaBinaria;

/**
 *
 * @author regis
 */
public class PesquisaBinariaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int searchInt; // chave de pesquisa
        int position; // localização da chave de pesquisa no array
        // cria um array e gera a saída
        PesquisaBinaria binaryArray = new PesquisaBinaria(15);
        System.out.println(binaryArray);
        
        // obtém entrada do usuário 
        System.out.println("entra com um valor da chave -1 para sair");
        searchInt = scanner.nextInt();
        System.out.println();
        
        while(searchInt != -1) {
            // utiliza a pesquisa binária para tentar localizar o inteiro
            position = binaryArray.buscarChave(searchInt);
            // valor de retorno -1 significa que o valor não foi localizado
            if(position == -1)
                System.out.println("não foi encontrado " + searchInt);
            else
                System.out.println("encontrado o elemento na posição: " + position);
            // obtém a entrada do usuário
            System.out.println("aperte -1 para parar");
            searchInt = scanner.nextInt();
            System.out.println();
        } // fim de while
    } // fim de main.
} // fim da classe PesquisaBinariaTest.
