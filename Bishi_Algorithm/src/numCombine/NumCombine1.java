package numCombine;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * n�������ӵõ���С�����Ķ�λ������Я�̣�
 * @author root
 *
 */
public class NumCombine1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {13,343,312,3};
		fun1(data);
	}
	//ʹ��java����sort������Ƚ���
	public static void fun1(int data[]) {
		String str_data[] = new String[data.length];
		for(int i=0; i<data.length; i++){
			str_data[i] = data[i]+"";
		}
		//����
		//Arrays.sort(str_data, Collections.reverseOrder());
		Arrays.sort(str_data, new MyComprator());
		for(int i=0; i<str_data.length; i++){
			System.out.println(str_data[i]);
		}
	}
	//�Ƚ���
	static class MyComprator implements Comparator<String> {
	    public int compare(String m, String n) {
	    	return (n+m).compareTo(m+n);
	    }
	}
	
}

