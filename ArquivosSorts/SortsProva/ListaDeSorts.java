package SortsProva;

public class ListaDeSorts {

    /*Nesse arquivo tem todos os códigos dos sorts que vão cair na parte práticas, porém também coloquei uma descrição dos sorts que
     * vão cair na parte teórica também.
     * 
     * Parte Prática: Bubble, Insertion, Selection, Quick, Merge e Shell
     * 
     * Parte Teórica: Todos os da Parte Prática ↑, além desses, Bogo e Heap. Não sei se busca vai cair, porém, coloquei também um textinho
     * explicando cada uma das buscas (Linear e Binária).
     * 
    */

    //--------------------------------------------Ordenação SEM divisão e conquista-------------------------------------------------------
    //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    /*Bubble Sort:
     * No bubble sort, ele vai percorrer o vetor várias vezes e vai comparar sempre dois elementos adjacentes (um do lado do outro)
     * se eles estiverem na ordem errada, eles vão trocar de lugar.
     * 
     * Exemplo:
     * 
     *      [2, 1, 4, 8, 3]
     * 
     * No vetor acima, o primeiro par de elementos que irá ser analizado será o 2 e o 1, trocando-os de lugar.
     * Resumindo, se estiver na ordem errada, ele vai trocar até o maior número ser o último número do vetor.
     * 
     * Grau de complexidade: O(n²) onde n é o número de elementos na lista.
     * 
     * Implementação: Média
     * 
     * Pior caso: Caso esteja em uma lista inversa, ou seja, uma lista descrescente, pois terá que fazer a troca com todos os números todas as
     * vezes. 
     */

    public static void bubbleSort(int[] lista) {
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

//--------------------------------------------------------------------------------------------------------------------------

/*Selection Sort:
     * No selection sort, ele vai percorrer o vetor várias vezes e vai procurar o menor elemento e colocar na primeira posição trocando de 
     * posição com quem já estava na primeira posição. Em seguida, percorrá o vetor novamente e procurará o segundo menor elemento do vetor 
     * e colocá-lo na segundo posição, assim por diante até que o vetor esteja devidamente arrumado.
     * 
     * Exemplo:
     * 
     *      [2, 1, 4, 8, 3]
     * 
     * No vetor acima, o elemento 1 irá para a primeira posição, trocando de lugar com o 2. Em seguida, como o 2 já está na sua posição certa
     * ele procurará o 3 e trocará com o 4, deixando o vetor no estado abaixo:
     * 
     *      [1, 2, 3, 8, 4]
     * 
     * Isso será repetido até que o vetor esteja devidamente ordenado.
     * 
     * Grau de complexidade: O(n²) onde n é o número de elementos na lista.
     * 
     * Implementação: Média
     * 
     * Pior caso: Caso esteja em uma lista inversa, ou seja, uma lista descrescente, pois terá que procurar até o final do vetor para pegar
     * sempre o menor número. 
     */

     public static void selectionSort(int[] arr) {
        int n = arr.length;
        // Percorre todo o array
        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            // Encontra o menor elemento não ordenado
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            // Troca o menor elemento não ordenado com o primeiro elemento não ordenado
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
//--------------------------------------------------------------------------------------------------------------------------

/*Insertion Sort:
     * No insertion sort, ele vai tomar como o primeiro elemento do vetor como já ordenado, depois ele irá comparar o resto do vetor com os
     * elementos que já estão incluídos na ordenação do "pseudovetor". Em outras palavras, consiste em cada passo, a partir do primeiro ou
     * segundo elemento, selecionar o próximo item da sequência e colocá-lo no local apropriado de acordo com o critério de ordenação.
     * 
     * Exemplo:
     * 
     *      [25.33, 27.72, 27.10, 26.90, 27.31]
     * 
     * No vetor acima, o elemento 8 será dado como o primeiro elemento de um pseudovetor, em seguida, os próximos vetores serão colocados em
     * seus lugares mais apropriados neste vetor, adicionando este elemento no pseudovetor deixando o vetor no estado abaixo:
     * 
     *      Passo 1: [25.33, 27.72, 27.10, 26.90, 27.31]
     *      Passo 2: [25.33, 27.10, 27.72, 26.90, 27.31]
     *      Passo 3: [25.33, 26.90, 27.10, 27.72, 27.31]
     *      Passo 4: [25.33, 26.90, 27.10, 27.31, 27.72]
     * 
     * Isso será repetido até que o vetor esteja devidamente ordenado. (Nesse caso, ele já tá todo ordenado. Peguei esse exemplo da apostila
     * do Isaac).
     * 
     * Grau de complexidade: O(n²) onde n é o número de elementos na lista.
     * 
     * Implementação: Média
     * 
     * Pior caso: Caso esteja em uma lista inversa, ou seja, uma lista descrescente, pois fará a troca com todos até deixá-los apropriadamente
     * ordenedos. 
     */

    public static void insertionSort(int[] lista) {
        int n = lista.length;
        for (int i=1; i<n; i++) {
            int chave = lista[i];
            int j = i-1;
            while (j>=0 && lista[j]>chave) {
                lista[j+1] = lista[j];
                j--;
            }
            lista[j+1] = chave;
        }
    }

//--------------------------------------------------------------------------------------------------------------------------

/*Bogo Sort:
     * No bogo sort, o vetor vai sempre mudar a ordem dele aleatóriamente até estar devidamente ordenado, o que não é nem um pouco efetivo e é
     * comentado só em nível acadêmico.
     * 
     * Grau de complexidade: O(n!) onde n é o número de elementos na lista.
     * 
     * Implementação: Fácil
     * 
     * Pior caso: Ele é o seu pior caso.
     */

//--------------------------------------------------------------------------------------------------------------------------

/*Heap Sort:
     * No heap sort, ele vai criar um árvore binária e vai distribuir os elementos na ordem que o vetor está, não importando se está fora de 
     * ordem. Lembrando que na árvore binária, um elemento sempre vai criar mais dois elementos para baixo, se criou apenas um, não tinha o
     * suficiente.
     * 
     * Exemplo:
     *          Vetor: [10, 4, 8, 5, 12, 2, 6, 11, 3, 9, 7, 1]
     * 
     *          Árvore Binária:
     *                         
     *                              (10)
     *                             /    \
     *                           (4)    (8)
     *                          /   \   /  \
     *                        (5)   (.......)   
     *                       
     * Na situação acima, para continuar a criação da árvore, o elemento de baixo não pode ser maior que o elemento de cima, logo o 4 e o 5 irão
     * trocar de lugar. Deixando o vetor e a árvore desta maneira desta maneira:
     *
     *                      ↓     ↓
     *          Vetor: [10, 5, 8, 4, 12, 2, 6, 11, 3, 9, 7, 1]
     * 
     *          Árvore Binária:
     *                         
     *                              (10)
     *                             /    \
     *                           (5)    (8)
     *                          /   \   /  \
     *                        (4)   (.......)   
     * 
     * Quando o maior elemento do vetor estiver no topo, ele pegará o último elemento da árvore (elemento que está mais pra direita e mais para
     * baixo), adicionará no topo e realizará o processo novamente até que o vetor esteja devidamente ordenado.
     *   
     * Grau de complexidade: O(n log n)
     * 
     * Implementação: Difícil
     * 
     * Pior caso: O pior caso do heap sort é quando o vetor está na ordem inversa, pois fará a troca com todos os números para o topo, 
     * O(n log n)
     */


    //--------------------------------------------Ordenação COM divisão e conquista-------------------------------------------------------
    //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

/*Quick Sort:
     * No quick sort, ele vai escolher um número aleatório e considerá-lo como pivô, separando os números em duas metades, os números menores
     * que o pivô e os maiores até que a lista seja ordenada. O quick sort é o melhor sort para grandes quantidades de dados.
     * 
     * Exemplo:
     * 
     *      [8, 7, 3, 1, 2]
     * 
     * No vetor acima, suponhamos que o pivô escolhido seja o número 3, assim os números maiores que ele serão colocados para a direita e os
     * menores para a esquerda deixando o vetor no estado abaixo:
     * 
     *      [1, 2, 3, 7, 8]
     * 
     * Isso será repetido até que o vetor esteja devidamente ordenado. (Nesse caso, ele já tá todo ordenado.)
     * 
     * Grau de complexidade: O(n log n) onde n é o número de elementos na lista.
     * 
     * Implementação: Difícil
     * 
     * Pior caso: O pior caso possível do Quick Sort ocorre quando a lista está ordenada ou quase ordenada e o pivô escolhido é o menor ou 
     * o maior elemento da lista. Nesse caso, o Quick Sort terá que dividir a lista em apenas um elemento por vez, tornando a complexidade de 
     * tempo quadrática, ou seja, O(n²). 
     */

    public static void quickSort(int[] lista, int inicio, int fim) { // Parâmetros para colocar (nome do vetor, 0, vetor.lengh - 1)
        if (fim == -1) {                                             // Se com esse parâmetro tiver algum elemento fora do lugar, tira o -1
            fim = lista.length-1;
        }
        if (inicio < fim) {
            int p = partition(lista, inicio, fim);
            quickSort(lista, inicio, p-1);
            quickSort(lista, p+1, fim);
        }
    }
    
    public static int partition(int[] lista, int inicio, int fim) {
        int pivot = lista[fim];
        int i = inicio;
        for (int j=inicio; j<fim; j++) {
            if (lista[j] <= pivot) {
                int temp = lista[j];
                lista[j] = lista[i];
                lista[i] = temp;
                i++;
            }
        }
        int temp = lista[i];
        lista[i] = lista[fim];
        lista[fim] = temp;
        return i;
    }

//--------------------------------------------------------------------------------------------------------------------------
    
/*Merge Sort:
     * No merge sort, ele vai dividir o vetor em duas metades e dividi-las separadamente. Em seguida ele vai mesclar os elementos das duas 
     * listas de forma ordenada em uma única lista.
     * 
     * Exemplo:
     * 
     *      [10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
     * 
     * No vetor acima, ele irá dividir em duas metades e ordená-las deixando o vetor no estado abaixo:
     * 
     *      [6, 7, 8, 9, 10] && [1, 2, 3, 4, 5]
     * 
     *      [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
     * 
     * Grau de complexidade: O(n log n) onde n é o número de elementos na lista.
     * 
     * Implementação: Difícil
     * 
     * Pior caso: De qualquer jeito ele vai partir o array na metade, ou seja, O(n log n)
     */

    public static void mergeSort(int[] lista, int inicio, int fim) {// Parâmetros para colocar (nome do vetor, 0, vetor.lengh - 1)
        if (fim == -1) {                                            // Se com esse parâmetro tiver algum elemento fora do lugar, tira o -1
            fim = lista.length;
        }
        if (fim - inicio > 1) {
            int meio = (fim + inicio) / 2;
            mergeSort(lista, inicio, meio);
            mergeSort(lista, meio, fim);
            merge(lista, inicio, meio, fim);
        }
    }
    
    public static void merge(int[] lista, int inicio, int meio, int fim) {
        int[] left = Arrays.copyOfRange(lista, inicio, meio);
        int[] right = Arrays.copyOfRange(lista, meio, fim);
        int top_left = 0, top_right = 0;
        for (int k=inicio; k<fim; k++) {
            if (top_left >= left.length) {
                lista[k] = right[top_right];
                top_right++;
            }
            else if (top_right >= right.length) {
                lista[k] = left[top_left];
                top_left++;
            }
            else if (left[top_left] < right[top_right]) {
                lista[k] = left[top_left];
                top_left++;
            }
            else {
                lista[k] = right[top_right];
                top_right++;
            }
        }
    }

//--------------------------------------------------------------------------------------------------------------------------

/*Shell Sort:
     * No shell sort, ele vai fazer duas comparações ao mesmo tempo, essas comparações não são de elementos adjacentes. O elementos comparados
     * dependem do tamanhos do vetor.
     * 
     * Exemplo:
     * 
     *      Index: 0  1  2  3  4  5
     *             ↓  ↓  ↓  ↓  ↓  ↓
     *      Vetor:[3, 5, 7, 2, 9, 6]
     * 
     * No vetor acima, primeiro será calculado o index que está na metade do vetor, ou seja K = n/2 sendo n o tamanho do vetor, o que dará o
     * resultado 3, desse modo, o elemento que está no index[0] será comparado com o elemento que está no index[3], se o elemento que estiver
     * no 0 foi maior do que o que está no 3, eles trocam de lugar. Logo após percorrer todo o vetor e o vetor ainda não estiver ordenado, 
     * o valor de K diminuirá 1 (K--) e fará o mesmo processo deixando o vetor no estado abaixo:
     * 
     *      K = n/2 = 3
     * 
     *      Index: 0  1  2  3  4  5
     *             ↓  ↓  ↓  ↓  ↓  ↓
     *      Vetor:[3, 5, 7, 2, 9, 6]
     * 
     *      index[1] > index3, logo eles irão trocar.
     *      
     * 
     * Grau de complexidade: O(n log n) onde n é o número de elementos na lista.
     * 
     * Implementação: Difícil
     * 
     * Pior caso: Caso o vetor esteja em ordem decrescente, ou seja, O(n²)
     */

    public static void shellSort(int[] array) {
        int n = array.length;
        int gap = n / 2;
        while (gap > 0) {
            for (int i = gap; i < n; i++) {
                int temp = array[i];
                int j = i;
                while (j >= gap && array[j - gap] > temp) {
                    array[j] = array[j - gap];
                    j -= gap;
                }
                array[j] = temp;
            }
            gap /= 2;
        }
    }

    //----------------------------------------------------------BUSCAS--------------------------------------------------------------------
    //↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

    //LEMBRANDO QUE PARA QUE HAJA BUSCA, O VETOR DEVE ESTAR ORDENADO

/*Busca Linear:
     * Na busca linear ele irá percorrer todo o vetor até achar o elemento desejado, se achá-lo, retorna verdadeiro, senão, retorna falso.
     * 
     * Grau de complexidade: O(n) onde n é o número de elementos na lista.
     * 
     * Implementação: Fácil
     * 
     * Pior caso: O pior caso dessa busca é caso o elemento está sendo procurado não esteja no vetor, pois ele irá percorrer tudo atoa.
     */

//--------------------------------------------------------------------------------------------------------------------------

/*Busca Binária:
     * Na busca binária, dado o elemento que será requisitado, ele comparar se este elemento é maior ou menor que o elemento do meio do vetor.
     * Se sim, descartará a primeira metade do vetor, se não, descartará a segunda. Esse procedimento é várias vezes até que o elemento seja
     * encontrado.
     * 
     * Grau de complexidade: O(log n) onde é o número de elementos na lista.
     * 
     * Implementação: Média
     * 
     * Pior caso: O pior caso dessa busca é caso o elemento está sendo procurado não esteja no vetor, pois ele irá partir e procurar a toa.
     */

}
