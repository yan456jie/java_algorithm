package wordReverse;

/**
 * µ¥´Ê·´×ª
 * @author yanjie
 *
 */
public class StrReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="hello i tianjin.";
		char []s = str.toCharArray();
		reverseWord1(s);
		System.out.println(new String(s));
	}
	
	public static void reverseWord(char []s){
		int l = 0;
		int r = 0;
		reverse(s, l, r+s.length-1);
		for(int i=0; i<=s.length;++i){
			if(i==(s.length)||s[i]==' '){
				r = i-1;
				reverse(s, l, r);
				l = i+1;
			}
		}
	}
	
	public static void reverseWord1(char []s){
		int i = 0;
		int j = 0;
		reverse(s, i, j+s.length-1);
		for(i=0,j=0; j<=s.length;++j){
			if(s[j]==' '){
				reverse(s, i, j-1);
				i = j;
			}
			if(j==(s.length-1)){
				reverse(s, i, j);
				break;
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
