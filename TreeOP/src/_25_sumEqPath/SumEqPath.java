package _25_sumEqPath;

import init.Node;

import java.util.Stack;

public class SumEqPath {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	Stack<Node> stack = new Stack<Node>();
	/**
	 * �ҳ����дӸ��ڵ㵽Ҷ�ӽڵ�·���͵���n��·�������
	 * @param root
	 * @param n
	 */
	public void findPath(Node root ,int n){
		if(root!=null){
			stack.push(root);
			n = n-root.value;
			if(n==0 && root.left==null && root.right==null){//�������Ҷ�ӽڵ�
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
