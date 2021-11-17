import java.util.ArrayList;
import java.util.Collections;

// Time Complexity : O(n log n)
// Space Complexity : O(1) assuming Arrays.sort() does in-place sorting under the hood

public class ClassPhoto {
	public boolean classPhoto(ArrayList<Integer> redShirtHeights, ArrayList<Integer> blueShirtHeights) {
		Collections.sort(redShirtHeights, Collections.reverseOrder());
		Collections.sort(blueShirtHeights, Collections.reverseOrder());
		boolean isRedFirst = false;
		// The shirt on the 1st row will be the one which has the tallest person
		if (redShirtHeights.get(0) > blueShirtHeights.get(0)) {
			isRedFirst = true;
		}
		for (int i = 0; i < redShirtHeights.size(); i++) {
			// Since we have array sorted in descending order, hence we can compare two
			// people from each shirt
			// starting from the tallest and check if they satisfy the 3rd criteria or not
			if (isRedFirst && redShirtHeights.get(i) <= blueShirtHeights.get(i)) {
				return false;
			} else if (!isRedFirst && redShirtHeights.get(i) >= blueShirtHeights.get(i)) {
				return false;
			}
		}
		return true;
	}

}
