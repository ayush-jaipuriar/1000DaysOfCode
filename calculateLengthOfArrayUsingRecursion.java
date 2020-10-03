public class Main {
    static int calculateLength(int[] arr, int i) {
        if (i==arr.length) {
            return 0;
        }
        return 1+calculateLength(arr, i+1);
    }
  
    public static void main(String args[]) {
        int[] arr = {1,2,3,4,5};        
        System.out.println(calculateLength(arr,0));
    }
}
