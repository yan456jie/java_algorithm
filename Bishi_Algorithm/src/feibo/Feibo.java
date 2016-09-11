package feibo;

public class Feibo {
	static int ss = 50;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(feibo1(ss));
	}
	//递归法求解
	public static double feibo(int n){
		double result = 0;
		if(n>2){
			result = feibo(n-1) + feibo(n-2);
		}else if(n==2){
			result = 2;
		}else if(n==1){
			result = 1;
		}
		return result;
	}
	//定义两个变量记录
	public static double feibo1(int n){
		double data1 = 1;
		double data2 = 2;
		double result = 0;
		double t=3;
		while(t<=n){
			result = data1 + data2;
			data1 = data2;
			data2 = result;
			t++;
		}
		
		return result;
	}
	//定义一个数组记录
	static double data[] = new double[ss+1];
	public static double feibo2(int n){
		data[1] = 1;
		data[2] = 2;
		int t=3;
		while(t<=n){
			data[t] = data[t-1] + data[t-2];
			t++;
		}
		
		return data[n];
	}
}
