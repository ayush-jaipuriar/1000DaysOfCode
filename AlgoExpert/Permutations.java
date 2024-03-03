import java.util.*;

public class Permutations {
    // Upper Bound: O(n^2*n!) time | O(n*n!) space
    // Roughly: O(n*n!) time | O(n*n!) space

    // This is the main function to get all permutations of the given array
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutations = new ArrayList<List<Integer>>();
        // Initiating recursive function to generate permutations
        getPermutations(array, new ArrayList<Integer>(), permutations);
        return permutations;
    }

    // Recursive function to generate permutations
    public static void getPermutations(List<Integer> array, List<Integer> currentPermutation,
            List<List<Integer>> permutations) {
        // Base case: if the original array is empty and current permutation is not, add
        // it to the list of all permutations
        if (array.size() == 0 && currentPermutation.size() > 0) {
            permutations.add(currentPermutation);
        } else {
            for (int i = 0; i < array.size(); i++) {
                // Creating a new array excluding the current element for the next recursive
                // call
                List<Integer> newArray = new ArrayList<Integer>(array);
                newArray.remove(i);

                // Creating a new permutation including the current element
                List<Integer> newPermutation = new ArrayList<Integer>(currentPermutation);
                newPermutation.add(array.get(i));

                // Recursive call with updated array and permutation
                getPermutations(newArray, newPermutation, permutations);
            }
        }
        return;
    }

    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<List<Integer>> resultList = getPermutations(array);
        for (List<Integer> list : resultList) {
            System.out.println(list.toString());
        }
    }

}
