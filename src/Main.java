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
            int countLines = 0, googleBotCount = 0, yandexBotCount = 0;
            try {
                FileReader fileReader = new FileReader(path);
                BufferedReader reader = new BufferedReader(fileReader);
                String line;
                while ((line = reader.readLine()) != null) {
                    countLines++;
                    int length = line.length();
                    if (length > 1024) {
                        throw new LongLineException("В файле содержится строка длиннее 1024 символов. Строка номер: "
                                + countLines);
                    }
                    String userAgent = getUserAgent(line);
                    if (userAgent != null) {
                        String botName = getBotNameFromUserAgent(userAgent);
                        if ("Googlebot".equals(botName)) {
                            googleBotCount++;
                        } else if ("YandexBot".equals(botName)) {
                            yandexBotCount++;
                        }
                    }
                }

                System.out.println("Общее количество строк в файле: " + countLines);
                System.out.printf("Доля запросов Googlebot в процентах от общего количество строк в файле: %.2f\n", (googleBotCount != 0 ? (googleBotCount * 100.0 / countLines) : 0));
                System.out.printf("Доля запросов YandexBot в процентах от общего количество строк в файле: %.2f\n", (yandexBotCount != 0 ? (yandexBotCount * 100.0 / countLines) : 0));

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }

    private static String getUserAgent(String line) {
        String[] parts = line.split("\"");
        String userAgent = parts[parts.length - 1];
        if (userAgent.startsWith("Mozilla") && userAgent.contains("compatible")) {
            return userAgent;
        }
        return null;
    }

    private static String getBotNameFromUserAgent(String userAgent) {
        int startFirstBrackets = userAgent.indexOf('(');
        int endFirstBrackets = userAgent.indexOf(')');
        if (startFirstBrackets != -1 && endFirstBrackets != -1 && startFirstBrackets < endFirstBrackets) {
            String firstBrackets = userAgent.substring(startFirstBrackets + 1, endFirstBrackets);
            String[] parts = firstBrackets.split(";");
            if (parts.length >= 2) {
                String fragment = parts[1].trim();
                return fragment.split("/")[0];
            }
        }
        return null;
    }
}
