package _28_permutation_combine;

import java.util.Arrays;
/** 
 * 给定字符串数组{"gj","jl","dg","ad","gg"} 
 * 是首尾相连的[ad, dg, gg, gj, jl]
 * @author yanjie 
 * 
 */
public class EndToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String [] str = {"ad","dg","gj","jl"};
		String [] str = {"gj","jl","dg","ad","gg"};
		//System.out.println(judge("aa", "dd"));
		fun(str, 0);
	}

	public static void fun(String [] str, int k){
		if(k==str.length){
			System.out.println(Arrays.toString(str));
			return;
		}
		
		for(int i=k; i<str.length; ++i){
			//交换k+1和i
			//k=0,表明为第一个字符串，必须和自己以及后面每一个交换
			//k>0时，假设0-(k-1)是排序好的，我们需比较k-1和i的顺序
			if(k>0 && judge(str[k-1], str[i])){
				swap(str, k, i);
				fun(str, k+1);
				swap(str, k, i);
			}else if(k==0){
				swap(str, k, i);
				fun(str, k+1);
				swap(str, k, i);
			}
		}
	}
	private static void swap(String[] a, int s, int i) {		
		String t = a[s];
		a[s] = a[i];
		a[i] = t;
	}
	public static boolean judge(String s1, String s2){
		if(s1.charAt(s1.length()-1)==s2.charAt(0)){
			return true;
		}
		return false;
	}
}
