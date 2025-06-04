
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


public class Exercicio2Refactor {
    static int Q = 2147483647;
    static int R = 256; // tamanho do alfabeto

    public static void main(String[] args) {

        // Ler conteúdo dos arquivos
        String string1 = "luana";
        String string2 = "luanasostisso";

        search(string1, string2); // procurar string1 em string2

    }

    private static int search(String pat, String txt) {
        int M = pat.length();
        int N = txt.length();

        if (M > N) {
            System.out.println("Não encontrado");
            return N;
        }

        long patHash = hash(pat, M); // hash do que precisamos encontrar
        long primeiroHash = hash(txt.substring(0, M), M);  // hash do primeiro M caracteres do texto

        long ultimoHashCalculado = primeiroHash;
        
        for (int i = 0; i < N - M; i++) {
            System.out.println(i);
            long formula = (long)(ultimoHashCalculado - (txt.charAt(i) * Math.pow(R,(M-1))) % patHash) * R + txt.charAt(i + M);
            if (patHash == formula){
                System.out.println("Posição encontrada: " + i);
                return i; // ocorrência? colisão?
            }
            ultimoHashCalculado = formula;
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
