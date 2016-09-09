package test;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {1,-2,3,10,-4,7,2,-5};
		int r = fun(data, 3);
		System.out.println(r);
	}
	
	public static int fun(int[] data, int k){
		int mid,low=0,high=data.length-1;
		do{
			mid = partition(data, low, high);
			if(mid<k)
				low = mid;
			else if(mid>k)
				high = mid;
		}while(mid!=k);
		
		return data[mid];
	}
			
	
	//以某个数字为枢轴，小的在其左，大的在其右
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
}
