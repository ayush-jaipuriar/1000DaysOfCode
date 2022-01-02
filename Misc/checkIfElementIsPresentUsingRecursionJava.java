public class Main {
    static boolean isPresent(int[] arr, int i, int x) {
        if (i==arr.length) {
            return false;
        }
        if (arr[i]==x) {
            return true;
        }
        return isPresent(arr, i+1, x);
    }
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,52};
        boolean isElementPresent = isPresent(arr, 0, 124);
        System.out.println(isElementPresent);
    }
}
