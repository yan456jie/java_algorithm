package levelTraverse;

import init.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelTravel {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//²ã´Î±éÀú
	public void levelTraverse(Node root){
		if(root==null)
			return;
		Queue<Node> de = new LinkedList<Node>();
		Node split = new Node(-999);
		de.add(split);
		de.add(root);
		while(de.size()>1){
			Node node = de.poll();
			if(node==split){
				de.add(split);
				System.out.println();
				continue;
			}
			System.out.print(node.value+" ");
			if(node.left!=null){
				de.add(node.left);
			}if(node.right!=null){
				de.add(node.right);
			}
		}
		System.out.println();
	}
}
