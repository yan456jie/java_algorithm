package jd;

import java.util.Scanner;

/**
 * 最佳位置
题目描述：
小B热衷于体育运动赛事活动，这样她就可以发挥自己的一项特长——赛事解说。小B因为自身的高颜值，加之
评论犀利到位、语言诙谐，因此拥有一大批粉丝。
一年一度的运动会又即将开始，这将是一个激动人心的季节，每个人都有自己的目标：运动员希奋力争夺奖
牌，观众希望欣赏到心仪运动员的精彩表现，解说员则要争抢更方便的位置以便观看和评论。
今天的赛事在三个圆形的运动场同时举行，小B希望能够在此次的赛事解说中再展风姿，占据最佳的观察点，从
而能够观看所有运动场上的比赛。由于今天的所有赛事同等重要，她希望以相同视角（观察点到运动场边缘切
线的夹角）观看运动场。如果满足条件的观察点不止一个，她希望首选具有最大视角的观察点。 
小B对寻找观察点不是很在行，她希望请你帮忙寻找最合适的观察点。需要指出的是，运动场馆都是露天的，解
说员的视线不受遮挡。

输入
输入中有多组测试数据。每组测试数据包含3行，每行代表一个运动场。每行的格式为x y r，其中（x, y）为
运动场中心的坐标，r为运动场的半径，-1000<=x, y<=1000，1<= r <=1000。所有数据均为正数，运动场互不

相交（无公共点）且其中心点不在同一直线上。
输出
对每组测试数据，若存在最佳观察点，则在单独的一行里输出改点的坐标（保留6位小数），否则输出“No”。

样例输入
0 0 10
60 0 10
30 30 10
样例输出
30.000000 0.000000
 * 转换为在直角坐标系中求一点到三个圆心与其切线余弦相同的问题，可得到两个二元二次方程
 * @author yanjie
 *
 */
public class Main2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		while(sc.hasNext()) {
			int num = 3;
			Point [] p = new Point[3];
			for(int i=0; i<num; i++) {
				float x = sc.nextFloat();
				float y = sc.nextFloat();
				float r = sc.nextFloat();
				p[i] = new Point(x, y, r);
			}
		}
	
	}
	public int fun(int n) {
		return 0;
	}
	
}
class Point{
	float x;
	float y;
	float r;
	public Point(float x,float y,float r){
		this.x = x;
		this.y = y;
		this.r = r;
	}
	public float getX() {
		return x;
	}
	public void setX(float x) {
		this.x = x;
	}
	public float getY() {
		return y;
	}
	public void setY(float y) {
		this.y = y;
	}
	public float getR() {
		return r;
	}
	public void setR(float r) {
		this.r = r;
	}
}