import java.util.*;
class PriorityQueueExample {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int k = 2;

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for (int i=0; i<array.length; i++) {
            pq.add(array[i]);

            if (pq.size() > k) {
                pq.poll();
            }
        }

        System.out.println(pq.toString());
    }
}