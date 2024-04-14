import java.util.*;

class Program {
    // Time Complexity : O(n)
    // Space Complexity : O(n); n is the length of String
    public String reverseWordsInString(String string) {
        List<String> words = new ArrayList<>();
        int startingIndex = 0;
        int n = string.length();

        for (int i = 0; i < n; i++) {
            Character ch = string.charAt(i);

            // Case 1 : When ch == ' ', it means we have found end of a word, and since
            // startingIndex is pointing to 1st character of word, all we need to do
            // is take string.substring(startingIndex, index)
            if (ch == ' ') {
                words.add(string.substring(startingIndex, i));
                startingIndex = i;
            } else if (string.charAt(startingIndex) == ' ') {
                // Case 2: When i has moved to first letter of word after space and
                // startingIndex is still on index of space
                // We will add this space to our words list
                words.add(" ");
                // Now we make startingIndex to point at start of the word, same as i
                startingIndex = i;
            }
        }
        // Case 3 : i is pointing to n+1th index of string, and startingIndex is
        // pointing to the 1st letter of the last word of the string
        // so taking substring(startingIndex,i) once again to add the final word
        words.add(string.substring(startingIndex, n));
        Collections.reverse(words);
        return String.join("", words);
    }

    // Time Complexity : O(n)
    // Space Complexity : O(n)
    public String reverseWordsInStringSolution2(String string) {
        char[] characters = string.toCharArray();
        int startingIndex = 0;
        int endingIndex = 0;
        int n = string.length();
        // Reversing the entire string initially
        reverseStringRange(characters, 0, n - 1);
        while (startingIndex < n) {
            endingIndex = startingIndex;

            while (endingIndex < n && characters[endingIndex] != ' ') {
                endingIndex++;
            }

            reverseStringRange(characters, startingIndex, endingIndex - 1);
            startingIndex = endingIndex + 1;
        }
        return new String(characters);
    }

  public void reverseStringRange(char[] characters, int startingIndex, int endingIndex) {
    while (startingIndex < endingIndex) {
      char temp = characters[startingIndex];
      characters[startingIndex] = characters[endingIndex];
      characters[endingIndex] = temp;
      ++startingIndex;
      --endingIndex;
    }
}
