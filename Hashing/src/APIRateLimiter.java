import java.util.*;

class TokenBucket {

    int tokens;
    long lastRefill;

    TokenBucket(int limit) {
        tokens = limit;
        lastRefill = System.currentTimeMillis();
    }
}

public class APIRateLimiter {

    HashMap<String, TokenBucket> clients = new HashMap<>();

    int limit = 1000;

    public boolean checkRateLimit(String clientId) {

        clients.putIfAbsent(clientId, new TokenBucket(limit));

        TokenBucket bucket = clients.get(clientId);

        if (bucket.tokens > 0) {
            bucket.tokens--;
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        APIRateLimiter limiter = new APIRateLimiter();

        System.out.println(limiter.checkRateLimit("abc123"));
    }
}
