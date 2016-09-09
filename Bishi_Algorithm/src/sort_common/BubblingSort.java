package sort_common;
/**
 * Ã°ÅİÅÅĞò
 * @author root
 *
 */
public class BubblingSort {
	
	static int[] data = {0,2,4,5,3,1,7,6};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort(data);
		print(data);
	}

	public static void sort(int[] data){
		for(int i=data.length-1; i>0; i--){
			for(int j=0; j<i; j++){
				if(data[j]>data[j+1]){
					int temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
	}
	
	public static void print(int[] data){
		for(int i=1; i<data.length; i++){
			System.out.println(data[i]);
		}
	}
}
