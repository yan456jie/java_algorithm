package pass_reference;

/**
 * java传递引用，输出结果3
 * @author root
 *
 */
public class  PassReference{

	static class Node{
		int value;
		Node left = null;
		Node right = null;
		public Node(int value){
			this.value = value;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node node = new Node(0);
		PassReference bt = new PassReference();
		bt.test(node);
		System.out.println(node.value);
		
		
	}
	
	public void test(Node node){
		node.value = 3;
		node = new Node(5);
	}
	
}