package _25_sumEqPath;

import init.Node;

import java.util.Stack;

public class SumEqPath {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Stack<Node> stack = new Stack<Node>();
	/**
	 * 找出所有从根节点到叶子节点路径和等于n的路径并输出
	 * @param root
	 * @param n
	 */
	public void findPath(Node root ,int n){
		if(root!=null){
			stack.push(root);
			n = n-root.value;
			if(n==0 && root.left==null && root.right==null){//是所求的叶子节点
				for(Node no:stack){
					System.out.print(no.value);
				}
				System.out.println();
			}
			
			findPath(root.left, n);
			findPath(root.right, n);
			stack.pop();
		}
	}
	
}
