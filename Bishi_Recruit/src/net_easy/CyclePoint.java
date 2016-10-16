package net_easy;

import java.util.Scanner;

public class CyclePoint {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int rr = sc.nextInt();
			int count = genterPoint(rr);
			System.out.println(count);
		}
	}
	public static int genterPoint(int rr){
		int r = (int) Math.floor(Math.sqrt(rr));
		int c = 0;
		for(int i=r; i>0; i--){
			double t = Math.sqrt(rr-i*i);
			double s = Math.abs(t - (int)t);
			if(s<0.000001){
				++c;
			}
		}
		return 4*c;
	}
}
