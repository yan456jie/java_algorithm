package _07_stackToQueue;

import java.util.Stack;
/**
 * 用两个栈实现队列
 * @author yanjie
 *
 */
public class StackToQueue {

	static Stack<Integer> stack1 = new Stack<Integer>();
	static Stack<Integer> stack2 = new Stack<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test1();
	}
	public static void test1(){
		for(int i=0; i<5; i++){
			inQueue(i);
		}
		System.out.println(outQueue());
		inQueue(5);
		System.out.println();
		Integer d = null;
		do{
			d = outQueue();
			System.out.println(d);
		}while(d!=null);
	}
	
	//入队，入队都是入的stack1，保证stack2没有数据
	public static void inQueue(int data){
		transData(stack2, stack1);
		stack1.push(data);
	}
	//出队，出队都是入的stack2，保证stack1没有数据
	public static Integer outQueue(){
		transData(stack1, stack2);
		int data = 0;
		if(!stack2.isEmpty()){
			data = stack2.pop();
			return data;
		}else{
			System.out.println("队列为空!");
		}
		return null;
	}
	//将a栈数据放入b栈
	public static void transData(Stack<Integer> a, Stack<Integer> b){
		while(a.size()>0){
			b.push(a.pop());
		}
	}
}
