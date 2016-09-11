package _39_treeDepth;

import init.Node;

public class TreeDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//得到树的深度
	public int getDepth(Node root){
		int depth = 0;
		int left = 0;
		int right = 0;
		if(root!=null){
			depth++;
			left = getDepth(root.left);
			right = getDepth(root.right);
		}
		return depth+(left>right?left:right);
	}
}
