package init;

import java.util.Deque;
import java.util.Enumeration;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
/**
 * 创建二叉排序树，二叉树的六种遍历
 * @author root
 *
 */
public class BiTree {

	//创建二叉排序树
	public Node creatBiTree(int []data){
		Node root = new Node(data[0]);
		for(int i=1; i<data.length; i++){
			insert(root, data[i]);
		}
		return root;
	}
	//插入节点
	public void insert(Node root, int value){
		
		if(value<root.value){
			if(root.left==null){
				root.left = new Node(value);
			}else{
				insert(root.left, value);
			}
		}else{
			if(root.right==null){
				root.right = new Node(value);
			}else{
				insert(root.right, value);
			}
		}
	}
}
