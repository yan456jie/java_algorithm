package sort_common;

import java.util.ArrayList;
import java.util.List;

public class BuketSort {
	
	static int[] data = {22,23,25,22,34,30};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort(data);
	}

	public static void sort(int[] data){
		ArrayList<List> temp = new ArrayList<List>();
		//根据个位排序
		initArray(temp);
		sortByPosition(temp, 1);
		getArrayToData(temp, data);
		print(data);
		//根据十位排序
		initArray(temp);
		sortByPosition(temp, 2);
		getArrayToData(temp, data);
		print(data);
	}
	/*
	 * 初始化数组链表
	 */
	public static void initArray(ArrayList<List> temp){
		for(int i=0; i<10; i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			temp.add(list);
		}
	}
	
	/*
	 * 根据某一位放入桶中k=1,个位，k=2十位
	 */
	public static void sortByPosition(ArrayList<List> temp, int k){
		int p = 1;
		while(k>1){
			p=p*10;
			k--;
		}
		int t = 0;
		//根据个位放入桶中
		for(int i=0; i<data.length; i++){
			data[i] = data[i]/p;
			t = data[i]%p;
			ArrayList<Integer> list = (ArrayList<Integer>) temp.get(t);
			list.add(data[i]);
		}
	}
	
	/*
	 * 取出数组链表中的数据，放入data中
	 */
	public static void getArrayToData(ArrayList<List> temp, int[] data){
		//取出桶中数据
		for(int i=0,k=0; i<temp.size(); i++){
			ArrayList<Integer> list = (ArrayList<Integer>) temp.get(i);
			if(list!=null){
				for(int j=0; j<list.size(); j++){
					data[k++]=list.get(j);
				}
			}
		}
	}
	
	
	public static void print(int[] data){
		for(int i=0; i<data.length; i++){
			System.out.println(data[i]);
		}
	}
}
