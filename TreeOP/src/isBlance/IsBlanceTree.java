package isBlance;

import init.BiTree;
import init.Node;

/**
 * 判断树是否是平衡二叉树
 * 方法一、从根节点递归判断每个节点是否平衡
 * 方法二、递归回溯过程中看每个节点是否平衡
 * @author yanjie
 *
 */
public class IsBlanceTree {

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
	
	
	//////////////////////////////////////////
	//方法一,判断每个点是否平衡
	public static boolean isBlance(Node root){
		if(root!=null){
			int left = getDeep(root.left);
			int right = getDeep(root.right);
			boolean b1 = isBlance(root.left);
			boolean b2 = isBlance(root.right);
			
			return Math.abs(left-right)<=1 && b1 && b2;
		}
		return true;
	}
	//得到深度
	public static int getDeep(Node root){
		if(root!=null){
			int l = getDeep(root.left);
			int r = getDeep(root.right);
			return l>r?l+1:r+1;
		}
		return 0;
	}
}
