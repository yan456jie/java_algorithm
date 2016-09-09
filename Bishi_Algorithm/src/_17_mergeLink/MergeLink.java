package _17_mergeLink;
/**
 * ºÏ²¢Á´±í
 * @author yanjie
 *
 */
public class MergeLink {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MergeLink rl = new MergeLink();
		int [] data1 = {2,4,6,8};
		int [] data2 = {1,2,3,7,9,11};
		Node p1 = rl.init(data1);
		Node p2 = rl.init(data2);
		
		rl.print(p1);
		rl.print(p2);
		
		Node result = rl.merge(p1, p2);
		rl.print(result);
	}
	
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
	
	public Node merge(Node p1, Node p2){
		Node p = new Node(-1);
		Node result = p;
		while(p1!=null && p2!=null){
			if(p1.data<p2.data){
				p.next = p1;
				p = p1;
				p1 = p1.next;
			}else{
				p.next = p2;
				p = p2;
				p2 = p2.next;
			}
			
		}
		if(p1!=null){
			p.next = p1;
		}
		if(p2!=null){
			p.next = p2;
		}
		return result.next;
	}
	
	public void print(Node p){
		while(p!=null){
			System.out.print(p.data+" ");
			p=p.next;
		}
		System.out.println();
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

