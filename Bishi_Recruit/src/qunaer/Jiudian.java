package qunaer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Jiudian {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] temp = line.split(" ");
			int n = temp.length;
			//int[] price = new int[n-1];
			List<Integer> price = new ArrayList<Integer>();
			for(int i=0; i<n-1; i++){
				price.add(Integer.parseInt(temp[i]));
			}
			int money = Integer.parseInt(temp[n-1]);
			System.out.println(minDay(price, money));
		}
	
	}
	public static int minDay(List<Integer> price, int money){
		Collections.sort(price);
		int n = price.size();
		for(int i=1; i<=n; i++){
			
		}
		return -1;
	}
	public static boolean combine(List<Integer> price, int k){
		int n = price.size();
		for(int i=0; i<n; i++){
			
		}
		return false;
	}
}
