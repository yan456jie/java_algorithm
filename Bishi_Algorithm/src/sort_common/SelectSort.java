package sort_common;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 简单选择排序
 * 每次从i-length中选择最小的，和data[i]个交换
 * 
 * @author yanjie
 *
 */
public class SelectSort {

	static int[] data = {2,0,4,5,3,1,7,6};
	//static int[] data = {7,5,6,4};

	public static void main(String[] args) {
		print(data);
		sort(data);
		print(data);
	}
	public static void sort(int[] data){
		for(int i=0; i<data.length; i++){
			//选择从i-(length-1)最小的
			int min_index = i;
			for(int j=i; j<data.length; j++){
				if(data[j]<data[min_index]){
					min_index = j;
				}
			}
			if(i!=min_index){
				int temp = data[i];
				data[i] = data[min_index];
				data[min_index] = temp;
			}
		}
	}
	public static void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
		}
		System.out.println();
	}
}
