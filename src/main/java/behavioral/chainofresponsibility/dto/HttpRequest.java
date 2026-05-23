package behavioral.chainofresponsibility.dto;

public class HttpRequest {
    private final String path;
    private final String authToken;
    private final String userRole;
    private final int requestCountInLastMinute;

    public HttpRequest(String path, String authToken, String userRole, int requestCountInLastMinute) {
        this.path = path;
        this.authToken = authToken;
        this.userRole = userRole;
        this.requestCountInLastMinute = requestCountInLastMinute;
    }

    // Getters
    public String getPath() { return path; }
    public String getAuthToken() { return authToken; }
    public String getUserRole() { return userRole; }
    public int getRequestCountInLastMinute() { return requestCountInLastMinute; }
}
