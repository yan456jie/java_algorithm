package uglyNum;
/**
 * ÅĞ¶ÏÊÇ·ñÊÇ³óÊı
 * @author yanjie
 *
 */
public class UglyNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(isUgly(14));
	}
	public static boolean isUgly(int num) {
        // Write your code here
        int n = num;
        if(n<=0){
            return false;
        }
        if(n==1){
            return true;
        }
        while(n>0 && n%2==0){
            n=n/2;
        }
        System.out.println(n);
        while(n>0 && n%3==0){
            n=n/3;
        }
        System.out.println(n);
        while(n>0 && n%5==0){
            n=n/5;
        }
        System.out.println(n);
        if(n==1){
            return true;
        }
        return false;
    }
}
