import java.util.*;

class Program {
  // Time Complexity : O(n)
  // Space Complexity : O(n) where n is the length of the input array
  public int[] arrayOfProducts(int[] array) {
    int n = array.length;
    int[] productArray = new int[n];

    // Calculating left array product 
    int leftRunningProduct = 1;
    for (int i=0; i<n;i++) {
      productArray[i] = leftRunningProduct;
      leftRunningProduct *= array[i];
    }

    // Calculating the right array product, storing inside same product array
    int rightRunningProduct = 1;
    for (int i=n-1;i>=0;i--) {
      productArray[i] *= rightRunningProduct;
      rightRunningProduct *= array[i];
    }

    return productArray;
  }
}
