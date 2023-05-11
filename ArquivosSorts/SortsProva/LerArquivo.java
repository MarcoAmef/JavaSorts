package SortsProva;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LerArquivo {

    public static void main(String[] args) {
        
        /*Aqui tu vai substituir pelo diretório do arquivo seja ele txt ou csv. Pode ser q ele precise de \\ ou \ aí só testando...
         * O que para o erro tá certo.
        */

        String path = "C:\\Users\\marco\\OneDrive\\Área de Trabalho\\num.txt"; 
        
        List<Double> numeros = lerNumeros(path);

        System.out.println("Números lidos:");
        for (double numero : numeros) {
            System.out.println(numero);
        }

        /*Essa parte é a parte de medir o tempo em nanossegundos.
         * Se o Isaac quiser em milissegundos, basta pular 6 vírgulas para a esquerda.
         * Exemplos:  
         *      123456 ns (nanossegundos) → 0.123456 ms (milissegundos)
         *      1234567 ns (nanossegundos) → 1.234567 ms (milissegundos)
         * 
         * Se você quiser colocar este código direto para medir em milissegundos, no lugar de "nanoTime();" coloque "currentTimeMillis();". 
        */

        long startTime = System.nanoTime(); // O tempo começa bem aqui.
        //sortDesejado(); // Aqui você vai colocar o sort que desejar.
        long endTime = System.nanoTime(); // Quando o sort acabar, vai pra essa linha de código.
        long duration = (endTime - startTime); // Aqui será medido o tempo. Não esquece dá unidade medida que você colocou!
 
    }
    
    public static List<Double> lerNumeros(String path) {
        List<Double> numeros = new ArrayList<>();
        
        try {
            File arquivo = new File(path);
            BufferedReader leitor = new BufferedReader(new FileReader(arquivo));
            String linha = leitor.readLine();
            while (linha != null) {
                /*Essa parte aqui é muito importante! Tem q ver como q os números estão sendo separados.
                 * Eles podem estar separados por " ; ou : ou , ou um espaço mesmo (" ")".
                 * Do jeito que estiver separado no arquivo você vai ter q botar aqui.
                 *                                  Aqui    ↓
                 */
                String[] numerosString = linha.split(",");
                for (String numeroString : numerosString) {
                    double numero = Double.parseDouble(numeroString);
                    numeros.add(numero);
                }
                linha = leitor.readLine();
            }
            leitor.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        return numeros;
    }
}
