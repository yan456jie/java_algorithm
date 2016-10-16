package jinritoutiao;

import java.util.Scanner;

public class Shift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		String s = "";
		while(sc.hasNext()) {
			s = sc.nextLine();
			shiftCount1(s.toCharArray());
		}
		
	}
	public static void shiftCount(String s){
		int c = 0;
		int len = s.length();
		String l = "", r = "";
		for(int i=0; i<len; i++){
			l = s.substring(0, i);
			r = s.substring(i, len);
			if(s.equals(r+l)){
				++c;
			}
		}
		System.out.println(c);
	}
	
	public static void shiftCount(char[] s){
		int c = 0;
		int end = s.length-1;
		reverse(s, 0, end);
		
		String l = "", r = "";
		for(int i=0; i<=end; i++){
			reverse(s, 0, end-i);
			reverse(s, end-i+1, end);
			if(s.equals(r+l)){
				++c;
			}
		}
		System.out.println(c);
	}
	
	public static void shiftCount1(char[] s){
		int c = 0;
		int len = s.length;
		
		for(int i=0; i<len; i++){
			int s2=i, k=0, s1=0;
			while(k<len){
				if(s[s2]==s[s1]){
					s2=(s2+1)%len;
					s1=(s1+1)%len;
					++k;
				}else{
					break;
				}
			}
			if(k==len){
				++c;
			}
			
		}
		System.out.println(c);
	}
	
	public static void reverse(char []s, int l, int r){
		char temp;
		for(int i=0; i<=(r-l)/2; i++)
		{
			temp = s[l+i];
			s[l+i] = s[r-i];
			s[r-i] = temp;
		}
	}
}
