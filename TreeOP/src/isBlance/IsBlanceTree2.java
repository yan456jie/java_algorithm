package isBlance;

import init.BiTree;
import init.Node;

/**
 * �ж����Ƿ���ƽ�������
 * ���������ݹ���ݹ����п�ÿ���ڵ��Ƿ�ƽ��
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
	//������,�ж�ÿ�����Ƿ�ƽ��
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
