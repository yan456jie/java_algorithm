package combination;

/**
 * 给n个字符串找出其所有的k位组合，可重复使用字符
 * @author root
 *
 */
public class Combination {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data={'a','b','c','d'};
		int k = 2;
		fun(data, "", 1, k);
	}
	/**
	 * 
	 * @param data 数组
	 * @param s 临时字符串，s=s+data[n],结束条件n>k
	 * @param n 递归多少次，从0开始
	 * @param k 递归深度
	 */
	public static void fun(char[] data,String s, int n, int k){
		if(n>k){
			System.out.println(s);
			return;
		}
		for(int i=0; i<data.length; i++){
			fun(data, s+data[i], n+1, k);
		}
	}

}
