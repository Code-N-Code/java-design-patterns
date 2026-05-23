package behavioral.chainofresponsibility.filter;

import behavioral.chainofresponsibility.dto.HttpRequest;

public class LoggingFilter extends BaseFilter {
    @Override
    public boolean doFilter(HttpRequest request) {
        System.out.println("[Filter 1: Logger] Incoming request intercepted on path: " + request.getPath());
        // Logging never breaks the chain, it just records and passes down
        return passToNext(request);
    }
}
