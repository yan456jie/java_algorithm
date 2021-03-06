package saima;

import java.util.Scanner;

/**
 * 
小赛背了一个大竹筐，这些吃的够它走N公里。沿途中有若干个村庄可以补充食物。
在它竹筐的食物足够可以走到下一个村庄的时候它就不用补充，这样背起来不累而且不花费时间。
地图上可以看到村庄之间的距离，现在它要规划一下它的路线，确定在哪些村庄补充食物可以使沿途补充食物的次数最少。
你能帮帮小赛吗？
 输入
第一行有两个数字，第一个数字为竹筐装满可以走的公里数，即N值；第二个数字为起点到终点之间的村庄个数。
第二行为起点和村庄、村庄之间、村庄和终点之间的距离。这些数字都为整数，且范围不能超过一个int型表达的范围。
样例输入
7 4
5  6  3  2  2
输出 程序输出为至少需要补充食物的次数。
2
 * @author yanjie
 *
 */
public class Viliage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Viliage m = new Viliage();
		while(sc.hasNext()) {
			int volumn = sc.nextInt();
			int n = sc.nextInt();
			int [] distance = new int[n+1];
			for(int i=0; i<n+1; i++) {
				distance[i] = sc.nextInt();
				if (distance[i] > volumn){
	                System.out.println(0);
	                return;
	            }
			}
			System.out.println(searchCount(distance,volumn));
		}
	}
	public static int searchCount(int [] distance, int volumn){
		int i = 0;
		int c = 0;
		int sum = 0;
		while(i<distance.length){
			if(sum<=volumn){
				sum+=distance[i];
				++i;
			}else{
				sum=0;
				--i;
				++c;
			}
		}
		return c;
	}
}
