import java.util.*;

class DNSEntry {
    String ipAddress;
    long expiryTime;

    DNSEntry(String ip, long ttl) {
        ipAddress = ip;
        expiryTime = System.currentTimeMillis() + ttl;
    }
}

public class DNSCacheSystem {

    private HashMap<String, DNSEntry> cache = new HashMap<>();

    public String resolve(String domain) {

        if (cache.containsKey(domain)) {

            DNSEntry entry = cache.get(domain);

            if (System.currentTimeMillis() < entry.expiryTime) {
                return "Cache HIT → " + entry.ipAddress;
            }

            cache.remove(domain);
        }

        String ip = "172.217.14.206";
        cache.put(domain, new DNSEntry(ip, 300000));

        return "Cache MISS → " + ip;
    }

    public static void main(String[] args) {

        DNSCacheSystem dns = new DNSCacheSystem();

        System.out.println(dns.resolve("google.com"));
        System.out.println(dns.resolve("google.com"));
    }
}