package _12_printOneToN;
/**
 * ��ӡ1-3λ������,ģ���ַ����ӷ�
 * @author yanjie
 *
 */
public class PrintOneToN1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 3;
		printOneToN(n);
	}
	
	public static void printOneToN(int n){
		String num = "1";
		while(num.length()<=n){
			System.out.println(num+" ");
			num = bigNumberAdd(num, "1");
		}
	}
	
	public static String bigNumberAdd(String f, String s) {  
        //��ת�����ַ�������ת��������  
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();  
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();  
        int lenA = a.length;  
        int lenB = b.length;  
        //�����������ַ����еĽϳ��ַ����ĳ���  
        int len = lenA > lenB ? lenA : lenB;  
        int[] result = new int[len + 1];  
        for (int i = 0; i < len + 1; i++) {  
            //�����ǰ��i���������е�һ��������0���棬����һ���ַ������е��������  
            int aint = i < lenA ? (a[i] - '0') : 0;  
            int bint = i < lenB ? (b[i] - '0') : 0;  
            result[i] = aint + bint;  
        }  
        //���������ϣ��������10�ľ���ǰһλ��λ��������г�10ȡ��  
        for (int i = 0; i < result.length; i++) {  
            if (result[i] >= 10) {  
                result[i + 1] += result[i] / 10;  
                result[i] %= 10;  
            }  
        }  
        StringBuffer sb = new StringBuffer();  
        //���ֶ����ڱ�ʶ�Ƿ���ǰ��0������оͲ�Ҫ�洢  
        boolean flag = true;  
        for (int i = len; i >= 0; i--) {  
            if (result[i] == 0 && flag) {  
                continue;  
            } else {  
                flag = false;  
            }  
            sb.append(result[i]);  
        }  
        return sb.toString();  
    }
}
