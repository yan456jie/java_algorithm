package jd;

import java.util.Scanner;

/**
 * ���λ��
��Ŀ������
СB�����������˶����»���������Ϳ��Է����Լ���һ���س��������½�˵��СB��Ϊ����ĸ���ֵ����֮
����Ϭ����λ������ڶг�����ӵ��һ������˿��
һ��һ�ȵ��˶����ּ�����ʼ���⽫��һ���������ĵļ��ڣ�ÿ���˶����Լ���Ŀ�꣺�˶�Աϣ�������ά
�ƣ�����ϣ�����͵������˶�Ա�ľ��ʱ��֣���˵Ա��Ҫ�����������λ���Ա�ۿ������ۡ�
���������������Բ�ε��˶���ͬʱ���У�СBϣ���ܹ��ڴ˴ε����½�˵����չ���ˣ�ռ����ѵĹ۲�㣬��
���ܹ��ۿ������˶����ϵı��������ڽ������������ͬ����Ҫ����ϣ������ͬ�ӽǣ��۲�㵽�˶�����Ե��
�ߵļнǣ��ۿ��˶�����������������Ĺ۲�㲻ֹһ������ϣ����ѡ��������ӽǵĹ۲�㡣 
СB��Ѱ�ҹ۲�㲻�Ǻ����У���ϣ�������æѰ������ʵĹ۲�㡣��Ҫָ�����ǣ��˶����ݶ���¶��ģ���
˵Ա�����߲����ڵ���

����
�������ж���������ݡ�ÿ��������ݰ���3�У�ÿ�д���һ���˶�����ÿ�еĸ�ʽΪx y r�����У�x, y��Ϊ
�˶������ĵ����꣬rΪ�˶����İ뾶��-1000<=x, y<=1000��1<= r <=1000���������ݾ�Ϊ�������˶�������

�ཻ���޹����㣩�������ĵ㲻��ͬһֱ���ϡ�
���
��ÿ��������ݣ���������ѹ۲�㣬���ڵ�����һ��������ĵ�����꣨����6λС���������������No����

��������
0 0 10
60 0 10
30 30 10
�������
30.000000 0.000000
 * ת��Ϊ��ֱ������ϵ����һ�㵽����Բ����������������ͬ�����⣬�ɵõ�������Ԫ���η���
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