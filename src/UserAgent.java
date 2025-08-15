public class UserAgent {

    private final String os;
    private final String browser;

    public UserAgent(String userAgent) {
        this.browser = defineBrowser(userAgent);
        this.os = defineOs(userAgent);
    }

    private String defineOs(String userAgent) {
        if (userAgent.contains("Windows")) {
            return "Windows";
        }
        if (userAgent.contains("Macintosh") || userAgent.contains("Mac OS X")) {
            return "macOS";
        }
        if (userAgent.contains("Linux")) {
            return "Linux";
        }
        return "Other";
    }

    private String defineBrowser(String userAgent) {
        if (userAgent.contains("Edg/") || userAgent.contains("Edge")) {
            return "Edge";
        }
        if (userAgent.contains("Firefox")) {
            return "Firefox";
        }
        if (userAgent.contains("Chrome")) {
            return "Chrome";
        }
        if (userAgent.contains("Opera") || userAgent.contains("OPR/")) {
            return "Opera";
        }
        return "Other";
    }

    public String getOs() {
        return os;
    }

    public String getBrowser() {
        return browser;
    }

}
