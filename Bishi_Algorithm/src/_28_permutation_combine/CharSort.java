package _28_permutation_combine;

import java.util.ArrayList;
import java.util.List;

/**
 * 组合
 * @author root
 *
 */
public class CharSort {

	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String ss = "abc";
		char[] st = new char[10];
		//几位的组合
		int w = 2;
		sort(ss, 0, 0, w, st);
	}
	//所有2位的组合,不存在重复字符
	public static void sort(String ss, int k, int c, int w, char[] st){
		if(c>=w){
			System.out.println(st);
			return;
		}
		for(int i=k; i<ss.length(); i++){
			st[c] = ss.charAt(i);
			sort(ss, i+1, c+1, w, st);
		}
	}
}
