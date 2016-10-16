package sogou;

import java.util.Scanner;

public class FindMaxPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String line = sc.nextLine();
			int len = find(line.toCharArray());
			System.out.println(len);
		}
		
	}
	public static int find(char []text){
		if(text==null || text.length==1){
			return 0;
		}
		
		int len=1, i=0,j=0,k=0;
		for(; k<text.length; k++){
			int cur_len = 0;
			i=k+1;
			j=k-1;
			while(i<text.length && j>=0 && text[i]==text[j]){
				cur_len++;
				i++;
				j--;
			}
			if(cur_len>len){
				len = cur_len;
			}
			cur_len = 0;
			i=k+1;
			j=k;
			while(i<text.length && j>=0 && text[i]==text[j]){
				cur_len++;
				i++;
				j--;
			}
			if(cur_len>len){
				len = cur_len;
			}
		}
		return len;
	}
}