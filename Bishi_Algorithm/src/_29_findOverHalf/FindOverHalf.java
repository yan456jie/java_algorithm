package _29_findOverHalf;
/**
 * 找到数组中出现次数超过一半的数字
 * @author yanjie
 *
 */
public class FindOverHalf {
	
	static int[] data = {1,2,3,2,2,2,5,4,2};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		print(data);
		int mid = (data.length)/2;
		int mid_data = bisearch(data, 0, data.length-1, mid);
		System.out.println(data[mid_data]);
	}
	
	public static int partion(int[] data, int low, int high){
		int temp = data[low];
		while(low<high){
			while(low<high && data[high]>=temp)
				high--;
			data[low] = data[high];
			while(low<high && data[low]<=temp)
				low++;
			data[high] = data[low];
			System.out.println(low+" "+high);
		}
		data[low] = temp;
		return low;
	}
	public static int bisearch(int[] data, int low, int high, int mid){
		int par = 0;
		while(par!=mid){
			par = partion( data, low, high);
			if(par==mid){
				return data[par];
			}else if(par<mid){
				low = par+1;
			}else if(par>mid){
				high = par-1;
			}
		}
		return 0;
	}
	
	public static void print(int[] data){
		for(int i: data){
			System.out.print(i+" ");
		}
	}
	
}
