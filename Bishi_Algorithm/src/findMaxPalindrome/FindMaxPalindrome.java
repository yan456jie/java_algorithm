package findMaxPalindrome;

import java.util.Stack;

/**
 * 找到最大回文
 * @author root
 */
public class FindMaxPalindrome {

	//static String ss = "aaabcadasabcddcbaddbc";
	static String ss = "sogou";
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		find(ss.toCharArray());
	}
	public static void find(char []s){
		int max_l = 1;
		for(int i=0,j=0,k=0; k<s.length; k++){
			//char c = ss.charAt(k);
			int cur_l = 0;
			i=k+1;
			j=k-1;
			while(i<s.length && j>=0 && s[i]==s[j]){
				cur_l++;
				i++;
				j--;
			}
			if(cur_l>max_l){
				max_l = cur_l;
			}
			cur_l = 0;
			i=k+1;
			j=k;
			while(i<s.length && j>=0 && s[i]==s[j]){
				cur_l++;
				i++;
				j--;
			}
			if(cur_l>max_l){
				max_l = cur_l;
			}
		}
		System.out.println(max_l);
	}
}
