import java.util.*;

public class PlagiarismDetector {

    private HashMap<String, Set<String>> ngramIndex = new HashMap<>();

    public void addDocument(String docId, String text) {

        String[] words = text.split(" ");

        for (int i = 0; i < words.length - 4; i++) {

            String gram = String.join(" ", Arrays.copyOfRange(words, i, i + 5));

            ngramIndex.putIfAbsent(gram, new HashSet<>());
            ngramIndex.get(gram).add(docId);
        }
    }

    public void checkDocument(String docId, String text) {

        String[] words = text.split(" ");

        int matches = 0;

        for (int i = 0; i < words.length - 4; i++) {

            String gram = String.join(" ", Arrays.copyOfRange(words, i, i + 5));

            if (ngramIndex.containsKey(gram))
                matches++;
        }

        System.out.println("Matching n-grams: " + matches);
    }

    public static void main(String[] args) {

        PlagiarismDetector detector = new PlagiarismDetector();

        detector.addDocument("essay1", "this is a sample essay for plagiarism detection system");

        detector.checkDocument("essay2", "this is a sample essay for testing plagiarism");
    }
}