package behavioral.chainofresponsibility.filter;

import behavioral.chainofresponsibility.dto.HttpRequest;

public class AuthenticationFilter extends BaseFilter {
    @Override
    public boolean doFilter(HttpRequest request) {
        System.out.println("[Filter 2: AuthN] Verifying security credentials token...");

        if (request.getAuthToken() == null || !request.getAuthToken().startsWith("SECRET_TOKEN_")) {
            System.err.println("HTTP 401 Unauthorized: Session token is missing or corrupted.");
            return false; // Terminates request immediately
        }

        System.out.println("Identity identity verified successfully.");
        return passToNext(request);
    }
}
