public enum HttpMethod {

    GET("GET"), POST("POST"), PUT("PUT"), PATCH("PATCH"), DELETE("DELETE");

    final String method;

    HttpMethod(String method) {
        this.method = method;
    }
}
