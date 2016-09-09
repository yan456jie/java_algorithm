package numCombine;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * n�������ӵõ���С�����Ķ�λ������Я�̣�
 * @author root
 *
 */
public class NumCombine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {13,343,312,3};
		fun1(data);
		MyComprator m = new MyComprator();
		System.out.println(m.compare("3123", "3312"));
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
	//�Լ���д���Ž�������
	public static void fun2(int data[]) {
		String str_data[] = new String[data.length];
		for(int i=0; i<data.length; i++){
			str_data[i] = data[i]+"";
		}
		//����
		quick_sort(str_data, 0, str_data.length-1);
		for(int i=0; i<str_data.length; i++){
			System.out.println(str_data[i]);
		}
	}
	public static void quick_sort(String data[], int begin, int end) {
		if(begin<end){
			int mid = sort(data, begin, end);
			quick_sort(data, begin, mid-1);
			quick_sort(data, mid+1, end);
		}
	}
	//����
	public static int sort(String data[], int begin, int end) {
		String temp = data[begin];
		while(begin<end){
			while((data[end]+temp).compareTo(temp+data[end])<0 && begin<end){
				end--;
			}
			data[begin] = data[end];
			while((data[begin]+temp).compareTo(temp+data[begin])>0 && begin<end){
				begin++;
			}
			data[end] = data[begin];
		}
		data[begin] = temp;
		return begin;
	}/**/
}
//�Ƚ���
class MyComprator implements Comparator {
    public int compare(Object arg0, Object arg1) {
    	String t1=(String)arg0;
    	String t2=(String)arg1;
    	return -1*((t1+t2).compareTo(t2+t1));
    }
}