package maxCommon;
/**
 * 找到最长公共子串,可以不连续
 * AGTA和AGGCT最长公共子串为AGT
 * @author root
 */
public class MaxCommonUnSeries {
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String s1 = "AGTA";
		String s2 = "AGGCT";
		//String s1 = "Marginle";
		//String s2 = "Valaienie";
		//String s = find(s1.toCharArray(), 0, s2.toCharArray(), 0);
		String s = find(s1.toCharArray(), s2.toCharArray());
		System.out.println(s);
	}
	/*
	 * 普通递归方法
	 */
	public static String find(char []s1, int s1_b, char []s2, int s2_b){
		String temp1 = "";
		String temp2 = "";
		String temp3 = "";
		String result = "";
		if(s1_b>=s1.length || s2_b>= s2.length){
			return "";
		}
		if(s1[s1_b]==s2[s2_b]){
			temp1+= s1[s1_b];
			//System.out.println("s1[s1_b]:"+s1[s1_b]+" "+"s1[s2_b]:"+s1[s2_b]);
			String s = find(s1, s1_b+1, s2, s2_b+1);
			temp1+= s;
			//return temp;
		}else{
			temp2 = find(s1, s1_b+1, s2, s2_b);
			temp3 = find(s1, s1_b, s2, s2_b+1);
		}
		result = temp1.length()>temp2.length()?temp1:temp2;
		result = result.length()>temp3.length()?result:temp3;
		//System.out.println("temp1:"+temp1+" "+"temp2:"+temp2+" "+"temp3:"+temp3+" ");
		return result;
	}
	/*
	 * 动态规划,path的值是[1-i][1-j]的字符串重复次数
	 */
	public static String find(char []ss1, char []ss2){
		char []s1 = ("0"+new String(ss1)).toCharArray();
		char []s2 = ("0"+new String(ss2)).toCharArray();
		int[][] path = new int[ss1.length+1][ss2.length+1];
		int[][] b = new int[ss1.length+1][ss2.length+1];
		for(int i=1; i<path.length; i++){
			for(int j=1; j<path[i].length; j++){
				if(s1[i]==s2[j]){//找到，重复字符串次数加一
					path[i][j]=path[i-1][j-1]+1;
					b[i][j]=0;
				}else if(path[i-1][j]>path[i][j-1]){//选择较大的重复
					path[i][j]=path[i-1][j];
					b[i][j]=1;
				}else{
					path[i][j]=path[i][j-1];
					b[i][j]=-1;
				}
			}
		}
		printMatrix(path, b);
		findPath(s1, b, b.length-1, b[0].length-1);
		
		return "";
	}
	/*
	 * 动态规划-回溯法找路径
	 */
	public static void findPath(char []s1, int[][] b, int i, int j){
		if(i==0 || j==0){
			return;
		}
		if(b[i][j]==0){
			findPath(s1, b, i-1, j-1);
			System.out.print(s1[i]);
		}else if(b[i][j]==1){
			findPath(s1, b, i-1, j);
		}else{
			findPath(s1, b, i, j-1);
		}
	}
	/*
	 * 输出矩阵
	 */
	public static void printMatrix(int[][] path, int[][] b){
		for(int i=1; i<path.length; i++){
			for(int j=1; j<path[i].length; j++){
				System.out.print(path[i][j]+" ");
			}
			System.out.println();
		}
		System.out.println();
		for(int i=1; i<b.length; i++){
			for(int j=1; j<b[i].length; j++){
				System.out.print(b[i][j]+" ");
			}
			System.out.println();
		}
	}
}
