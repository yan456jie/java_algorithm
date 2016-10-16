package huawei;

import java.util.ArrayList;
import java.util.List;
/**
 * 从符号的角度看,并且完全递归
 * @author Administrator
 *
 */
public class Equation3 {
	//如若元素不是有序的则需用到
	private static int [] ele = {0,1,2,3,4,5,6,7,8,9};
	private static char [] sym = {'+','-',' '};
	private static int sum = 0;
	private static int ops[] = new int[20];

	private static int result = 5;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun_op(1, 0, ' ', 0);
		System.out.println(sum);
	}
	/**
	 * @param layer共9层
	 * @param o
	 * @param last_sum
	 */
	public static void fun_op(int layer, int currentResult, char o, int last_sum){
		if(layer==9){
			if(o==' '){
				last_sum = last_sum*10 + (last_sum/Math.abs(last_sum==0?1:last_sum))*ele[layer];
				currentResult+= last_sum;
			}else if(o=='+'){
				currentResult+= last_sum + ele[layer];
			}else if(o=='-'){
				currentResult+= last_sum - ele[layer];
			}
			if(currentResult == result){
				sum++;
			}
			return;
		}
		//上一个操作符为空
		if(o==' '){
			last_sum = last_sum*10 + (last_sum/Math.abs(last_sum==0?1:last_sum))*ele[layer];
		}else if(o=='+'){
			currentResult+= last_sum;
			last_sum = ele[layer];
		}else if(o=='-'){
			currentResult+= last_sum;
			last_sum = -ele[layer];
		}
		ops[layer+1] = 2;
		fun_op(layer+1, currentResult, ' ', last_sum);//空
		ops[layer+1] = 0;
		fun_op(layer+1, currentResult, '+', last_sum);//+
		ops[layer+1] = 1;
		fun_op(layer+1, currentResult, '-', last_sum);//-
		
		return ;
	}
	
	/**
	 * @param layer共9层
	 * @param o
	 * @param last_sum
	 */
//	public static void fun_op1(int layer, int currentResult, char o, int last){
//		
//		fun_op(layer+1, currentResult, ' ', last_sum);//空
//		ops[layer+1] = 0;
//		fun_op(layer+1, currentResult, '+', last_sum);//+
//		ops[layer+1] = 1;
//		fun_op(layer+1, currentResult, '-', last_sum);//-
//		
//		return ;
//	}
}
