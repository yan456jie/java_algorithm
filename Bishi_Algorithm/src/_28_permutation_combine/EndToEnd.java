package _28_permutation_combine;

import java.util.Arrays;
/** 
 * �����ַ�������{"gj","jl","dg","ad","gg"} 
 * ����β������[ad, dg, gg, gj, jl]
 * @author yanjie 
 * 
 */
public class EndToEnd {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String [] str = {"ad","dg","gj","jl"};
		String [] str = {"gj","jl","dg","ad","gg"};
		//System.out.println(judge("aa", "dd"));
		fun(str, 0);
	}

	public static void fun(String [] str, int k){
		if(k==str.length){
			System.out.println(Arrays.toString(str));
			return;
		}
		
		for(int i=k; i<str.length; ++i){
			//����k+1��i
			//k=0,����Ϊ��һ���ַ�����������Լ��Լ�����ÿһ������
			//k>0ʱ������0-(k-1)������õģ�������Ƚ�k-1��i��˳��
			if(k>0 && judge(str[k-1], str[i])){
				swap(str, k, i);
				fun(str, k+1);
				swap(str, k, i);
			}else if(k==0){
				swap(str, k, i);
				fun(str, k+1);
				swap(str, k, i);
			}
		}
	}
	private static void swap(String[] a, int s, int i) {		
		String t = a[s];
		a[s] = a[i];
		a[i] = t;
	}
	public static boolean judge(String s1, String s2){
		if(s1.charAt(s1.length()-1)==s2.charAt(0)){
			return true;
		}
		return false;
	}
}
