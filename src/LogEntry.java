import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

public class LogEntry {

    private final String ipAddr;
    private final LocalDateTime time;
    private final HttpMethod method;
    private final String path;
    private final int responseCode;
    private final int responseSize;
    private final String referer;
    private final UserAgent userAgent;

    public LogEntry(String line) {
        String[] parts = removeEmptyParameters(line).split(" ");
        this.ipAddr = parts[0];
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MMM/yyyy:HH:mm:ss", Locale.ENGLISH);
        this.time = LocalDateTime.parse(parts[1].replace("[", ""),formatter);
        this.method = HttpMethod.valueOf(parts[3].replace("\"", ""));
        this.path = parts[4];
        this.responseCode = Integer.parseInt(parts[6]);
        this.responseSize = Integer.parseInt(parts[7]);
        if (!parts[8].equals("\"-\"") && !parts[8].isEmpty()) {
            this.referer = parts[8].replace("\"", "");
        } else {
            this.referer = null;
        }
        System.out.println(referer);
        if (!parts[9].contains("okhttp") && !parts[9].contains("\"-\"")) {
            this.userAgent = new UserAgent(parts[9]);
        } else {
            this.userAgent = null;
        }
        System.out.println(userAgent);
    }

    //нужно для удаления незаполненных свойств
    private static String removeEmptyParameters(String line) {
        return line.replace(" - -", "");
    }

    public String getIpAddr() {
        return this.ipAddr;
    }

    public LocalDateTime getTime() {
        return time;
    }

    public HttpMethod getMethod() {
        return method;
    }

    public String getPath() {
        return path;
    }

    public int getResponseCode() {
        return responseCode;
    }

    public int getResponseSize() {
        return responseSize;
    }

    public String getReferer() {
        return referer;
    }

    public UserAgent getUserAgent() {
        return userAgent;
    }
}
