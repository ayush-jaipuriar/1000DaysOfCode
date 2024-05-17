
import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

	/**
	 * Main entry point for the application.
	 */
	public static void main(String[] args) {
		// Placeholder for demonstration purposes
	}

	/**
	 * Determines if it is possible to generate a given document string using the
	 * available characters.
	 *
	 * @param characters A string containing all the characters that can be used to
	 *                   generate the document.
	 * @param document   A string representing the document to be generated.
	 * @return True if the document can be generated using the available characters,
	 *         false otherwise.
	 */
	public boolean generateDocument(String characters, String document) {
		Map<Character, Integer> characterCountMap = new HashMap<>();
		// Count the occurrences of each character in the input string
		for (Character character : characters.toCharArray()) {
			if (characterCountMap.containsKey(character)) {
				characterCountMap.put(character, characterCountMap.get(character) + 1);
			} else {
				characterCountMap.put(character, 1);
			}
		}

		int characterCount = 0;
		// Check if each character in the document exists in the characters string and
		// decrement its count
		for (Character character : document.toCharArray()) {
			if (!characterCountMap.containsKey(character)) {
				return false;
			}
			characterCount = characterCountMap.get(character);
			if (--characterCount < 0) {
				return false;
			}
			characterCountMap.put(character, characterCount);
		}
		return true;
	}
}