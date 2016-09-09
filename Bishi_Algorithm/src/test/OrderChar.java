package test;

import java.util.Arrays;

/**
douban 这 六个字母从左到右分别代表数字 1，2，3，4，5，6，六个字母可取任意个进行组合，
如d=1， du = 13，obn = 246，nbud=6431，多位数不用考虑相同字母，
如dd=11 无效，请尝试由小到大输出这些数字排列，输出格式类似如下：
d = 1
o = 2
u = 3
b = 4
a = 5
n = 6
do = 12
du = 13
…
nabuod = 654321
 * @author root
 *
 */
public class OrderChar {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "douban";
		String s2 = "123456";
		String r1 = "";
		String r2 = "";
		int[] l2 = new int[s2.length()];
		for(int i=1; i<=s1.length();i++){
			fun1(i, s1.toCharArray(), s2.toCharArray(),r1, r2, l2);
		}
	}	
	/**
	 * 思路：新建一个标记数组，和递归深度，每次递归则减小n，并将取得的标记位置1
	 * @param n位数
	 * @param s1
	 * @param s2
	 * @param r1
	 * @param r2
	 * @param l2
	 */
	public static void fun1(int n, char[] s1, char[] s2,String r1,String r2, int[] l2){
		if(n<=0){
			System.out.println(r1+"="+r2);
			return;
		}
		for (int i = 0; i < s2.length; ++i) {
			if(l2[i]==0){
				int [] temp = Arrays.copyOf(l2, l2.length);
				temp[i] = 1;
				fun1(n-1, s1, s2,r1+s1[i], r2+s2[i], temp);
			}
		}
	}	
}
