import java.util.*;

class Program {
  public ArrayList<ArrayList<String>> semordnilap(String[] words) {
    ArrayList<ArrayList<String>> resultList = new ArrayList<>();
    // Create a set containing all unique words 
    Set<String> uniqueWords = new HashSet<>();

    // Filling the set with all the unique words from words array
    for (String s: words) {
      uniqueWords.add(s);
    }

    // Now we loop through words again and check if the reverse of that word exists in our above set or not
    for (String s: words) {
      String reversedWord = new StringBuilder(s).reverse().toString();
      // Now we check if reversedWord exists in our set or not
      if (uniqueWords.contains(reversedWord) && !reversedWord.equals(s)) {
        // If found, it means we have found one set; we store it in our result list
        ArrayList<String> resultPair = new ArrayList<>();
        resultPair.add(s);
        resultPair.add(reversedWord);
        resultList.add(resultPair);
        
        // Now, to avoid duplicate pair addition later on in the iteration when we iterate through its reversed pair,
        // we remove these two words from the set to handle this case
        uniqueWords.remove(s);
        uniqueWords.remove(reversedWord);
      }
    }
    return resultList;
  }
}
