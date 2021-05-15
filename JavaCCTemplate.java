import java.io.*;
import java.util.*;

class pintuAndFruits {
    public static void main(String[] args) throws Exception {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String input1 = in.readLine();
        if (input1 != null) {
            int t = Integer.parseInt(input1);
            for (int z = 0; z < t; z++) {
                String input2 = in.readLine();
                String[] input2Array = input2.trim().split("\\s+");
                int n = Integer.parseInt(input2Array[0]);
                int m = Integer.parseInt(input2Array[1]);
                String input3 = in.readLine();
                String[] input3Array = input3.trim().split("\\s+");
                int[] f = new int[n];
                for (int i = 0; i < n; i++) {
                    f[i] = Integer.parseInt(input3Array[i]);
                }
                String input4 = in.readLine();
                String[] input4Array = input4.trim().split("\\s+");
                int[] p = new int[n];
                Map<Integer, Integer> hash = new HashMap<>();
                for (int i = 0; i < n; i++) {
                    if (hash.get(f[i]) == null) {
                        hash.put(f[i], 0);
                    }
                }
                for (int i = 0; i < n; i++) {
                    p[i] = Integer.parseInt(input4Array[i]);
                    hash.put(f[i], hash.get(f[i]) + p[i]);
                }
                int min = Integer.MAX_VALUE;
                for (Map.Entry<Integer, Integer> val : hash.entrySet()) {
                    min = Math.min(min, val.getValue());
                }
                System.out.println(min);

            }
        }

    }
}
