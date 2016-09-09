package loserTree;
/**
 * 用类似于建立大根堆的原理构造败者树
 * 最后结果:根节点最大，第二大在与根节点直接相连的节点中选择
 * 这里堆数组的第一个不放数据
 * @author yanjie
 *
 */
public class LoserTree {
	//
	static int[] data1 = {0, 3 ,5 ,7 ,1 ,9 ,11 ,12 ,13};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sort(data1);
		print(data1);
		allocMem(data1);
	}
	
	/**
	 * 申请空间，并将原数组放在新数组最后
	 */
	public static void allocMem(int[] data1){
		int[] data = new int[2*data1.length-2];
		System.arraycopy(data1, 0, data, data1.length-2, data1.length);
		print(data);
		sort(data);
		print(data);
		searchFirstAndSecond(data);
	}
	//寻找最大和第二大的
	public static void searchFirstAndSecond(int[] data){
		if(data.length<3){
			return;
		}
		int first=data[1],second=data[2];
		int j=2;
		while(j<data.length){//
			int next = j;
			if(data[j]!=data[1]){//不相等，则可作为比较数,且沿路径的next为j+1
				next = j+1;
			}else{
				j+=1;
			}
			System.out.println(data[j]);
			if(second<data[j]){
				second = data[j];
			}
			j=2*next;
		}
		System.out.println("first:"+first+" second:"+second);
	}
	/*
	 * 类似堆调整
	 */
	public static void sort(int[] data){
		int length = data.length-1;
		//从最后一个父节点开始调整
		//(n/2)*log(n)
		for(int i=length/2; i>0; --i){
			//调整s节点的两个子节点，保证s节点值为子节点中较大一个
			int j=2*i;
			if((j+1)<=length && data[j]<data[j+1])//有有右节点，并且左节点小于右节点
			{
				j+=1;
			}
			data[i] = data[j];
		}		
	}
	
	public static void print(int[] data){
		for(int i=1; i<data.length; i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
}
