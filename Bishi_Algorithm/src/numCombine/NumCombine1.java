package numCombine;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * n个数连接得到最小或最大的多位整数（携程）
 * @author root
 *
 */
public class NumCombine1{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int data[] = {13,343,312,3};
		fun1(data);
	}
	//使用java内置sort，构造比较器
	public static void fun1(int data[]) {
		String str_data[] = new String[data.length];
		for(int i=0; i<data.length; i++){
			str_data[i] = data[i]+"";
		}
		//排序
		//Arrays.sort(str_data, Collections.reverseOrder());
		Arrays.sort(str_data, new MyComprator());
		for(int i=0; i<str_data.length; i++){
			System.out.println(str_data[i]);
		}
	}
	//比较器
	static class MyComprator implements Comparator<String> {
	    public int compare(String m, String n) {
	    	return (n+m).compareTo(m+n);
	    }
	}
	
}

