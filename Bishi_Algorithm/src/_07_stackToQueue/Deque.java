package _07_stackToQueue;

import java.util.Stack;

public class Deque<T> {

	Stack<T> s1 = new Stack<T>();
	Stack<T> s2 = new Stack<T>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Deque<Integer> de = new Deque<Integer>();
		Integer[] data = {1,2,3,4,5};
		de.init(data);
		System.out.println(de.outdeque());
		System.out.println(de.outdeque());
		de.indeque(6);
		de.indeque(7);
		System.out.println(de.outdeque());
		System.out.println(de.outdeque());
		System.out.println(de.outdeque());
		System.out.println(de.outdeque());
		System.out.println(de.outdeque());
	}

	public void init(T [] data){
		for(int i=0; i<data.length; i++){
			s1.push(data[i]);
		}
	}
	
	public void indeque(T d){
		if(s1.size()==0){
			if(s2.size()==0){
				return;
			}else{//将s2弹出，压入s1
				while(!s2.isEmpty()){
					s1.push(s2.pop());
				}
			}
		}
		s1.push(d);
	}
	
	public T outdeque(){
		if(s2.size()==0){
			if(s1.size()==0){
				return null;
			}else{//将s1弹出，压入s2
				while(!s1.isEmpty()){
					s2.push(s1.pop());
				}
			}
		}
		return s2.pop();
	}
}
