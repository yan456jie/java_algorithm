package isBlance;

import init.BiTree;
import init.Node;

/**
 * �ж����Ƿ���ƽ�������
 * ����һ���Ӹ��ڵ�ݹ��ж�ÿ���ڵ��Ƿ�ƽ��
 * @author yanjie
 *
 */
public class IsBlanceTree1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int []data = {8,9,5,3,6,2,4,7};
		BiTree bt = new BiTree();
		Node root = bt.creatBiTree(data);
		System.out.println(isBlance(root.left));
		
	}
	//����һ,�ж�ÿ�����Ƿ�ƽ��
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
	//�õ����
	public static int getDeep(Node root){
		if(root!=null){
			int l = getDeep(root.left);
			int r = getDeep(root.right);
			return l>r?l+1:r+1;
		}
		return 0;
	}
}
