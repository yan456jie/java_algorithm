package combination;

/**
 * ��n���ַ����ҳ������е�kλ��ϣ����ظ�ʹ���ַ�
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
	 * @param data ����
	 * @param s ��ʱ�ַ�����s=s+data[n],��������n>k
	 * @param n �ݹ���ٴΣ���0��ʼ
	 * @param k �ݹ����
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
