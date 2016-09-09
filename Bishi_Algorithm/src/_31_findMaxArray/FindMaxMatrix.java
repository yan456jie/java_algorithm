package _31_findMaxArray;
/**
 * 连续子数组的最大和
 * 设b[i]表示以第i个元素a[i]结尾的最大子序列，
 * 那么显然b[i+1]=b[i]>0?b[i]+a[i+1]:a[i+1]。
 * 基于这一点可以很快用代码实现。最大子矩阵问题：给定一个矩阵（二维数组），其中数据有大有小，请找一个子矩阵，使得子矩阵的和最大，并输出这个和。
 * @author root
 *
 */
public class FindMaxMatrix {
	
	static int[][] data = {{0,-2,-7,0},{9,2,-6,2},{-4,1,-4,1},{-1,8,0,-2}};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		find1();
	}
	//分析数据规律,记录并输出连续子数组的下标
	public static void find1(){
		//记录位置
		int begin = 0, end = 0, c_begin = 0;
		//最大值
		int max = 0;
		int sum = 0;
		//到i为止的值
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
	//动态规划求解
	public static void findDongtai(){
		
	}
}
