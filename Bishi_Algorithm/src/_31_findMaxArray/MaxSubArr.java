package _31_findMaxArray;

/**
 * �ҵ��������������ֵ
 * @author root
 *
 */
public class MaxSubArr {

	static int[] data = {1,-2,3,10,-4,7,2,-5};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sumSub(0,0);
		System.out.println(max);
	}
	static int max = data[0];
	public static int sumSub(int begin,int end){
		if(end>=data.length){
			return 0;
		}
		int sum = 0;
		for(int i=begin; i<=end; i++){
			sum+=data[i];
		}
		if(sum>max){
			max=sum;
		}
		if(sum>0){//����һλ
			++end;
		}else{//�Ӻ�һλ���¼���
			begin=end+1;
			end=begin;
		}
		sumSub(begin, end);
		return sum;
	}
}
