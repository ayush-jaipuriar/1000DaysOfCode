public class Main {
    static boolean checkPalindrome(int[] arr, int start, int end) {
        if (start>end) {
            return true;
        }
        if (arr[start]==arr[end]) {
            return checkPalindrome(arr, start+1, end-1);
        } else {
            return false;
        }
    }
    public static void main(String args[]) {
        int[] arr = {1,2,1};
        System.out.println(checkPalindrome(arr, 0, arr.length-1));
    }
}
