package tencent;

import java.util.Scanner;

public class Geohash {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(double i=-90; i<=90; i+=0.01){
			String code = encode(i);
			System.out.println(code);
		}
	}
	
	public static void test(){
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext()) {
			Double d = sc.nextDouble();
			String code = encode(d);
			System.out.println(code);
		}
	}
	
	public static String encode(Double d){
		if(d<-90 || d>90){
			return "";
		}
		StringBuilder result = new StringBuilder();
		double l=-90,r=90;
		double mid = (l+r)*1.0/2;
		while(Math.abs(mid-d)>0.6){
			if(d>=mid){
				result.append("1");
				l=mid;
			}else if(d<mid){
				result.append("0");
				r=mid;
			}
			mid = (l+r)*1.0/2;
		}
		
		return result.toString();
	}
}
