package _31_findMaxArray;

import java.util.Arrays;

/**
 * 连续子数组的最大和
 * 设b[i]表示以第i个元素a[i]结尾的最大子序列，
 * 那么显然b[i+1]=b[i]>0?b[i]+a[i+1]:a[i+1]。
 * 基于这一点可以很快用代码实现。最大子矩阵问题：给定一个矩阵（二维数组），其中数据有大有小，请找一个子矩阵，使得子矩阵的和最大，并输出这个和。
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
	//分析数据规律,记录并输出连续子数组的下标
	public static void find1(){
		//记录位置
		int begin = 0, end = 0, c_begin = 0;
		//最大值
		int max = 0;
		//到i为止的值
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
	//动态规划求解
	//b[i+1]=b[i]>0?b[i]+a[i+1]:a[i+1]
	public static void findDongtai(){
		//到i为止的值
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
		//找出最大值和最大值前连续大于0的index
		//最大值
		int max = 0;
		int begin = 0, end = 0;
		for(int i=0; i<data.length; i++){
			
		}
	}
}
