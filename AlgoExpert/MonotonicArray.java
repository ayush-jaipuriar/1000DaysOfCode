class Program {
    // Time Complexity: O(n) where n is the length of the array
    // Space Complexity: O(1)
    public static boolean isMonotonic(int[] array) {
       boolean isNonIncreasing = true;
       boolean isNonDecreasing = true;
       for (int i=1; i<array.length; i++) {
         if (array[i] < array[i-1]) { // 2 1
           // Case : Non Increasing Array
           isNonDecreasing = false;
         } else if (array[i] > array[i-1]) { // 1 2
           // Case : Non Decreasing Array
           isNonIncreasing = false;
         }
       }
       return isNonIncreasing || isNonDecreasing;
    }
   }