package _31_findMaxArray;

import java.util.Arrays;

/**
 * ���������������
 * ��b[i]��ʾ�Ե�i��Ԫ��a[i]��β����������У�
 * ��ô��Ȼb[i+1]=b[i]>0?b[i]+a[i+1]:a[i+1]��
 * ������һ����Ժܿ��ô���ʵ�֡�����Ӿ������⣺����һ�����󣨶�ά���飩�����������д���С������һ���Ӿ���ʹ���Ӿ���ĺ���󣬲��������͡�
 * @author root
 *
 */
public class FindMaxSubArrSum {
	
	static int[] data = {1,-2,3,10,-4,7,2,-5};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//findDongtai();
		find1();
	}
	//�������ݹ���,��¼�����������������±�
	public static void find1(){
		//��¼λ��
		int begin = 0, end = 0, c_begin = 0;
		//���ֵ
		int max = 0;
		//��iΪֹ��ֵ
		int temp = 0;
		for(int i=0; i<data.length; i++){
			temp+=data[i];
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
	//b[i+1]=b[i]>0?b[i]+a[i+1]:a[i+1]
	public static void findDongtai(){
		//��iΪֹ��ֵ
		int[] temp = new int[data.length];
		temp[0] = data[0];
		for(int i=1; i<data.length; i++){
			if(temp[i-1]>0){
				temp[i]=temp[i-1]+data[i];				
			}else{
				temp[i]=data[i];
			}
		}
		System.out.println(Arrays.toString(temp));
		//�ҳ����ֵ�����ֵǰ��������0��index
		//���ֵ
		int max = 0;
		int begin = 0, end = 0;
		for(int i=0; i<data.length; i++){
			
		}
	}
}
