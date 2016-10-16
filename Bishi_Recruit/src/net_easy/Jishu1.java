package net_easy;

import java.util.Scanner;

public class Jishu1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			long starTime=System.currentTimeMillis();
			int rr = sc.nextInt();
			int count = allOdd(rr);
			System.out.println(count);
			long endTime=System.currentTimeMillis();
			long Time=endTime-starTime;
			System.out.println(Time);
		}
	}
	public static int allOdd(int n){
		int sum = 0;
		int[] num_odd = new int[n+1];
		
		for(int i=1; i<=n; i++){
			if((i&1)==1){
				num_odd[i]=i;
			}else{
				num_odd[i]=1;
			}
		}
		int t = 3;
		//t = t<<1;
		while((t<<1)<n){
			num_odd[t<<1]=t;
			t = t<<1;
		}
		for(int i=1; i<=n; i++){
			System.out.println(num_odd[i]);
			sum+=num_odd[i];
		}
		
		return sum;
	}
	public static int maxDivisionOdd(int m){
		if(m<1 || m>1000000000){
			return 0;
		}
		int k = m;
		if((k&1)==1)
			return k;
		else{
			--k;
		}
		
		while(k>0 && m%k!=0){
			k=k-2;
		}
		return k;
	}
}
