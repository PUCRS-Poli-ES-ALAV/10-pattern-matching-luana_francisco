
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Exercicio2 {
    static int Q = 2147483647;
    static int R = 256; // tamanho do alfabeto

    public static void main(String[] args) {
        try {
            // Ler conteúdo dos arquivos
            String string1 = Files.readString(Paths.get("string1.txt")).trim();
            String string2 = Files.readString(Paths.get("string2.txt")).trim();

            search(string1, string2); // procurar string1 em string2

        } catch (IOException e) {
            System.err.println("Erro ao ler arquivos: " + e.getMessage());
        }
    }

    private static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();
        long patHash = hash(pat, M);

        for (int i = 0; i <= N - M; i++) {
            long txtHash = hash(txt.substring(i, i + M), M);
            if (patHash == txtHash){
                System.out.println("Posição encontrada: " + i);
                return i; // ocorrência? colisão?
            }
        }
        System.out.println("Não encontrado");
        return N; // nenhuma ocorrência
    }

    private static long hash(String s, int M) {
        long h = 0;
        for (int j = 0; j < M; j++)
            h = (h * R + s.charAt(j)) % Q;
        return h;
    }

}
