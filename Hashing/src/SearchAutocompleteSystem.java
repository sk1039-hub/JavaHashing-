import java.util.*;

public class SearchAutocompleteSystem {

    HashMap<String, Integer> queries = new HashMap<>();

    public void updateFrequency(String query) {
        queries.put(query, queries.getOrDefault(query, 0) + 1);
    }

    public List<String> search(String prefix) {

        List<String> result = new ArrayList<>();

        for (String q : queries.keySet())
            if (q.startsWith(prefix))
                result.add(q);

        return result;
    }

    public static void main(String[] args) {

        SearchAutocompleteSystem system = new SearchAutocompleteSystem();

        system.updateFrequency("java tutorial");
        system.updateFrequency("javascript");

        System.out.println(system.search("jav"));
    }
}