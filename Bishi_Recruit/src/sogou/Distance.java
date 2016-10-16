package sogou;

import java.util.Arrays;
import java.util.Scanner;

public class Distance {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int[]data = new int[n];
			for(int i=0; i<n ;i++){
				data[i] = sc.nextInt();
			}
			int sum = ComputetDistance(data);
			System.out.println(sum);
		}
	}
	public static int ComputetDistance(int[] data){
		if(data.length<2){
			return 0;
		}
		int[]distance = new int[data.length-1];
		
		for(int i=0; i<data.length-1 ;i++){
			distance[i] = nearDistance(data[i], data[i+1]);
		}
		int k=1;
		int sum=0;
		for(int i=0; i<distance.length; i++){
			for(int j=i; j<distance.length; j++){
				sum+=twoDistance(distance, i, j);
			}
		}
		return sum;
	}
	public static int twoDistance(int[]distance, int l, int r){
		if(l==r){
			return distance[l];
		}
		int sum=0;
		for(int i=l; i<=r; i++){
			sum+=distance[i];
		}
		return sum;
	}
	public static int nearDistance(int m1, int m2){
		int t = m1+1;
		int c = 0;
		while(t<m2){
			if(isPrime(t)){
				++c;
			}
			++t;
		}
		return c;
	}
	//判断是否是质数
    public static boolean isPrime(int a) {  
        boolean flag = true;  
        if (a < 2) {
            return false;  
        } else {
            for (int i = 2; i <= Math.sqrt(a); i++) {  
                if (a % i == 0) {
                    flag = false;  
                    break;
                }
            }
        }
        return flag;  
    }
}
