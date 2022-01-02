import java.io.*;
import java.util.*;
public class Main {
    static int lastDigit=0;
    static int convertToInteger(String st,int i, int result) {        
        if (i==st.length()) {
            return result;
        }
        lastDigit = 10*lastDigit+(st.charAt(i)-'0');        
        return convertToInteger(st, i+1, lastDigit);
    }
    public static void main(String args[]) {
        String st="122313";
        int convertedNum = convertToInteger(st, 0, lastDigit);
        System.out.println(convertedNum);
    }
}
