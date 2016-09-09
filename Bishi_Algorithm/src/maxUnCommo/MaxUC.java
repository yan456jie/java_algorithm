package maxUnCommo;

import java.util.HashMap;
import java.util.HashSet;
/**
 * �ҳ�����ظ��Ӵ�
 * @author root
 *
 */
public class MaxUC {
	
	static String ss = "aeaabcadas";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f(ss.toCharArray());
		f1(ss.toCharArray());
		String s = f2(ss.toCharArray(),ss.length()-1);
		System.out.println(s);
	}
	/**
	 * ת�Ʒ��̹滮f(n)=max{f(n-1),a[n] in f(n-1);f(n-1)+a[n], a[n] not in f(n-1)}
	 * @param data
	 */
	static String longest = "";
	public static String f2(char[] data, int index){
		if(index<=0){
			return data[0]+"";
		}
		String s = f2(data, index-1);
		if(s.contains(data[index]+"")){
			return s;
		}else{
			return s+data[index];
		}
	}
	/**
	 * ���ַ�������hash�����ֹ��ı�Ϊ-1��max_begin,max_length,begin,length
	 * �ڵ�ǰ��ַ����г��ֵĸ����ַ�valueΪ��ǰ��ţ��ҵ�value!=-1�ĸ���max_bein��max_length
	 * ����begin-valueֵ����Ϊ-1������begin,length,index,����������
	 * ʱ�临�Ӷ�O(n)
	 * @param data
	 */
	public static void f1(char[] data){
		int begin=0,length=0,max_length=0,max_begin=0,index=0;
		HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
		while(index<data.length){
			if(hash.containsKey(data[index]) && hash.get(data[index])!=-1){
				int value = hash.get(data[index]);
				//�ҵ��ظ�,�ж����
				if(length>max_length){
					max_length = length;
					max_begin = begin;
				}
				//��begin~value֮��ֵ����Ϊ-1
				for(int i=begin; i<=value; i++){
					hash.put(data[i], -1);
				}
				//���µ��ظ��ַ�����hash
				hash.put(data[index], index);
				//����begin��index��length
				begin = value+1;
				length = index-value;
				++index;
			}else{
				hash.put(data[index], index);
				++index;
				++length;
			}
		}
		System.out.println("###########");
		System.out.println(max_begin+" "+max_length);
		print(data, max_begin, max_length);
	}
	/**
	 * ����������O(n^2)����ͷ��β������ÿ���ַ�����������
	 * @param data
	 */
	public static void f(char[] data){
		int begin=0,length=0,max_length=0,f_begin=0;
		HashSet<Character> hash = new HashSet<Character>();
		for(int i=0; i<data.length; i++){
			begin=i;
			length=1;
			hash.add(data[i]);
			for(int j=i+1; j<data.length; j++){
				//�����ظ��ˣ���¼�λ�ã���չ�ϣ��������һ��ѭ��
				if(hash.contains(data[j])){
					if(max_length<length){
						max_length = length;
						f_begin = begin;
					}
					hash.clear();
					break;
				}else{
					length++;
					hash.add(data[j]);
				}
			}
			
		}
		System.out.println("###########");
		System.out.println(f_begin+" "+max_length);
		print(data, f_begin, max_length);
	}
	
	public static void print(char[] data, int begin, int length){
		for(int i=begin; i<begin+length; i++){
			System.out.print(data[i]);
		}
		System.out.println();
	}
}
