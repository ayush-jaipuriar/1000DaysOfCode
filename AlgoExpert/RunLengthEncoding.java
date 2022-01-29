
public class RunLengthEncoding {
	
	// Time Complexity : O(n) where n is the length of the string
	// Space Complexity : O(n) where n is the length of the string
	
	
	public static String runLengthEncoding(String string) {
		int count = 0;
		StringBuilder sb = new StringBuilder();
		Character lastConsecutiveCharacter = string.charAt(0);
		for (int i = 0; i <= string.length(); i++) {
			if (i == string.length()) {
				sb.append(String.valueOf(count) + lastConsecutiveCharacter);
				break;
			}
			char st = string.charAt(i);
			if (st == lastConsecutiveCharacter && count < 9) {
				count++;
			} else {
				sb.append(String.valueOf(count) + lastConsecutiveCharacter);
				count = 1;
			}
			lastConsecutiveCharacter = st;
		}
		return sb.toString();
	}

	public static void main(String[] args) {
		runLengthEncoding("AAAAAAAAAAAAABBCCCCDD");
	}

}
