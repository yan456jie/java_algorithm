package shunfeng;

import java.util.Arrays;
import java.util.Scanner;
/*
 * ˳��Ƽ������⣺�з�һ����12346���зֳ����ɷݣ�ʹ����ͽӽ��Ҳ�����m��50��
 */
public class SplitData {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		split("12346", "", 1, 0);
		System.out.println(sum);
		System.out.println(result);
	}
	
	public static void splitNum(int n, int m){
		String s = n+"";
		int l = s.length();//�зִ���Ϊ0-(l-1)
		for(int i=0; i<l; i++){
			//�зֵ�i�ε�ʱ��
		}
	}
	String s = "";
	static int sum = 0;
	static int m = 50;
	static String result = "";
	public static void split(String s, String t_result, int k, int t_sum){
		if(k>=s.length()){
			t_sum = Integer.parseInt(s.substring(0))+t_sum;
			t_result = t_result+" "+s;
			if(t_sum>m){
				return;
			}else if(t_sum<=m && t_sum>sum){
				sum = t_sum;
				result = t_result;
			}
			return;
		}
		//��
		int a1 = Integer.parseInt(s.substring(0, k));
		split(s.substring(k), t_result+" "+a1, 1, t_sum+a1);
		//����
		split(s, t_result, k+1, t_sum);
	}
}
/*
1
5 3
aaaaaa
aaabbb
ababab
dddd
dddd
aaaa
aaa
ax
*/
