package _8_minReverse;
/**
 * 找到旋转数组的最小值
 * @author yanjie
 *
 */
public class MinReverse {

	static int[] data = {5,6,7,8,9,1,2,3,4};
	//static int[] data = {1,0,1,1,1};//
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int min = search(data);
		System.out.println(min);
	}

	public static int search(int[] data){
		int index1 = 0;
		int index2 = data.length-1;
		int indexMid = index1;
		while(data[index1]>data[index2]){
			if(index2-index1==1){
				indexMid = index2;
				break;
			}
			//System.out.println("index1:"+index1+" mid:"+indexMid+" index2:"+index2);
			indexMid = (index1+index2)/2;
			//若index1,index2,indexMid指向数字相等,只能顺序查找
			if(data[index1]>=data[index2] && data[indexMid]==data[index2]){
				
			}
			if(data[indexMid]>=data[index1]){
				index1 = indexMid;
			}else if(data[indexMid]<=data[index2]){
				index2 = indexMid;
			} 
		}
		return data[indexMid];
	}
	public static int minOrder(int[] data, int index1, int index2){
		int result = data[index1];
		for(int i=index1+1; i<=index2; i++){
			if(result>data[i]){
				result = data[i];
			}
		}
		return result;
	}
}
