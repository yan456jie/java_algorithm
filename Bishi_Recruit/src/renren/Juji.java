package renren;

import java.util.Arrays;

/**
 * ��д��ĸ��һ��Сд��ĸ��һ�����ַ�һ�������ַ���һ��
 * @author yanjie
 *
 */
public class Juji {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] str = {'a','A','1','B','c','7','.','4'};
		int begin = fun(str,0,str.length-1, 1);
		begin = fun(str,begin,str.length-1, 2);
		begin = fun(str,begin,str.length-1, 3);
		System.out.println(Arrays.toString(str));
	}
	public static int fun(char[] data,int l,int r, int rule){
		while(l<r){
			while(l<r && rule(data[l])==rule){
				++l;
			}
			while(l<r && rule(data[r])!=rule){
				--r;
			}
			char c = data[l];
			data[l] = data[r];
			data[r] = c;
		}
		return l;
	}
	public static int rule(char c){
		if(c>='A' && c<='Z'){
			return 1;
		}
		else if(c>='a' && c<='z'){
			return 2;
		}
		else if(c>='0' && c<='9'){
			return 3;
		}
		else {
			return 4;
		}
	}
}
