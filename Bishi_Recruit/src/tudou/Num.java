package tudou;

import java.math.BigInteger;
/**
 * n!取最后一个非0字符
 * @author yanjie
 *
 */
public class Num {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 10;
		BigInteger m = BigInteger.ONE;
		int k = 1;
		while(k<=n){
			m=m.multiply(new BigInteger(""+k));
			++k;
			if(k%10==0){
				m = m.divide(new BigInteger(""+100));
			}/**/
		}
		while(m.mod(new BigInteger(""+10)).intValue()==0){
			m = m.divide(new BigInteger(""+10));
		}
		//System.out.println(m.longValue());
		System.out.println(m.mod(new BigInteger(""+10)));
	}

}
