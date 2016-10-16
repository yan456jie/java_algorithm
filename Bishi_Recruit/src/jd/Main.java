package jd;

import java.util.Scanner;
/*
 * һȦСɽ��
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		while(sc.hasNext()) {
			int num = sc.nextInt();
			int [] high = new int[num];
			for(int i=0; i<num; i++) {
				high[i] = sc.nextInt();
			}
			computePair(high);
		}
	
	}
	public static int computePair(int [] high) {
		int count = 0;
		for(int i=0; i<high.length; i++){
			for(int j=i+1; j<high.length; j++){
				//������ͷ������ж�
				boolean ispair = isPair(high, i, j);
				if(ispair){
					++count;
				}
			}
		}
		System.out.println(count);
		return count;
	}
	/*
	 * �ж��������Ƿ���һ��
	 */
	public static boolean isPair(int [] high, int i, int j){
		boolean front = true;//����
		boolean back = true;//����
		if(Math.abs(i-j)==1){
			return true;
		}else{
			int k=i+1;
			while(k<j){
				if(high[k]>high[i] || high[k]>high[j]){
					front = false;
					break;
				}
					
				k++;
			}
			k=i-1;
			k=(high.length+k)%high.length;
			while(k!=j){
				if(high[k]>high[i] || high[k]>high[j]){
					back = false;
					break;
				}
					
				k--;
				k=(high.length+k)%high.length;
			}
		}
		
		return front | back;
	}
}
