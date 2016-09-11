package _19_treeMiro;

import init.Node;

public class TreeMiro {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//Ê÷µÄ¾µÏñ
	public void treeMiro(Node root){
		if(root!=null){
			if(root.left!=null || root.right!=null){
				Node temp = root.left;
				root.left = root.right;
				root.right = temp;
			}
			treeMiro(root.left);
			treeMiro(root.right);
		}
	}
}
