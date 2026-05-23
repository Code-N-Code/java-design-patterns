package behavioral.chainofresponsibility.filter;

import behavioral.chainofresponsibility.dto.HttpRequest;

public class RateLimitFilter extends BaseFilter {
    private static final int MAX_REQUESTS_PER_MINUTE = 60;

    @Override
    public boolean doFilter(HttpRequest request) {
        System.out.println("[Filter 4: Throttling] Calculating throughput metric vectors...");

        if (request.getRequestCountInLastMinute() > MAX_REQUESTS_PER_MINUTE) {
            System.err.println("HTTP 429 Too Many Requests: Flood mitigation triggered. Request dropped.");
            return false; // Terminates request immediately
        }

        System.out.println("Safe throughput threshold cleared.");
        return passToNext(request);
    }
}
