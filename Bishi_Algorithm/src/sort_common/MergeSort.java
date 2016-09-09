package sort_common;
/**
 * 归并排序
 * @author root
 *
 */
public class MergeSort {
	
	//static int[] data = {0,2,4,5,3,1,7,6};
	static int[] data = {7,5,6,4};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort(data, 0, data.length-1);
		print(data);
	}
	//二路归并算法
	public static void sort(int[] data, int low, int high){
		if(low<high){
			int mid = (low+high)/2;
			sort(data, low, mid);
			sort(data, mid+1, high);
			merge(data, low, mid, high);
		}
	}
	//归并两个数组,将data中data[low]-data[mid]和data[mid+1]-data[high]归并到target
	public static void merge(int[] data, int low, int mid, int high){
		if(low==high){
			return;
		}
		int[] target = new int[high-low+1];
		int i=low,j=mid+1,k=0;
		
		while(i<=mid && j<=high){
			if(data[i]<=data[j]){
				target[k++] = data[i++];
			}else{
				target[k++] = data[j++];
			}
		}
		while(i<=mid){
			target[k++] = data[i++];
		}
		while(j<=high){
			target[k++] = data[j++];
		}
		for(i=0,j=low; i<target.length; i++,j++){
			data[j]=target[i];
		}
	}
	
	public static void print(int[] data){
		for(int i=0; i<data.length; i++){
			System.out.print(data[i]);
		}
		System.out.println();
	}
}
