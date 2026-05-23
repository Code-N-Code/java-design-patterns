package behavioral.chainofresponsibility.filter;

import behavioral.chainofresponsibility.dto.HttpRequest;

public class AuthorizationFilter extends BaseFilter {
    @Override
    public boolean doFilter(HttpRequest request) {
        System.out.println("[Filter 3: AuthZ] Verifying access permissions for path: " + request.getPath());

        // Simulating protected resource administration check
        if (request.getPath().contains("/admin") && !"ADMIN_ROLE".equalsIgnoreCase(request.getUserRole())) {
            System.err.println("HTTP 403 Forbidden: Insufficient clearance levels for this role type.");
            return false; // Terminates request immediately
        }

        System.out.println("Access permissions granted.");
        return passToNext(request);
    }
}
