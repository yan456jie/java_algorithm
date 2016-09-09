package test;

import java.util.Scanner;

public class StringGame {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner reader=new Scanner(System.in);
		while(reader.hasNext()){
			int n = reader.nextInt();
			int m = reader.nextInt();
			String ss = reader.next();
			int[] indexs = new int[m];
			char[] chars = new char[m];
			for(int i=0; i<m; i++){
				indexs[i] = reader.nextInt();
				chars[i] = reader.next().charAt(0);
			}
			changeStr(ss.toCharArray(), indexs, chars);
		}
		/*
		*/
	}
	//替换一个字符以后统计替换次数
	public static void changeStr(char[] s, int[] indexs, char[] chars){
		
		for(int i=0; i<indexs.length; i++){
			int index = indexs[i];
			char c = chars[i];
			s[index-1] = c;
			int count = computeCount(s);
			System.out.println(count);
		}
		
	}
	//统计替换次数
	public static int computeCount(char [] data){
		boolean start = false;
		int count = 0;
		for(int i=0; i<data.length; i++){
			char c = data[i];
			if(c=='.'){
				if(start){
					count++;
				}
				start = true;
			}else{
				start = false;
			}
		}
		return count;
	}
}
