package _50_lowestComParent;

import init.BiTree;
import init.Node;
import java.util.Stack;

public class LowestComParent {
	
	static Stack<Node> stack = new Stack<Node>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int []data = {6,5,3,4,2,8,7,9,1};
		int []data = {8,9,5,3,6,2,4,7};
		BiTree bt = new BiTree();
		
		Node root = bt.creatBiTree(data);
		//找到4和7的最低公共祖先
		Node par_node = findLowestComParent(root, 4, 7);
	}
	
	
	public static Node findLowestComParent(Node root, int first, int second){
		if(root!=null){
			stack.push(root);			
			if(first==root.value || root.value==second){//是所求的叶子节点
				for(Node no:stack){
					System.out.print(no.value);
				}
				System.out.println();
			}
			
			findLowestComParent(root.left, first, second);
			findLowestComParent(root.right, first, second);
			stack.pop();
		}
		return null;
	}
}
