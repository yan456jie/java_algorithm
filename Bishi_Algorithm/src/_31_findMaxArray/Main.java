package _31_findMaxArray;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] data = {1,-2,3,10,-4,7,2,-5};
		Main m = new Main();
		int maxSum = m.fun1(data);
		System.out.println(maxSum);
	}
	/**
	 * ���������������ֵ
	 * @param data
	 * @return
	 */
	public int fun(int data[]){
		int curSum=0,maxSum=-65534;
		//ÿ��һ�αȽ�curSum��maxSum��С������maxSumΪ���
		for(int i=0; i<data.length; i++){
			if(curSum<0)
				curSum = data[i];
			else
				curSum+=data[i];
			if(curSum>maxSum)
				maxSum = curSum;
		}
		return maxSum;
	}
	/**
	 * ��������ֵ������������
	 * @param data
	 * @return
	 */
	public int fun1(int data[]){
		int curSum=0,maxSum=-65534;
		int begin=0,end=0,c_begin=0;
		//ÿ��һ�αȽ�curSum��maxSum��С������maxSumΪ���
		for(int i=0; i<data.length; i++){
			if(curSum<0){
				c_begin = i;
				curSum = data[i];
			}
			else{
				curSum+=data[i];
			}
			if(curSum>maxSum){
				begin = c_begin;
				end = i;
				maxSum = curSum;
			}
		}
		System.out.println("begin:"+begin+" end:"+end);
		return maxSum;
	}
}
