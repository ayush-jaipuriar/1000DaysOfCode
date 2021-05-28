import java.util.*;

class Program {
  public static boolean isValidSubsequence(List<Integer> array, List<Integer> sequence) {
    // Write your code here.
		//Brute Force Method
		// I iterate through the subsequence array and increment the pointer to the last index of element found
		Integer currentArrayElement = 0;
		Integer currentSequenceElement = 0;
		int temp = 0;
		int j = 0;
		boolean didFind = false;
		for (int i=0; i<sequence.size(); i++) {
			currentSequenceElement = sequence.get(i);			
			didFind = false;		
			for (j=temp; j<array.size(); j++) {				
				currentArrayElement = array.get(j);				
				if (currentArrayElement == currentSequenceElement) {
					temp = j+1;
					didFind = true;
					break;
			}
		}		
    if (!didFind) {
			return false;
		}
  }
	return true;
}
}
