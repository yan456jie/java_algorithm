package levelNodeCount;

import init.Node;

import java.util.LinkedList;
import java.util.Queue;

public class LevelNodeCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//k层的节点数
	public int levelNodeCount(Node root, int k){
		int node_count = 0;
		int c_l = 0;
		if(root==null)
			return node_count;
		Queue<Node> de = new LinkedList<Node>();
		Node split = new Node(-999);
		de.add(split);
		de.add(root);
		while(de.size()>1){
			Node node = de.poll();
			if(node==split){
				de.add(split);
				c_l++;
				continue;
			}
			if(c_l==k){
				++node_count;
			}
			if(node.left!=null){
				de.add(node.left);
			}if(node.right!=null){
				de.add(node.right);
			}
		}
		return node_count;
	}
}
