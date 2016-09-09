package sort_common;
/**
 * ≤Â»Î≈≈–Ú
 * @author root
 *
 */
public class InsertSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {2,4,5,0,3,1,7,6};
		insertSort(data);
		print(data);
	}
	public static void insertSort(int[] data){
		if(data == null || data.length<=1){
			return;
		}
		for(int i=1; i<data.length; i++){
			if(data[i]<data[i-1]){
				int temp = data[i];
				data[i] = data[i-1];
				int j;
				for(j=i-2; j>=0 && data[j]>temp; j--)
					data[j+1] = data[j];
				data[j+1]=temp;
			}
		}
	}
	public static void print(int[] data){
		for(int i=1; i<data.length; i++){
			System.out.println(data[i]);
		}
	}
}
