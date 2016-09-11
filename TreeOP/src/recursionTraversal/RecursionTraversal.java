package recursionTraversal;

import init.BiTree;
import init.Node;

public class RecursionTraversal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//int []data = {6,5,3,4,2,8,7,9,1};
		int []data = {8,9,5,3,6,2,4,7};
		BiTree bt = new BiTree();
		
		Node root = bt.creatBiTree(data);
	}
	//�ݹ��������
	public void preOrderTraverse(Node root){
		if(root!=null){
			System.out.println(root.value);
			preOrderTraverse(root.left);
			preOrderTraverse(root.right);
		}
	}
	//�ݹ��������
	public void inOrderTraverse(Node root){
		if(root!=null){
			inOrderTraverse(root.left);
			System.out.println(root.value);
			inOrderTraverse(root.right);
		}
	}
	//�ݹ�������
	public void postOrderTraverse(Node root){
		if(root!=null){
			postOrderTraverse(root.left);
			postOrderTraverse(root.right);
			System.out.println(root.value);
		}
	}
}
