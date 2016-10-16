package shunfeng;

import java.util.Arrays;
import java.util.Scanner;

public class WordPre {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int c = sc.nextInt();
		for(int k=0; k<c; k++){
			int n = sc.nextInt();
			int m = sc.nextInt();
			String[] table = new String[n];
			String[] words = new String[m];
			//System.out.println(n+" "+m);
			sc.nextLine();
			for(int i=0; i<n; i++){
				table[i] = sc.nextLine();
			}
			for(int i=0; i<m; i++){
				words[i] = sc.nextLine();
			}
			//System.out.println(Arrays.toString(table));
			//System.out.println(Arrays.toString(words));
			System.out.println("Case #"+(k+1)+": ");
			computePrefix(words, table);
		}
		
	}
	
	public static void computePrefix(String[] words, String[] table){
		for(String word : words){
			int count = 0;
			for(String partten: table){
				if(partten.startsWith(word)){
					++count;
				}
			}
			System.out.println(count);
		}
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
