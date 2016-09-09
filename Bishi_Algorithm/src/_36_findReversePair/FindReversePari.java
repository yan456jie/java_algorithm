package _36_findReversePair;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.TreeSet;

/**
 * 找到数组的逆序对
 * 直接在归并排序中加一点输出
 * 
 * @author yanjie
 *
 */
public class FindReversePari {

	//static int[] data = {0,2,4,5,3,1,7,6};
	static int[] data = {7,5,6,4};

	public static void main(String[] args) {
		print(data);
		sort(data, 0, data.length-1);
		print(data);
	}

	public static void sort(int[] data, int low, int high) {
		if(low<high){
			int mid = (low+high)/2;
			sort(data, low, mid);
			sort(data, mid+1, high);
			merge(data, low, mid, high);
		}
	}

	public static void merge(int[] data, int low, int mid, int high) {
		if (low == high) {
			return;
		}
		int[] target = new int[high - low + 1];
		int i = low, j = mid + 1, k = 0;

		while (i <= mid && j <= high) {
			if (data[i] <= data[j]) {
				target[k++] = data[i++];
			} else {
				System.out.println(data[i]+" "+data[j]);
				target[k++] = data[j++];
			}
		}

		while (i <= mid) {
			if(i<mid && data[i]<data[i+1]){
				System.out.println(data[i]+" "+data[i+1]);
			}
			target[k++] = data[i++];
		}
		while (j <= high) {
			if(j<high && data[j]<data[j+1]){
				System.out.println(data[j]+" "+data[j+1]);
			}
			target[k++] = data[j++];
		}
		for (i = 0; i < high - low + 1; i++) {
			data[low + i] = target[i];
		}
	}
	public static void print(int[] data) {
		for (int i = 0; i < data.length; i++) {
			System.out.print(data[i]);
		}
		System.out.println();
	}
}
