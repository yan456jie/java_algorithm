package _43_touzi;

public class Touzi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sum = 0;
		int detph = 10;
		int [] data = new int[detph];
		//fun1(1, detph, sum, data);
		for(int i=1; i<=6; i++){
			data[detph-1] = i;
			fun1(i, detph, sum, data);
		}
		/**/
	}
	/*
	 * 只能求出点数和的可能
	 */
	public static void fun1(int k, int detph,int sum,int[] data){
		sum+=k;
		--detph;
		if(detph<=0){
			System.out.print(sum+"#");
			for(int i=0; i<data.length; i++){
				System.out.print(data[i]+" ");
			}
			System.out.println();
			return;
		}
		for(int i=k; i<=6; i++){
			data[detph-1] = i;
			fun1(i, detph, sum, data);
		}
	}
}
