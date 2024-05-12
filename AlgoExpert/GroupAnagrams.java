import java.util.*;

class Program {
    // Time Complexity : O(W * K Log N)
    // Space Complexity : O(N); W is the number of words, and K is the number of
    // characters in each word
    public static List<List<String>> groupAnagrams(List<String> words) {
        // Create a HashMap to store anagrams together
        Map<String, List<String>> anagrams = new HashMap<>();

        // Iterate through each word in the input list
        for (String word : words) {
            // Convert the word to a character array and sort it
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            // Check if the sorted word (representing the anagram group) already exists in the map
            if (anagrams.containsKey(sortedWord)) {
                // If it does, add the original word to the list of anagrams for that group
                anagrams.get(sortedWord).add(word);
            } else {
                // If it doesn't, create a new list for this group and add the original word to it
                anagrams.put(sortedWord, new ArrayList<>(Arrays.asList(word)));
            }
        }
        // Return the list of anagram groups
        return new ArrayList<>(anagrams.values());
    }
}