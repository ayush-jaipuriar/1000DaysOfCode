package JavaTheory;

import java.util.*;

public class PermutationsSwapMethod {
    /**
     * Generates all permutations of the given array.
     * 
     * @param array The input array.
     * @return List of all permutations.
     */
    public static List<List<Integer>> getPermutations(List<Integer> array) {
        List<List<Integer>> permutationsList = new ArrayList<>();
        // Calling the recursive helper method to get permutations
        // with initial index of i = 0, array as initial input array, and
        // permutationsList as an empty list
        getPermutationsHelper(0, array, permutationsList);
        return permutationsList;
    }

    /**
     * Recursive helper function to generate permutations using backtracking.
     * 
     * @param i                Current index.
     * @param array            The input array.
     * @param permutationsList List to store permutations.
     */
    public static void getPermutationsHelper(int i, List<Integer> array, List<List<Integer>> permutationsList) {
        // Base Case: If the current index is equal to the size of the array - 1,
        // it means our permutation step is complete
        if (i == array.size() - 1) {
            permutationsList.add(new ArrayList<>(array));
        } else {
            for (int j = i; j < array.size(); j++) {
                // Swapping elements at indices i and j
                swap(array, i, j);

                // Recursively calling getPermutationsHelper with next index
                getPermutationsHelper(i + 1, array, permutationsList);

                // Backtracking by swapping elements back to their original positions
                swap(array, i, j);
            }
        }
        return;
    }

    /**
     * Helper function to swap elements in the array.
     * 
     * @param array The input array.
     * @param i     Index of the first element.
     * @param j     Index of the second element.
     */
    public static void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }


    public static void main(String[] args) {
        List<Integer> array = new ArrayList<>(Arrays.asList(1,2,3));
        List<List<Integer>> permutationsList = getPermutations(array);
        for (List<Integer> list : permutationsList) {
            System.out.println(list.toString());
        }
    }
}
