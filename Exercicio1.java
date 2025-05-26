import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Exercicio1 {
    public static void main(String[] args) {
        try {
            // Ler conteúdo dos arquivos
            String string1 = Files.readString(Paths.get("string1.txt")).trim();
            String string2 = Files.readString(Paths.get("string2.txt")).trim();
            
            int pos = compare(string1, string2);
            System.out.println("Posição encontrada: " + pos);

        } catch (IOException e) {
            System.err.println("Erro ao ler arquivos: " + e.getMessage());
        }
    }

    public static int compare(String string1, String string2) {
        for (int i = 0; i < string1.length(); i++) {
            if (string2.charAt(0) == string1.charAt(i)) {
                if (string1.charAt(i) == string2.charAt(0)) {
                    int count = 0;
                    for (int c = 0; c < string2.length(); c++) {
                        if (string1.charAt(i + c) == string2.charAt(0 + c)) {
                            count++;
                        } else {
                            break;
                        }
                        if (count == string2.length()) {
                            return i;
                        }
                    }
                }
            }
        }
        return 0;
    }
}