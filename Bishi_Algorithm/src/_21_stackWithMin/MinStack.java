package _21_stackWithMin;

import java.util.Stack;  

public class MinStack<T extends Comparable<? super T>> {  
      
    private Stack<T> stack1;
    /* 
     * 辅助栈，存放最小值 
     */  
    private Stack<T> stackMin;
    public MinStack(){  
        stack1 = new Stack<T>();  
        stackMin = new Stack<T>();  
    }
    public void push(T t){
        stack1.push(t);
        if(stackMin.size()==0 || t.compareTo(stackMin.peek())<0)  
            stackMin.push(t);
        else  
            stackMin.push(stackMin.peek());  
    }  
    public T pop(){  
        if(stack1.size()>0 && stackMin.size()>0){  
            stackMin.pop();  
            return stack1.pop();  
        }  
        return null;  
    }  
    public T min(){  
        if(stack1.size()>0 && stackMin.size()>0)  
            return stackMin.peek();  
        return null;  
    }  
    public static void main(String[] args){  
        MinStack<Integer> minStack = new MinStack<Integer>();  
        minStack.push(4);
        minStack.push(3);
        minStack.push(7);
        minStack.pop();
        System.out.println(minStack.min());  
    }  
  
} 
