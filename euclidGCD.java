package com.company;
import java.io.*;
import java.util.*;
public class Main {
    static int findGCD(int n1, int n2) {
        int a=n1;
        int b=n2;
        if (b==0) {
            return a;
        }
        return findGCD(n2, n1%n2);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();
        System.out.println(findGCD(n1, n2));
    }
}
