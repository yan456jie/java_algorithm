package baidu;

import java.util.HashSet;
import java.util.Scanner;

public class Main {
	private double maxSubArray(int n, double a[]) {
		double b = 0, sum = -1000;
		for (int i = 0; i < n; i++) {
			if (b > 0)
				b += a[i];
			else
				b = a[i];
			if (b > sum)
				sum = b;
		}
		return sum;
	}

	private double maxSubMatrix(int n, int m, double[][] array) {
		int i, j, k;
		double max = 0, sum = -1000;
		double b[] = new double[m];
		for (i = 0; i < n; i++) {
			for (k = 0; k < m; k++){
				b[k] = 0;
			}
			for (j = i; j < n; j++){
				for (k = 0; k < m; k++) {
					b[k] += array[j][k];
				}
				max = maxSubArray(k, b);
				if (max > sum) {
					sum = max;
				}
			}
		}
		return sum;
	}

	public static void main(String args[]) {
		Main p = new Main();
		Scanner sc = new Scanner(System.in);
		if (sc.hasNext()) {
			int line_num = sc.nextInt();
			while (line_num > 0) {
				int n = sc.nextInt();
				int m = sc.nextInt();
				double[][] array = new double[n][m];
				for (int i = 0; i < n; i++) {
					for (int j = 0; j < m; j++) {
						double t = sc.nextDouble();
						array[i][j] = t;
					}
				}
				System.out.println(p.maxSubMatrix(n, m , array));
			}

		}
	}
}
