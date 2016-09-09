package sort_common;
/**
 * 大根堆
 * @author root
 *
 */
public class HeapSort {
	
	static int[] data = {0,9,4,6,2,5};
	static int[] data1 = {0,2,4,5,3,1,7,6};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort(data1);
		print(data1);
	}
	//堆排序
	public static void sort(int[] data){
		int length = data.length-1;
		//建立大根堆，从最后一个孩子节点开始，依次向下调整
		//(n/2)*log(n)
		for(int i=length/2; i>0; --i){
			heapAjdust1(data, i, length);
		}
		//排序（每次将堆顶放到后面，然后调整堆）
		for(int i=length; i>1; --i){
			int t = data[1];
			data[1] = data[i];
			data[i] = t;
			heapAjdust1(data, 1, i-1);
		}
	}
	//向下调整(课本上的)
	public static void heapAjdust(int[] data, int s, int m){
		int temp = data[s];
		for(int j=2*s; j<=m; j*=2){
			if((j+1)<=m && data[j]<data[j+1])
				j++;
			if(data[s]>=data[j])
				break;
			data[s] = data[j];
			s=j;
		}
		data[s] = temp;
	}
	/**
	 * 向下调整(自己改写的)，大于孩子节点则跳出，否则与较大孩子交换，继续向下调整
	 * 调整的最大次数是数的深度，log(n)
	 * @param data 
	 * @param s 需要向下调整的节点序号
	 * @param m 最后一个节点序号
	 */
	public static void heapAjdust1(int[] data, int s, int m){
		for(int j=2*s; j<=m; j*=2){//从s的子节点开始，一直到最后一个节点
			//取较大节点
			if((j+1)<=m && data[j]<data[j+1])//有有右节点，并且左节点小于右节点
				j++;
			if(data[s]>=data[j])//s节点值大于较大节点，则s节点比其所有子孙都大，结束
				break;
			int t = data[s];//s小于孩子，将s与孩子交换
			data[s] = data[j];
			data[j] = t;
			s=j;//s转到孩子节点上，继续与孩子比较
		}
	}
	
	public static void print(int[] data){
		for(int i=1; i<data.length; i++){
			System.out.println(data[i]);
		}
	}
}
