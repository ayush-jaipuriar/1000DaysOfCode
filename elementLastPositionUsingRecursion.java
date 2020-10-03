public class Main {
    static int lastPosition(int[] arr, int i, int x) {
        if (i==-1) {
            return -1;
        }
        if (arr[i]==x) {
            return i;
        }
        return lastPosition(arr, i-1, x);
    }
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,5,3,5,3};
        int elementLastPosition = lastPosition(arr, arr.length-1, 2);
        System.out.println(elementLastPosition);
    }
}
