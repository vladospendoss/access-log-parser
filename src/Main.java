import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws LongLineException {
        int count = 0;
        while (true) {
            String path = new Scanner(System.in).nextLine();
            File file = new File(path);
            boolean fileExists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (!fileExists || isDirectory) {
                System.out.println("Указанный файл не существует\n" +
                        "или указанный путь является путём к папке, а не к файлу");
                continue;
            }
            count++;
            System.out.println("Путь указан верно");
            System.out.println("Это файл номер " + count);
            int countLines = 0, maxLength = 0, minLength = 0;
            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    if (countLines == 0){
                        minLength = line.length();
                    }
                    countLines++;
                    int length = line.length();
                    if (length > 1024) {
                        throw new LongLineException("В файле содержится строка длиннее 1024 символов. Строка номер: "
                                + countLines);
                    }
                    if (length > maxLength) {
                        maxLength = length;
                    }
                    if (length < minLength) {
                        minLength = length;
                    }
                }

                System.out.println("Общее количество строк в файле: " + countLines);
                System.out.println("Длина самой длинной строки в файле: " + maxLength);
                System.out.println("Длина самой короткой строки в файле: " + minLength);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
