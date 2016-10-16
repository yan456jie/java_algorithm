package qunaer;

import java.util.Scanner;

public class NumComberAll {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] temp = line.split("\\s+");
			int n = temp.length;
			if(n<=1){
				System.out.println(-1);
				continue;
			}
			int[] price = new int[n-1];
			for(int i=0; i<n-1; i++){
				price[i] = Integer.parseInt(temp[i]);
				result+= "1";
			}
			result+= "1";
			int money = Integer.parseInt(temp[n-1]);
			
			String b = "";
			minDay(price, b, n-1, 0, money);
			if(result.length()<n){
				System.out.println(result.length());
			}else{
				System.out.println(-1);
			}
			
		}
	}
	static String result = "";
	//µÝ¹éËÑË÷
	public static void minDay(int a[],String b, int length, int  i, int s)
	{
		String temp = b;
		if(s==0 && temp.length()<result.length()){
			//System.out.println(temp);
			result = temp;
		}
		if(i>=length)
			return;
		minDay(a, temp, length, i+1, s);
		temp=temp+"1";
		minDay(a, temp, length, i+1, s-a[i]);
	}
}
/*

700 300 1001 1000
700 100 200 700 1000
700 300 1001 1000
1001 300 1001 1000
1 2 3 4 5 5
2 3 5 5
1 2 3 4 5
1 1 1 1 4 4
1 2 4 3 5
1000
*/