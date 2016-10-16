package huawei;

import java.util.*;
/**
 * 给定若干个数，将其相加或相减得到一个固定结果，求所有组合
 * 从数的角度看
 * @author Administrator
 */
public class Equation1 {
	
	private static List<List<Integer>> list = new ArrayList<>();
	
	private static List<List<Integer>> op_list = new ArrayList<>();
	//如若元素不是有序的则需用到
	private static int [] ele = {1,2,3,4,5,6,7,8,9};
	
	private static int result = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getResult(result);
	}
	
	public static int getResult(int c) {
		fun(9);
		int count = 0;
		System.out.println(op_list.size());
		for(int k=0; k<list.size(); k++){
			Integer [] ee = new Integer[list.get(k).size()];
			op_list.clear();
			fun_op(list.get(k).toArray(ee), list.get(k).size()-1);
			//一组组合添加+或者-以后可能有的数组，计算其和
			for(int i=0; i<op_list.size(); i++){
				List<Integer> l = op_list.get(i);
				int sum = 0;
				for(int j=0; j<l.size(); j++){
					sum+=l.get(j);
				}
//				System.out.print(sum+" ");
				if(sum==result && l.get(0)>0){
					count++;
					System.out.println(l.toString());
				}
			}
		}
		System.out.println("count:"+count);
		return count;
	}
	//所有数字有可能的组合
	public static int fun(int c) {
		if(c==1){
			List gen = new ArrayList();
			gen.add(1);
			list.add(gen);
			return 1;
		}
		int r = 0;
		r = r + 2*fun(c-1);
		
		int k = list.size();
		for(int i=0; i<k; i++){
			List old = list.get(i);
			List gen = new ArrayList(old);
			gen.set(gen.size()-1, (int)(gen.get(gen.size()-1))*10 + c);
			list.add(gen);
			old.add(c);
		}
		return r;
	}
	//一组组合添加+或者-以后可能有的数组
	public static int fun_op(Integer [] arr, int c){
		if(c==0){
			List gen1 = new ArrayList();
			gen1.add(arr[c]);
			List gen2 = new ArrayList();
			gen2.add(-arr[c]);
			op_list.add(gen1);
			op_list.add(gen2);
			return 2;
		}
		int r = 0;
		r = r + fun_op(arr,c-1);
		
		int k = op_list.size();
		for(int i=0; i<k; i++){
			List old = op_list.get(i);
			List gen = new ArrayList(old);
			gen.add(-1*arr[c]);
			op_list.add(gen);
			old.add(arr[c]);
		}	
		return r;
	}
}
