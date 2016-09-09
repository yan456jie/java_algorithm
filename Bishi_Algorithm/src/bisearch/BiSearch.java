package bisearch;
/**
 * ¶ş·Ö²éÕÒ
 * @author yanjie
 *
 */
public class BiSearch {

	static int[] data = {1,4,6,10,18,35,42,53,67,71,78,84,92,99};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int index = search(data, 78);
		System.out.println(index);
	}

	public static int search(int[] data, int target){
		int begin = 0;
		int end = data.length-1;
		while(begin<=end){
			int mid = (begin+end)/2;
			System.out.println(begin+" "+end+" "+data[mid]);
			if(data[mid]==target){
				return mid;
			}else if(data[mid]<target){
				begin = mid+1;
			}else if(data[mid]>target){
				end = mid-1;
			}
		}
		return -1;
	}
}
