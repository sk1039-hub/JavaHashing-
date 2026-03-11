import java.util.*;

public class MultiLevelCacheSystem {

    LinkedHashMap<String, String> L1 = new LinkedHashMap<>(10000, 0.75f, true);
    HashMap<String, String> L2 = new HashMap<>();

    public String getVideo(String id) {

        if (L1.containsKey(id))
            return "L1 HIT";

        if (L2.containsKey(id)) {

            L1.put(id, L2.get(id));

            return "L2 HIT → Promoted to L1";
        }

        L2.put(id, "VideoData");

        return "L3 Database HIT";
    }

    public static void main(String[] args) {

        MultiLevelCacheSystem cache = new MultiLevelCacheSystem();

        System.out.println(cache.getVideo("video123"));
        System.out.println(cache.getVideo("video123"));
    }
}