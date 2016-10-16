package shunfeng;

import java.util.Arrays;
import java.util.Scanner;
/*
 * 顺丰科技笔试题：切分一个数12346，切分成若干份，使得其和接近且不大于m（50）
 */
public class SplitData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		split("12346", "", 1, 0);
		System.out.println(sum);
		System.out.println(result);
	}
	
	public static void splitNum(int n, int m){
		String s = n+"";
		int l = s.length();//切分次数为0-(l-1)
		for(int i=0; i<l; i++){
			//切分第i次的时候
		}
	}
	String s = "";
	static int sum = 0;
	static int m = 50;
	static String result = "";
	public static void split(String s, String t_result, int k, int t_sum){
		if(k>=s.length()){
			t_sum = Integer.parseInt(s.substring(0))+t_sum;
			t_result = t_result+" "+s;
			if(t_sum>m){
				return;
			}else if(t_sum<=m && t_sum>sum){
				sum = t_sum;
				result = t_result;
			}
			return;
		}
		//切
		int a1 = Integer.parseInt(s.substring(0, k));
		split(s.substring(k), t_result+" "+a1, 1, t_sum+a1);
		//不切
		split(s, t_result, k+1, t_sum);
	}
}
/*
1
5 3
aaaaaa
aaabbb
ababab
dddd
dddd
aaaa
aaa
ax
*/
