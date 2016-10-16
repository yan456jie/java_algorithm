package didi;

import java.util.Scanner;

public class CountZero {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int c = findFive(n);
			System.out.println(c);
		}
	}
	public static int findFive(int n){
		if(n<5 || n>1000){
			return 0;
		}
		int m=0,c=0,t=0;
		while(n%5!=0){
			--n;
		}
		m=n;
		while(m>=5){
			t = m/5;
			c+=t;
			m=t;
		}
		return c;
	}
}
