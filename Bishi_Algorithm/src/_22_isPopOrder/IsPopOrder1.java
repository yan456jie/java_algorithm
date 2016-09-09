package _22_isPopOrder;

import java.util.Stack;

public class IsPopOrder1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] push={1,2,3,4,5};
        int[] pop = {4,3,5,1,2};
        System.out.println(isPopOrder(push,pop));
	}
	public static boolean isPopOrder(int[] push, int[] pop) {
		Stack<Integer> stack = new Stack<Integer>();
		int i=0,j=0;
		while(j<pop.length){
			while(stack.isEmpty() || stack.peek()!=pop[j]){
				if(i==push.length)
					break;
				stack.push(push[i]);
				++i;
			}
			stack.pop();
			++j;
		}
		return j==pop.length?true:false;
	}
}
