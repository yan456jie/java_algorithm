package tudou;

/**
 * 字符串中最长的回文子串,时间复杂度O(n^2)
 * @author yanjie
 *
 */
public class MaxSubPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(lp("ababa"));
		System.out.println(lp("aaabbaa"));
		System.out.println(lp("aaaabaa"));
	}
	public static String lp(String str) {
        int length = str.length();
        String res = "";
        String temp = "";
        for (int i = 0; i < length; i++) {  
        	temp = subPal(str, i);
        	if(res.length()<temp.length()){
        		res = temp;
        	}
        }  
        return res;
	}
	//从第k位开始找，两种情况，如k=1时，aba和abba
	public static String subPal(String str, int k) {
		String res = "";
		//第一种情况
		int s=k-1,e=k+1;
		int l1=1;
        while(s>=0 && e<str.length() && str.charAt(s)==str.charAt(e)){
        	l1=l1+2;
        	s=s-1;
        	e=e+1;
        }
        res = str.substring(s+1, e);
        //第二种情况
        int l2=0;
        s=k;
        e=k+1;
        while(s>=0 && e<str.length() && str.charAt(s)==str.charAt(e)){
        	l2=l2+2;
        	s=s-1;
        	e=e+1;
        }
        if(l2>l1){
        	res = str.substring(s+1, e);
        }
        return res;  
    }  
}
