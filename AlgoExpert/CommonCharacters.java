import java.util.*;

class Program {
    public String[] commonCharacters(String[] strings) {
        if (strings == null || strings.length == 0) {
            return new String[0]; // Return an empty array if the input is null or empty
        }

        Map<Character, Integer> characterCount = new HashMap<>();
        // Initialize the character count map with the first string's characters
        for (char ch : strings[0].toCharArray()) {
            characterCount.put(ch, 1);
        }

        // Start from the second string as we have already used the first one
        for (int i = 1; i < strings.length; i++) {
            Map<Character, Integer> currentStringCount = new HashMap<>();
            for (char ch : strings[i].toCharArray()) {
                if (characterCount.containsKey(ch)) {
                    currentStringCount.put(ch, currentStringCount.getOrDefault(ch, 0) + 1);
                }
            }
            // Update the characterCount map to contain only those characters that are
            // common
            characterCount.keySet().retainAll(currentStringCount.keySet());
            for (char ch : characterCount.keySet()) {
                characterCount.put(ch, Math.min(characterCount.get(ch), currentStringCount.get(ch)));
            }
        }

        // Prepare the result list with the common characters repeated by their count
        List<String> resultList = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : characterCount.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                resultList.add(String.valueOf(entry.getKey()));
            }
        }

        // Convert the result list to an array and return
        String[] resultArray = resultList.toArray(new String[0]);
        return resultArray;
    }
}
