package Testes;

import java.util.Arrays;

public class TestesSorts {

    /*Aqui está um código para testar a ordenação de vetores, basta colocar o vetor que será ordenado e pegar o sort desejado no outro arquivo*/
    public static void main(String[] args) {
        int[] vetor = {7, 32, 6, 1, 78, 34, 3, 6, 7, 9, 12, 654, 8, 12, 324, 7, 1, 9, 10, 1, 1, 3, 5, 8, 4};
        //char[] vetor = {'o', 'r', 'd', 'e', 'n', 'a', 'd', 'o'};
         bubbleSort(vetor);
         System.out.println(Arrays.toString(vetor));
        
    }
    
    public static void bubbleSort(int[] lista) { //Para ordenar os vetores com letras basta mudar o int[] para char[] e o que estiver em vermelho no vetor para char também (a mesma coisa com double)
         int n = lista.length;
         for (int j=0; j<n-1; j++) {
             for (int i=0; i<n-1; i++) {
                 if (lista[i] > lista[i+1]) {
                     int temp = lista[i];
                     lista[i] = lista[i+1];
                     lista[i+1] = temp;
                }
            }
        }
    }
}
