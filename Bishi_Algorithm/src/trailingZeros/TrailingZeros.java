package trailingZeros;

/**
 * 0-n有多少个0
 * @author yanjie
 *
 */
public class TrailingZeros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//long c = trailingZeros(455555000);
		long c = trailingZeros(10);
        System.out.println(c);
	}
    /*
     * param n: As desciption
     * return: An integer, denote the number of trailing zeros in n!
     */
    public static long trailingZeros(long n) {
        // write your code here
        long c = 0;
        long t = 0;
        for(long i=5; i<=n; i+=5){
        	t = i;
            while(t>0 && t%5==0){
                ++c;
                t=t%5;
            }
        }
        return c;
    }
}
