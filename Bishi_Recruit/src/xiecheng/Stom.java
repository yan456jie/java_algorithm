package xiecheng;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Stom {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int [] price = {2,3,2,4};
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String line = sc.nextLine();
			String[] str = line.split(",");
			int [] price = new int[str.length];
			for (int i = 0; i < str.length; i++) {  
	        	price[i] = Integer.parseInt(str[i]);
	        }
			int max = getMaxGain(price);
			System.out.println(max);
		}
	}
	public static int getMaxGain(int [] price){
		int max = -1,temp=0;
		for(int i=0; i<price.length; i++){
			for(int j=i; j<price.length; j++){
				temp = price[j]-price[i];
				if(temp>max){
					max = temp;
				}
			}
		}
		
		return max;
	}
}
