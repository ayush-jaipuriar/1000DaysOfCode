public class Main {
    static int[] replaceElements(int[] arr, int i, int x) {
        if (i==arr.length) {
            return arr;
        }
        if (arr[i]==x) {
            arr[i]=5;            
        }
        return replaceElements(arr, i+1, x);
    }
  
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5,3,53};     
        arr = replaceElements(arr, 0,3);
        for (int i=0; i<arr.length; i++) {
            System.out.println(arr[i]);
        }
    }
}
