import java.util.*;

class Program {
    // Time Complexity : O(W * K Log N)
    // Space Complexity : O(N); W is the number of words, and k is the number of
    // character in each word
    public static List<List<String>> groupAnagrams(List<String> words) {
        Map<String, List<String>> anagrams = new HashMap<>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            if (anagrams.containsKey(sortedWord)) {
                anagrams.get(sortedWord).add(word);
            } else {
                anagrams.put(sortedWord, new ArrayList<>(Arrays.asList(word)));
            }
        }
        return new ArrayList<>(anagrams.values());
    }
}
