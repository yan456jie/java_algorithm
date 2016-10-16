package huawei;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class RemoveChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String src_str = "aabcdefff";
		Scanner sc = new Scanner(System.in);
	    String s = sc.next();
		fun1(s);
	}
	
	public static String fun1(String src_str) {
		String tar_str = "";
		
		char [] str = new char[26];
		Arrays.fill(str, '-');
		char [] s = src_str.toCharArray();
		
		for(int i=0; i<s.length; i++){
			str[(s[i]-'a')] = s[i];
		}
		for(int i=0; i<str.length; i++){
			if(str[i]!='-'){
				System.out.print(str[i]);
			}
		}
		return tar_str;
	}
	public static String fun2(String src_str) {
		String tar_str = "";
		Set set = new HashSet();
		char [] s = src_str.toCharArray();
		for(char c:s){
			set.add(c);
		}
		System.out.println(set.toString());
		return tar_str;
	}
}
