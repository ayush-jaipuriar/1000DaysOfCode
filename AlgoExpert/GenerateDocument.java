import java.util.HashMap;
import java.util.Map;

public class GenerateDocument {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public boolean generateDocument(String characters, String document) {
		// Write your code here.
		Map<Character, Integer> characterCountMap = new HashMap<>();
		for (Character character : characters.toCharArray()) {
			if (characterCountMap.containsKey(character)) {
				characterCountMap.put(character, characterCountMap.get(character) + 1);
			} else {
				characterCountMap.put(character, 1);
			}
		}
		int characterCount = 0;
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
