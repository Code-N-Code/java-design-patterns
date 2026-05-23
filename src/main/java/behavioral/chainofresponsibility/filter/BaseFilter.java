package behavioral.chainofresponsibility.filter;

import behavioral.chainofresponsibility.dto.HttpRequest;

public abstract class BaseFilter {
    private BaseFilter nextFilter;

    /**
     * Links filters sequentially.
     * Returns the next filter reference to support fluent chaining.
     */
    public BaseFilter setNext(BaseFilter nextFilter) {
        this.nextFilter = nextFilter;
        return nextFilter;
    }

    /**
     * Abstract method that contains specific filter processing logic.
     * Returns true to continue down the chain, false to abort.
     */
    public abstract boolean doFilter(HttpRequest request);

    /**
     * Standard propagation helper to cleanly forward execution to the next node.
     */
    protected boolean passToNext(HttpRequest request) {
        if (nextFilter == null) {
            return true; // Reached end of pipeline processing safely
        }
        return nextFilter.doFilter(request);
    }
}
