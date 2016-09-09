package _12_printOneToN;
/**
 * 打印1-3位的数字,使用类似全排列方法
 * 每次递归都循环取0-9，输出时移除首位0
 * @author yanjie
 *
 */
public class PrintOneToN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data={'0','1','2','3','4','5','6','7','8','9'};
		int n = 2;
		fun(data, "", 1, n);
	}
	/**
	 * 
	 * @param data 数组
	 * @param s 临时字符串，s=s+data[n],结束条件n>k
	 * @param k 递归多少次，从1开始
	 * @param n 递归深度,表示位数
	 */
	public static void fun(char[] data,String s, int k, int n){
		if(k>n){
			System.out.print(rmZero(s)+" ");
			return;
		}
		for(int i=0; i<data.length; i++){
			fun(data, s+data[i], k+1, n);
		}
	}
	/*
	 * 移除首位的0
	 */
	public static String rmZero(String s){
		int index = 0;
		while(index<s.length() && s.charAt(index)=='0'){
			index++;
		}
		return s.substring(index);
	}
}
