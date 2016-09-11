package leafCount;

import init.Node;

public class LeafCount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//叶子节点个数
	int leaf_c = 0;
	public void leafCount(Node root){
		if(root!=null){
			//System.out.println(root.value);
			if(root.left==null && root.right==null){
				++leaf_c;
			}
			leafCount(root.left);
			leafCount(root.right);
		}
	}
}
