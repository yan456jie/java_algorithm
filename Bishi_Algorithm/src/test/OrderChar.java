package test;

import java.util.Arrays;

/**
douban �� ������ĸ�����ҷֱ�������� 1��2��3��4��5��6��������ĸ��ȡ�����������ϣ�
��d=1�� du = 13��obn = 246��nbud=6431����λ�����ÿ�����ͬ��ĸ��
��dd=11 ��Ч���볢����С���������Щ�������У������ʽ�������£�
d = 1
o = 2
u = 3
b = 4
a = 5
n = 6
do = 12
du = 13
��
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
	 * ˼·���½�һ��������飬�͵ݹ���ȣ�ÿ�εݹ����Сn������ȡ�õı��λ��1
	 * @param nλ��
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
