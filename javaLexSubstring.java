import java.util.Scanner;

public class Solution {

    public static String getSmallestAndLargest(String s, int k) {
        String smallest = s.substring(0, k);
        String largest = s.substring(0, k);
        
        for(int i = 0; i <= s.length() - k; i++){
            String sTemp = s.substring(i, i + k);
            if(sTemp.compareTo(smallest) < 0) {
                smallest = sTemp;
            }
               
            if(sTemp.compareTo(largest) > 0) {
                largest = sTemp;
            } 
        }
        
        return smallest + "\n" + largest;
    }

