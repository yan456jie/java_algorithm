package _12_printOneToN;
/**
 * ��ӡ1-3λ������,ʹ������ȫ���з���
 * ÿ�εݹ鶼ѭ��ȡ0-9�����ʱ�Ƴ���λ0
 * @author yanjie
 *
 */
public class PrintOneToN {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] data={'0','1','2','3','4','5','6','7','8','9'};
		int n = 2;
		fun(data, "", 1, n);
	}
	/**
	 * 
	 * @param data ����
	 * @param s ��ʱ�ַ�����s=s+data[n],��������n>k
	 * @param k �ݹ���ٴΣ���1��ʼ
	 * @param n �ݹ����,��ʾλ��
	 */
	public static void fun(char[] data,String s, int k, int n){
		if(k>n){
			System.out.print(rmZero(s)+" ");
			return;
		}
		for(int i=0; i<data.length; i++){
			fun(data, s+data[i], k+1, n);
		}
	}
	/*
	 * �Ƴ���λ��0
	 */
	public static String rmZero(String s){
		int index = 0;
		while(index<s.length() && s.charAt(index)=='0'){
			index++;
		}
		return s.substring(index);
	}
}
