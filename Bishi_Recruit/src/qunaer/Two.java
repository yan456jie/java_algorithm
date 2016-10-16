package qunaer;

import java.util.Scanner;


public class Two {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int num = sc.nextInt();
			System.out.println(isTwoPower(num));
		}
	
	}
	public static boolean isTwoPower(int num){
		return (num > 0) && ((num & (num - 1)) == 0);
	}
}
