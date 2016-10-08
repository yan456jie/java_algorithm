package _30_ministK;
/**
 * �ҳ���k�����
 * @author root
 *
 */
public class GetKNum {

	static int[] data = {0,2,4,4,5,3,1,7,6};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int mid = getK(data, 0, data.length-1, 1);
		System.out.println(mid+" "+data[mid-1]);
		print(data);
	}
	//��������
	public static int getK(int[] data, int low, int high, int k){
		if(k<1 || k>data.length){
			return -1;
		}
		int mid = partition(data, low, high);
		if(mid<k){
			mid = getK(data, mid+1, high, k);
		}
		if(mid>k){
			mid = getK(data, low, mid-1, k);
		}
		return mid;
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
