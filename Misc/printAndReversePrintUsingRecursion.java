public class Main {
    static void print(int[] arr, int i) {
        if (i==arr.length) {
            return;
        }
        System.out.println(arr[i]);
        print(arr, i+1);
        return;
    }
    static void reversePrint(int[] arr, int i) {
        if(i==arr.length) {
            return;
        }
        reversePrint(arr,i+1);
        System.out.println(arr[i]);
    }
    public static void main(String args[]) {
        int[] arr = {1,2,3};
        print(arr,0);
        reversePrint(arr, 0);
    }
}
