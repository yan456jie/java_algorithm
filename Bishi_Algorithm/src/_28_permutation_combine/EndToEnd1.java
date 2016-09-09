package _28_permutation_combine;

import java.util.Arrays;

public class EndToEnd1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String [] str = {"ad","dg","gj","jl"};
		String [] str = {"gj","jl","dg","ad"};
		//System.out.println(judge("aa", "dd"));
		
		fun(str, 0);
	}

	public static void fun(String [] str, int k){
		if(k==str.length){
			int i=0;
			for(; i<str.length-1; i++){
				if(judge(str[i], str[i+1])){
					if(i==str.length-2){
						System.out.println(Arrays.toString(str));
					}
				}else{
					break;
				}
			}
			return;
		}
		
		for(int i=k; i<str.length; ++i){
			//½»»»k+1ºÍi
			swap(str, k, i);			
			fun(str, k+1);
			swap(str, k, i);
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
