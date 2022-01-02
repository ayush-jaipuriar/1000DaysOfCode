public class Main {
    static int firstIndex(int[] arr, int i, int x) {
        if (arr.length==0) {
            return -1;
        }
        if (i==arr.length) {
            return -1;
        }
        if (arr[i]==x) {
            return i;
        }
        return firstIndex(arr, i+1, x);
    }
    public static void main(String args[]) {
        int[] arr = {1,2,4,52,12};
        int firstIndexOfElement=firstIndex(arr, 0, 3);
        System.out.println(firstIndexOfElement);
    }
}
