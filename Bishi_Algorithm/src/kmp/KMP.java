package kmp;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * 字符串匹配算法KMP，在s中匹配p
 * @author root
 *
 */
public class KMP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "bbcabcdababcdabcdabde";
		String s2 = "abcdabd";
		//strPattern1(s1.toCharArray(), s2.toCharArray());
		int []next = new int[s2.length()];
		nextArr(s2.toCharArray(), next);
		strPattern(s1.toCharArray(), s2.toCharArray(), next);
	}
	//暴力搜索匹配
	public static void strPattern1(char[] s1, char[] s2){
		int k=0;
		int i=0;
		int j=0;
		for(k=0; k<s1.length; k++){
			i=k;
			j=0;
			while(j<s2.length){
				if(s1[i]==s2[j]){
					if(j==(s2.length-1)){
						System.out.println(k);
						break;
					}
					++i;
					++j;
				}else{
					break;
				}
			}
			
		}
	}
	//kmp字符串匹配
	public static void strPattern(char[] s1, char[] s2, int []next){
		int k=0;
		int i=0;
		int j=0;
		while(k<s1.length){
			i=k;
			while(j<s2.length){
				if(s1[i]==s2[j]){
					if(j==(s2.length-1)){
						System.out.println(k);
						break;
					}
					++i;
					++j;
				}else{
					break;
				}
			}
			k+=j-next[j];
			j=0;
		}
	}
	//求解next数组
	public static void nextArr(char[] s, int []next){
		next[0] = -1;
		for(int i=1; i<s.length; i++){
			int c = prefix(new String(s).substring(0, i));
			next[i] = c;
		}
		//System.out.println(Arrays.toString(next));
	}
	//寻找最长相等的前缀和后缀
	public static int prefix(String s){
		char []s1=s.substring(0, s.length()/2).toCharArray();
		char []s2=s.substring(s.length()/2, s.length()).toCharArray();
		int i=0,j=0;
		int c=0;
		while(i<s1.length && j<s2.length){
			if(s1[i]==s2[j]){
				++i;
				++j;
				++c;
			}else{
				c=0;
				i=0;
				++j;
			}
		}
		//System.out.println(c);
		return c;
	}
}
