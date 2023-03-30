import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class HomeWork {

    /**
     * 1 Дано четное число N (>0) и символы c1 и c2.
     * Написать метод, который вернет строку длины N, которая состоит из чередующихся символов c1 и c2, начиная с c1.
     *
     * Пример. (n = 6, c1='a', c2='b') -> "ababab"
     * (n = 8, c1='x', c2='y') -> "xyxyxyxy"
     *
     * static String buildString(int n, char c1, char c2) {
     *     return null;
     * }
     *
     * 2 Создать файл file.txt. Если файл уже создан, ничего делать не надо.
     *   Записать в файл слово TEXT 100 раз: TEXTTEXTTEXTTEXTTEXTTEXT...
     */
    public static void main(String[] args) {
        System.out.println(buildString(6,'a','b'));
        System.out.println(buildString(8,'x','y'));

        try {
            createFile("text.txt");
        }catch (IOException e){
            System.out.println("Не смог создать файл, ошибка: " + e.getMessage());
        }

        try {
            addHundredTextToFile("text.txt","TEXT");
            System.out.println("Текст записан!");
        }catch (IOException e){
            System.out.println("При работе с файлом возникла ошибка: " + e.getMessage());
        }
    }
    private static String buildString(int n, char c1, char c2) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (i % 2 != 0){
                stringBuilder.append(c1);
            } else {
                stringBuilder.append(c2);
            }
        }
        return stringBuilder.toString();
    }

    private static void createFile(String fileName)throws IOException {
        Path file = Path.of(fileName);
        if (!Files.isRegularFile(file)){
            Files.createFile(file);
        }
    }

    private static void addHundredTextToFile(String fileName, String text) throws IOException{
        Path file = Path.of(fileName);
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 100; i++) {
            stringBuilder.append(text);
        }
        Files.writeString(file, stringBuilder.toString());
    }
}