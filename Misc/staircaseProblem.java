import java.io.*;
import java.util.*;
public class Main {
    static int calculateJumps(int n) {
        if (n==0 || n==1) {
            return 1;
        }
        if (n<0) {
            return 0;
        }
        return calculateJumps(n-3)+calculateJumps(n-2)+calculateJumps(n-1);
    }
    public static void main(String args[]) {
        System.out.println(calculateJumps(4));
    }
}
