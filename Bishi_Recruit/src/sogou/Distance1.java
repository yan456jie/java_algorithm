package sogou;

import java.util.Arrays;
import java.util.Scanner;

public class Distance1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = { 3, 4, 6, 12 };
		int num = a.length * (a.length - 1) / 2;
		double[][] s = new double[a.length][a.length];

		for (int i = 0; i < a.length - 1; i++) {
			for (int j = i + 1; j < a.length; j++) {
				s[i][j] = dis(a[i], a[j]);
			}
		}
		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				System.out.print(s[i][j] + " ");
			}
			System.out.print("\n");
		}
	}

	private static double dis(int i, int j) {
		// TODO Auto-generated method stub
		int count = 0;
		int k = Math.min(i, j) + 1;
		for (; k < Math.max(i, j); k++) {
			if (isPrime(k)) {
				count++;
				System.out.println(i + " " + j + " " + k + " ");
			}
		}
		return count;
	}

	private static boolean isPrime(int k) {
		// TODO Auto-generated method stub
		for (int i = 2; i < k; i++) {
			if (k % i == 0)
				return false;
		}
		return true;
	}
}