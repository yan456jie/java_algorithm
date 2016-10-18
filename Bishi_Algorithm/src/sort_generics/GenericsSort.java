package sort_generics;
/**
 * ∑∫–Õ≈≈–Ú
 * @author yanjie
 *
 */
public class GenericsSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Integer[] data = {4,5,6,7,1,2,3};
		sort(data);
		print(data);
	}

	public static <T extends Comparable<? super T>> void sort(T[] data){
		for(int i=data.length-1; i>0; i--){
			for(int j=0; j<i; j++){
				if(data[j].compareTo(data[j+1])>0){
					T temp = data[j];
					data[j] = data[j+1];
					data[j+1] = temp;
				}
			}
		}
	}
	public static <T extends Comparable<? super T>> void print(T[] data){
		for(int i=1; i<data.length; i++){
			System.out.println(data[i]);
		}
	}
}
