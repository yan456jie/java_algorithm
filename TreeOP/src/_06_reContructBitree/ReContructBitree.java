package _06_reContructBitree;

import init.Node;

public class ReContructBitree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//ÖØ½¨¶ş²æÊ÷
	int []pre = {6,5,3,2,1,4,8,7,9};
	int []mid = {1,2,3,4,5,6,7,8,9};
	public void reContructBiTree(int []pre, int pre_begin, int []mid, int mid_begin, int mid_end){
		Node root;
		int index = find(mid, mid_begin, mid_end, pre[pre_begin]);
		reContructBiTree(pre, ++pre_begin, mid, mid_begin, index-1);
		reContructBiTree(pre, ++pre_begin, mid, index+1, mid_end);
	}

	public int find(int []mid, int mid_begin, int mid_end, int data){
		return 0;
	}
}
