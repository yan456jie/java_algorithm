package _16_reverseLink;
/**
 * ��ת����
 * @author yanjie
 *
 */
public class ReverseLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ReverseLink rl = new ReverseLink();
		int [] data = {2};
		Node p = rl.init(data);
		Node rp = rl.reverse(p);
		rl.print(rp);
	}
	/*
	 * ��ʼ��
	 */
	public Node init(int [] data){
		if(data == null || data.length<=0){
			return null;
		}
		Node node = new Node(data[0]);
		Node p1 = node;
		for(int i=1; i<data.length; i++){
			node.next = new Node(data[i]);
			node = node.next;
		}
		return p1;
	}
	/*
	 * ��ת
	 */
	public Node reverse(Node p){
		if(p==null){
			return null;
		}
		Node p1 = null;
		Node p2 = p;
		Node p3 = p.next;
		while(p3!=null){
			p2.next = p1;
			p1 = p2;
			p2 = p3;
			p3=p3.next;
		}
		p2.next = p1;
		return p2;
	}
	
	public void print(Node p){
		while(p!=null){
			System.out.println(p.data);
			p=p.next;
		}
	}
}

class Node{
	int data;
	Node next = null;
	
	public Node(){
	}
	
	public Node(int data){
		this.data = data;
	}
}




