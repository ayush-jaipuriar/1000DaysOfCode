public static int[] bubbleSort(int[] array) {
    int n = array.length;
    boolean performedSort = false; // Flag to check if any swap was made during the inner loop iteration

    // Outer loop runs n times where n is the length of the array
    for (int i = 0; i < n; i++) {
        performedSort = false; // Reset the flag for each outer loop iteration

        // Inner loop compares adjacent elements and swaps them if they are in the wrong order
        for (int j = 0; j < n - i - 1; j++) {
            if (array[j] > array[j + 1]) {
                // Swap elements if the current element is greater than the next one
                int temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;

                // Set the flag to true if a swap was made
                performedSort = true;
            }
        }

        // If no swaps were made during the inner loop iteration, it means the array is already sorted
        // So, there's no need to continue sorting
        if (!performedSort) {
            break;
        }
    }

    return array; // Return the sorted array
}