public int[] arrayOfProducts(int[] array) {
  int n = array.length; // Get the length of the input array

  // Initialize an integer array to store the products
  int[] productArray = new int[n];

  // Calculate the product of all elements to the left of each element
  int leftRunningProduct = 1; // Initialize the left running product to 1
  for (int i = 0; i < n; i++) { // Iterate through the array from left to right
      productArray[i] = leftRunningProduct; // Store the left running product in the product array
      leftRunningProduct *= array[i]; // Update the left running product by multiplying it with the current element
  }

  // Calculate the product of all elements to the right of each element
  int rightRunningProduct = 1; // Initialize the right running product to 1
  for (int i = n - 1; i >= 0; i--) { // Iterate through the array from right to left
      productArray[i] *= rightRunningProduct; // Multiply the current element in the product array by the right running product
      rightRunningProduct *= array[i]; // Update the right running product by multiplying it with the current element
  }

  return productArray; // Return the final product array
}