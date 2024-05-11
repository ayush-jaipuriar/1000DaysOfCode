import java.util.*;

class Program {
    // Time Complexity : O(n log n)
    // Space Complexity : O(n); n is the length of the dishes array
    public int[] sweetAndSavory(int[] dishes, int target) {
        List<Integer> sweetList = new ArrayList<>();
        List<Integer> savoryList = new ArrayList<>();

        for (int i = 0; i < dishes.length; i++) {
            int currentElement = dishes[i];
            if (currentElement < 0) {
                sweetList.add(currentElement);
            } else {
                savoryList.add(currentElement);
            }
        }

        Collections.sort(sweetList, Comparator.comparingInt(Math::abs));
        Collections.sort(savoryList, Comparator.naturalOrder());

        int bestDifference = Integer.MAX_VALUE;
        int[] resultList = new int[2];
        int sweetIndex = 0;
        int savoryIndex = 0;

        while (sweetIndex < sweetList.size() && savoryIndex < savoryList.size()) {
            int currentSweetDish = sweetList.get(sweetIndex);
            int currentSavoryDish = savoryList.get(savoryIndex);
            int currentSum = currentSweetDish + currentSavoryDish;

            if (currentSum <= target) {
                int currentDifference = target - currentSum;
                if (currentDifference < bestDifference) {
                    bestDifference = currentDifference;
                    resultList = new int[] { currentSweetDish, currentSavoryDish };
                }
                savoryIndex++;
            } else {
                sweetIndex++;
            }
        }

        return resultList;
    }
}
