public static String runLengthEncoding(String string) {
	int count = 0; // Initialize count to keep track of consecutive characters
	StringBuilder sb = new StringBuilder(); // Use StringBuilder for efficient string concatenation
	Character lastConsecutiveCharacter = string.charAt(0); // Start with the first character of the input string

	// Iterate through each character in the string
	for (int i = 0; i <= string.length(); i++) {
		// Check if we've reached the end of the string
		if (i == string.length()) {
			sb.append(String.valueOf(count) + lastConsecutiveCharacter); // Append the count and character before
																			// breaking out of the loop
			break;
		}
		char st = string.charAt(i); // Get the current character

		// If the current character is the same as the last consecutive character and
		// count is less than 9,
		// increment the count
		if (st == lastConsecutiveCharacter && count < 9) {
			count++;
		} else {
			// Otherwise, append the count and the last consecutive character to the
			// StringBuilder,
			// then reset the count to 1
			sb.append(String.valueOf(count) + lastConsecutiveCharacter);
			count = 1;
		}

		// Update the lastConsecutiveCharacter to the current character for the next
		// iteration
		lastConsecutiveCharacter = st;
	}

	return sb.toString(); // Return the encoded string
}