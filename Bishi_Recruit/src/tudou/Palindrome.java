package tudou;

import java.util.Scanner;

public class Palindrome {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			String str = sc.nextLine();
			String res = lp(str);
			System.out.println(res);
		}
		
	}
	public static String lp(String str) {
		int maxL = 0;  
        String longestPa = null;  
        int length = str.length();
  
        for (int i = 0; i < length; i++) {  
            for (int j = i + 1; j < length; j++) {  
                int len = j-i;  
                String curr = str.substring(i, j + 1);  
                if (isPalindrome(curr)) {  
                    if (len > maxL) {  
                    	longestPa = curr;  
                    	maxL = len;  
                    }  
                }  
            }  
        }  
        return longestPa;
	}
	
	public static boolean isPalindrome(String s) {  
        for (int i = 0; i < s.length()/2; i++) {  
            if (s.charAt(i) != s.charAt(s.length()-1-i)){
                return false;
            }  
        }  
        return true;  
    }  
}
