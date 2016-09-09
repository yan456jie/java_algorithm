package _22_isPopOrder;

import java.util.Stack;  

public class IsPopOrder {
    public static void main(String[] args) {  
        int[] push={1,2,3,4,5};
        int[] pop = {5,4,3,1,2};
        System.out.println(isPopOrder(push,pop));  
    }  
    
    public static boolean isPopOrder(int[] push, int[] pop) {  
        boolean popOrder = false;  
        if(push==null || pop==null) return false;  
        if(push.length!=pop.length) return false;  
        Stack<Integer> stack = new Stack<Integer>();  
        int i=0,j=0;  
        while(j<pop.length){  
            while(stack.isEmpty()||stack.peek()!=pop[j]){  
                if(i==push.length)  
                    break;  
                stack.push(push[i]);  
                i++;  
            }
            if(stack.peek()!=pop[j])
                break;
            stack.pop();
            j++;  
        }
        if(stack.isEmpty() && j==pop.length)
            popOrder = true;
        return popOrder;
    }
}
