package test;

import java.util.Scanner;
//3 1
//4 3
public class ABGame {
	public static void main(String[] args) {
		getBestA();
	}
	public static void getBestA(){
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int b = in.nextInt();
			int tmp = 0;
			int a = 0;
			int a_v = 0;
			int b_v = 0;
			for (int i = 1; i <= n; i++) {
				a_v = 0;
				b_v = 0;
				for (int j = 1; j <= n; j++) {
					if ((int) Math.abs(a - j) < (int) Math.abs(b - j)) {
						a_v++;
					} else {
						b_v++;
					}
				}
				if ((a_v - b_v) >= tmp) {
					tmp = a_v - b_v;
					a = i;
				}
			}
			System.out.println(a);
		}
	}
}
