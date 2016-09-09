package sort_common;
/**
 * ��������
 * @author root
 *
 */
public class QuickSort {

	static int[] data = {0,2,4,4,5,3,1,7,6};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort(data, 0, data.length-1);
		print(data);
	}
	//��������
	public static void sort(int[] data, int low, int high){
		if(low<high){
			int mid = partition(data, low, high);
			sort(data, low, mid-1);
			sort(data, mid+1, high);
		}
	}
	//��ĳ������Ϊ���ᣬС�������󣬴��������
	public static int partition(int[] data, int low, int high){
		int temp = data[low];
		while(low<high){
			while(low<high && data[high]>=temp)
				high--;
			data[low]=data[high];
			while(low<high && data[low]<=temp)
				low++;
			data[high]=data[low];
		}
		data[low]=temp;
		return low;
	}
	
	public static void print(int[] data){
		for(int i=0; i<data.length; i++){
			System.out.print(data[i]+" ");
		}
	}
}
