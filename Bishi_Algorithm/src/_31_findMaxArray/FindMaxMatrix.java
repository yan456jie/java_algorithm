package _31_findMaxArray;
/**
 * ���������������
 * ��b[i]��ʾ�Ե�i��Ԫ��a[i]��β����������У�
 * ��ô��Ȼb[i+1]=b[i]>0?b[i]+a[i+1]:a[i+1]��
 * ������һ����Ժܿ��ô���ʵ�֡�����Ӿ������⣺����һ�����󣨶�ά���飩�����������д���С������һ���Ӿ���ʹ���Ӿ���ĺ���󣬲��������͡�
 * @author root
 *
 */
public class FindMaxMatrix {
	
	static int[][] data = {{0,-2,-7,0},{9,2,-6,2},{-4,1,-4,1},{-1,8,0,-2}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		find1();
	}
	//�������ݹ���,��¼�����������������±�
	public static void find1(){
		//��¼λ��
		int begin = 0, end = 0, c_begin = 0;
		//���ֵ
		int max = 0;
		int sum = 0;
		//��iΪֹ��ֵ
		int temp = 0;
		for(int i=0; i<data.length; i++){
			for(int j=0; j<data[0].length; j++){
				sum = 0;
				for(int k=i; k<=j; k++){
					//sum+=data[k];
				}
			}
			//temp+=data[i];
			if(temp>max){
				max=temp;
				begin = c_begin;
				end = i;
			}
			if(temp<0){
				temp = 0;
				c_begin = i+1;
			}
		}
		System.out.println("begin:"+begin+" end:"+end);
		System.out.println("max:"+max);
	}
	//��̬�滮���
	public static void findDongtai(){
		
	}
}
