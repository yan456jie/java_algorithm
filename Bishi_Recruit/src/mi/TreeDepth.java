package mi;

import java.util.Scanner;

public class TreeDepth {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			Node tree = null;
			for(int i=0; i<n-1; i++){
				int par = sc.nextInt();
				int cur = sc.nextInt();
				//System.out.println(i+"###");
				//System.out.println(par+" "+cur);
				if(i==0){
					tree = new Node(par);
					travelInsert(tree, par, cur);
				}else{
					travelInsert(tree, par, cur);
				}
			}
			int d = getDepth(tree);
			System.out.println(d);
		}
	}
	
	public static void travelInsert(Node node, int par, int cur){
		if(node!=null){
			if(node.value==par){
				insert( node, cur);
				return;
			}
			travelInsert(node.left, par, cur);
			travelInsert(node.right, par, cur);
		}
	}
	
	public static void insert(Node node, int cur){
		
		if(node.left==null){
			node.left = new Node(cur);
		}else if(node.right==null){
			node.right = new Node(cur);
		}
	}
	
	public static int getDepth(Node root){
		int depth = 0;
		int left = 0;
		int right = 0;
		if(root!=null){
			depth++;
			left = getDepth(root.left);
			right = getDepth(root.right);
		}
		return depth+(left>right?left:right);
	}
}
class Node {
	public int value;
	public Node left = null;
	public Node right = null;
	public Node(int value){
		this.value = value;
	}
}