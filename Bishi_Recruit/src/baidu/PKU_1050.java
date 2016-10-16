package baidu;

import java.util.Scanner;

public class PKU_1050 {
	private int maxSubArray(int n, int a[]) {
		int b = 0, sum = -10000000;
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

	private int maxSubMatrix(int n, int m, int[][] array) {
		int i, j, k, max = 0, sum = -100000000;
		int b[] = new int[101];
		for (i = 0; i < n; i++) {
			for (k = 0; k < m; k++)// 初始化b[]
			{
				b[k] = 0;
			}
			for (j = i; j < n; j++)// 把第i行到第j行相加,对每一次相加求出最大值
			{
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
		PKU_1050 p = new PKU_1050();
		Scanner cin = new Scanner(System.in);
		int n = 1, m=5;
		int[][] array = {{2,3,-19,1,1}};
		System.out.println(p.maxSubMatrix(n, m , array));
	}
}
