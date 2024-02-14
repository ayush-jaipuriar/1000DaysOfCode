package com.codeforces;

import java.util.Scanner;

public class CreateExpressions1 {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int N = scanner.nextInt();
		int X = scanner.nextInt();
		int[] A = new int[N];
		for (int i = 0; i < N; i++) {
			A[i] = scanner.nextInt();
		}
		if (canCreateExpression(A, 0, 0, X)) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

	private static boolean canCreateExpression(int[] A, int i, int currentSum, int target) {
		if (i == A.length) {
			return currentSum == target;
		}
		// Explore '+' option
		if (canCreateExpression(A, i + 1, currentSum + A[i], target)) {
			return true;
		}
		// Explore '-' option
		if (canCreateExpression(A, i + 1, currentSum - A[i], target)) {
			return true;
		}
		return false;
	}

}
