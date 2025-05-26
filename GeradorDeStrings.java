import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class GeradorDeStrings {

    public static String gerarString(String letras, int tamanho) {
        Random random = new Random();
        StringBuilder resultado = new StringBuilder(tamanho);

        for (int i = 0; i < tamanho; i++) {
            int indice = random.nextInt(letras.length());
            resultado.append(letras.charAt(indice));
        }

        return resultado.toString();
    }

    public static void salvarEmArquivo(String texto, String nomeArquivo) {
        try (FileWriter writer = new FileWriter(nomeArquivo)) {
            writer.write(texto);
            System.out.println("Arquivo salvo: " + nomeArquivo);
        } catch (IOException e) {
            System.err.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String letras = "abcdefghij"; // 10 letras
        int tamanho1 = 900000000;
        int tamanho2 = 500000;

        // Gerar duas strings
        String string1 = gerarString(letras, tamanho1);
        String string2 = gerarString(letras, tamanho2);

        // Salvar em arquivos separados
        salvarEmArquivo(string1, "string1.txt");
        salvarEmArquivo(string2, "string2.txt");
    }
}
