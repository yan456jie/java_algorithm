package bigDataOperation;

import java.math.BigInteger;
/**
 * �����
 * @author root
 *
 */
public class BigAdd {  
	  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
    	//String str1 = "23456789009877666555544444";
        //String str2 = "346587436598437594375943875943875";
    	String str1 = "19";
        String str2 = "1";
        
        String result = bigNumberAdd(str1, str2);
  
        System.out.println("������"+str1);
        System.out.println("������"+str2);
        System.out.println("�����"+result);
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
    
    public static String bigNumberSub(String f, String s) {  
        System.out.print("����:" + f + "-" + s + "=");  
        // ���ַ�����ת��ת�����ַ�����  
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();  
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();  
        int lenA = a.length;
        int lenB = b.length;
        // �ҵ���󳤶�  
        int len = lenA > lenB ? lenA : lenB;  
        int[] result = new int[len];  
        // ��ʾ���������  
        char sign = '+';  
        // �ж����ս�������� 
        if (lenA < lenB) {  
            sign = '-';  
        } else if (lenA == lenB) {  
            int i = lenA - 1;  
            while (i > 0 && a[i] == b[i]) {  
                i--;  
            }  
            if (a[i] < b[i]) {  
                sign = '-';  
            }  
        }  
        // ����������������ս��Ϊ������ô��a-b����Ļ���b-a
        for (int i = 0; i < len; i++) {  
            int aint = i < lenA ? (a[i] - '0') : 0;  
            int bint = i < lenB ? (b[i] - '0') : 0;  
            if (sign == '+') {  
                result[i] = aint - bint;  
            } else {  
                result[i] = bint - aint;  
            }  
        }  
        // �����������е�ĳһλС���㣬��ô����ǰһλ��һ��Ȼ�󽫱�λ����10����ʵ���൱�ڽ�λ������  
        for (int i = 0; i < result.length - 1; i++) {  
            if (result[i] < 0) {  
                result[i + 1] -= 1;  
                result[i] += 10;  
            }  
        }  
  
        StringBuffer sb = new StringBuffer();  
        // ������ս��Ϊ��ֵ���ͽ����ŷ�����ǰ�棬��������Ҫ  
        if (sign == '-') {  
            sb.append('-');  
        }  
        // �ж��Ƿ���ǰ��0  
        boolean flag = true;  
        for (int i = len - 1; i >= 0; i--) {  
            if (result[i] == 0 && flag) {  
                continue;  
            } else {  
                flag = false;  
            }  
            sb.append(result[i]);  
        }  
        // ������ս��������û��ֵ����˵������ֵ��ȣ����շ���0  
        if (sb.toString().equals("")) {  
            sb.append("0");  
        }  
        // ����ֵ  
        System.out.println(sb.toString());  
        return sb.toString();  
    }
}
