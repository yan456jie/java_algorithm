package maxUnCommo;

import java.util.HashMap;
import java.util.HashSet;
/**
 * 找出最长无重复子串
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
	 * 转移方程规划f(n)=max{f(n-1),a[n] in f(n-1);f(n-1)+a[n], a[n] not in f(n-1)}
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
	 * 将字符串放入hash表，出现过的标为-1，max_begin,max_length,begin,length
	 * 在当前最长字符串中出现的更改字符value为当前序号，找到value!=-1的更新max_bein和max_length
	 * 并将begin-value值更新为-1，更新begin,length,index,继续往下找
	 * 时间复杂度O(n)
	 * @param data
	 */
	public static void f1(char[] data){
		int begin=0,length=0,max_length=0,max_begin=0,index=0;
		HashMap<Character,Integer> hash = new HashMap<Character,Integer>();
		while(index<data.length){
			if(hash.containsKey(data[index]) && hash.get(data[index])!=-1){
				int value = hash.get(data[index]);
				//找到重复,判断最大
				if(length>max_length){
					max_length = length;
					max_begin = begin;
				}
				//将begin~value之间值更新为-1
				for(int i=begin; i<=value; i++){
					hash.put(data[i], -1);
				}
				//将新的重复字符放入hash
				hash.put(data[index], index);
				//重置begin、index、length
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
	 * 暴力搜索，O(n^2)，从头至尾依次找每个字符及其后续的最长
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
				//存在重复了，记录最长位置，清空哈希表，进入下一次循环
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
