package _27_BitreeToTwowaylist;

import init.Node;

public class BitreeToTwowaylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//将二叉树转成双向链表
	public Node tranTreeLink(Node node,int label){
		if(node!=null){
			//记录下父节点引用
			Node par = node;
			//取得左子树最右边节点
			Node left = tranTreeLink(node.left, -1);
			par.left = left;
			//取得右子树最左边节点
			Node right = tranTreeLink(node.right, 1);
			par.right = right;
			//左边子树返回最右边节点
			if(label==-1){
				if(right==null){
					return par;
				}else{
					return right;
				}
			}else if(label==1){//右边子树返回最左边节点
				if(left==null){
					return par;
				}else{
					return left;
				}
			}
		}
		return null;
	}
}
