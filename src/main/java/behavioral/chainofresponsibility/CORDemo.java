package behavioral.chainofresponsibility;

import behavioral.chainofresponsibility.dto.HttpRequest;
import behavioral.chainofresponsibility.filter.*;

public class CORDemo {
    public static void main(String[] args) {
        // Assemble security gateway infrastructure pipeline
        BaseFilter pipelineGateway = new LoggingFilter();
        pipelineGateway.setNext(new AuthenticationFilter())
                .setNext(new AuthorizationFilter())
                .setNext(new RateLimitFilter());

        System.out.println("==================================================");
        System.out.println("SCENARIO 1: Valid Admin Endpoint Request");
        System.out.println("==================================================");
        HttpRequest validRequest = new HttpRequest("/api/v1/admin/dashboard", "SECRET_TOKEN_XYZ123", "ADMIN_ROLE", 12);

        if (pipelineGateway.doFilter(validRequest)) {
            System.out.println("\nHTTP 200 OK: Routing request to core controller business engine logic.");
        }

        System.out.println("\n==================================================");
        System.out.println("SCENARIO 2: Anonymous User Violating Authentication");
        System.out.println("==================================================");
        HttpRequest unauthenticatedRequest = new HttpRequest("/api/v1/user/profile", null, "GUEST", 1);

        if (!pipelineGateway.doFilter(unauthenticatedRequest)) {
            System.out.println("\nRequest failed security evaluation early at pipeline level.");
        }

        System.out.println("\n==================================================");
        System.out.println("SCENARIO 3: Authenticated User Violating Authorization Roles");
        System.out.println("==================================================");
        HttpRequest unauthorizedRequest = new HttpRequest("/api/v1/admin/settings", "SECRET_TOKEN_ABC987", "STANDARD_USER_ROLE", 5);

        if (!pipelineGateway.doFilter(unauthorizedRequest)) {
            System.out.println("\nRequest failed security evaluation early at pipeline level.");
        }

        System.out.println("\n==================================================");
        System.out.println("SCENARIO 4: Admin Triggering Rate Limiter Thresholds");
        System.out.println("==================================================");
        HttpRequest highTrafficRequest = new HttpRequest("/api/v1/admin/analytics", "SECRET_TOKEN_XYZ123", "ADMIN_ROLE", 150);

        if (!pipelineGateway.doFilter(highTrafficRequest)) {
            System.out.println("\nRequest failed security evaluation early at pipeline level.");
        }
    }
}
