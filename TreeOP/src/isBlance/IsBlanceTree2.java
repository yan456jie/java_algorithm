package isBlance;

import init.BiTree;
import init.Node;

/**
 * 判断树是否是平衡二叉树
 * 方法二、递归回溯过程中看每个节点是否平衡
 * @author yanjie
 *
 */
public class IsBlanceTree2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data = {8,9,5,3,6,2,4,7};
		BiTree bt = new BiTree();
		Node root = bt.creatBiTree(data);
		getDeepIsBlance(root.left);
		System.out.println(b);
		
	}
	static boolean b = true;
	//方法二,判断每个点是否平衡
	public static int getDeepIsBlance(Node root){
		if(root!=null && b){
			int left = getDeepIsBlance(root.left);
			int right = getDeepIsBlance(root.right);
			if(Math.abs(left-right)>1){
				b=false;
			}
			return left>right?left+1:right+1;
		}
		return 0;
	}
}
