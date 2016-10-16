package mi;

import java.util.Scanner;

public class ReverseWords {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String line = sc.nextLine();
			char []char_arr = line.toCharArray();
			reverseWord(char_arr);
			System.out.println(new String(char_arr));
		}
	}
	
	public static void reverseWord(char []char_arr){
		int l = 0;
		int r = char_arr.length-1;
		reverse(char_arr, l, r);
		r = 0;
		for(int i=0; i<=char_arr.length;++i){
			if(i==(char_arr.length)||char_arr[i]==' '){
				r = i-1;
				reverse(char_arr, l, r);
				l = i+1;
			}
		}
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

