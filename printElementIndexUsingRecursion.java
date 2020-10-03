public class Main {
    static void printIndex(int[] arr, int i, int x) {
        if (arr.length==i) {
            return;
        }
        if (arr[i]==x) {
            System.out.println(i);
        }
        printIndex(arr, i+1, x);
        return;
    }
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,5,3,5,3};
        printIndex(arr, 0, 3);
    }
}
