package _27_BitreeToTwowaylist;

import init.Node;

public class BitreeToTwowaylist {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//��������ת��˫������
	public Node tranTreeLink(Node node,int label){
		if(node!=null){
			//��¼�¸��ڵ�����
			Node par = node;
			//ȡ�����������ұ߽ڵ�
			Node left = tranTreeLink(node.left, -1);
			par.left = left;
			//ȡ������������߽ڵ�
			Node right = tranTreeLink(node.right, 1);
			par.right = right;
			//��������������ұ߽ڵ�
			if(label==-1){
				if(right==null){
					return par;
				}else{
					return right;
				}
			}else if(label==1){//�ұ�������������߽ڵ�
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
