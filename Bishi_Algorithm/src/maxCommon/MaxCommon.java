package maxCommon;
/**
 * 找到最长公共子序列
 * @author root
 */
public class MaxCommon {
	
	static String longest = "";
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s1 = "BAGTA";
		String s2 = "AGTGTCT";
		//find(s1.toCharArray(), 0, s2.toCharArray(), 0);
		find(s1.toCharArray(), s2.toCharArray());
		System.out.println(longest);
	}
	/*
	 * 普通递归方法
	 */
	public static String find(char []s1, int s1_b, char []s2, int s2_b){
		String temp1 = "";
		if(s1_b>=s1.length || s2_b>= s2.length){
			return "";
		}
		if(s1[s1_b]==s2[s2_b]){
			temp1+= s1[s1_b];
			String s = find(s1, s1_b+1, s2, s2_b+1);
			temp1+= s;
			if(longest.length()<temp1.length()){
				longest = temp1;
			}
			//return temp;
		}else{
			//遇到不相等的字符，重新计算最长字符
			find(s1, s1_b+1, s2, s2_b);
			find(s1, s1_b, s2, s2_b+1);
		}
		return temp1;
	}
	/*
	 * 动态规划
	 */
	public static String find(char []ss1, char []ss2){
		char []s1 = ("0"+new String(ss1)).toCharArray();
		char []s2 = ("0"+new String(ss2)).toCharArray();
		int[][] path = new int[ss1.length+1][ss2.length+1];
		int[][] b = new int[ss1.length+1][ss2.length+1];
		for(int i=1; i<path.length; i++){
			for(int j=1; j<path[i].length; j++){
				if(s1[i]==s2[j]){
					path[i][j]=path[i-1][j-1]+1;
					b[i][j]=1;
				}
			}
		}
		print(b);
		findPath(s1, b, b.length-1, b[0].length-1);
		return "";
	}
	/*
	 * 动态规划-回溯法找对角最长路径
	 */
	static String temp = "";
	public static void findPath(char []s1, int[][] b, int i, int j){
		if(i==0 || j==0){
			return;
		}
		if(b[i][j]==1){
			temp=s1[i]+temp;
			findPath(s1, b, i-1, j-1);
		}else if(b[i][j]==0){
			if(longest.length()<temp.length()){
				longest = temp;
			}
			temp = "";
			findPath(s1, b, i-1, j);
			findPath(s1, b, i, j-1);
		}
	}
	public static void print(int[][] b)
	{
		for(int i=0; i<b.length; i++){
			for(int j=0; j<b[i].length; j++){
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}
}
