import java.util.*;

class Program {
    // Array Based Solution
    // Time Complexity : O(n)
    // Space Complexity : O(n); n is the number of elements in the buildings array
    public ArrayList<Integer> sunsetViews(int[] buildings, String direction) {
        ArrayList<Integer> resultList = new ArrayList<>();
        int step = 0;
        int startIndex = 0;
        int n = buildings.length;
        // We will traverse in direction opposite to the given direction
        // so that we can maintain the correct maxBuildingSize
        if (direction.equals("EAST")) {
            step = -1;
            startIndex = n - 1;
        } else {
            step = 1;
        }

        int maxBuildingSize = 0;
        int currentBuildingSize = 0;
        int currentIndex = startIndex;

        // Traversing the array
        while (currentIndex < n && currentIndex >= 0) {
            currentBuildingSize = buildings[currentIndex];
            if (currentBuildingSize > maxBuildingSize) {
                resultList.add(currentIndex);
            }
            maxBuildingSize = Math.max(maxBuildingSize, currentBuildingSize);
            currentIndex += step;
        }

        // In the case of east, our resultList would be containing the answers in
        // reverse format since we traversed the array in a reversed order
        // Hence in this EAST case we will have to reverse our resultList since the
        // answer is expected to be in ascending order
        if (direction.equals("EAST")) {
            Collections.reverse(resultList);
        }

        return resultList;

    }
}
