public class Main {
    static int calculateSum(int[] arr, int i) {
        if (i==arr.length) {
            return 0;
        }
        return arr[i]+calculateSum(arr, i+1);
    }
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,52};
        int sum = calculateSum(arr, 0);
        System.out.println(sum);
    }
}
