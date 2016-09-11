package loopTraversal;

import init.Node;

import java.util.Stack;

public class LoopTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//循环先序遍历
	public void cyclePreOrderTraverse(Node root){
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while(node!=null||!stack.isEmpty()){
			while(node!=null){
				stack.push(node);
				System.out.println(node.value);
				node=node.left;
			}
			if(!stack.isEmpty()){
				node = stack.pop();
				node = node.right;
			}
		}
		
	}
	//循环中序遍历
	public void cycleInOrderTraverse(Node root){
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		while(node!=null||!stack.isEmpty()){
			while(node!=null){
				stack.push(node);
				node=node.left;
			}
			if(!stack.isEmpty()){
				node = stack.pop();
				System.out.println(node.value);
				node = node.right;
			}
		}
	}
	//循环后序遍历
	public void cyclePostOrderTraverse(Node root){
		Stack<Node> stack = new Stack<Node>();
		Node node = root;
		stack.push(root);
		Node pre = null;
		while(!stack.isEmpty()){
			node = stack.peek();
			if(node.left==null && node.right==null || pre!=null && (pre==node.left || pre==node.right)){
				System.out.println(node.value);
				stack.pop();
				pre = node;
			}else{
				if(node.right!=null){
					stack.push(node.right);
				}
				if(node.left!=null){
					stack.push(node.left);
				}
			}
		}
	}
}
