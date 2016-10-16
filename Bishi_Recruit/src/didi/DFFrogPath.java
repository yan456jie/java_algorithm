package didi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * �������Թ����⣬m*n���Թ�����������ֻ��10����������������1��������������3�����²�����������
 * ������(0,n-1)
{{1,0,0,1},
{1,1,0,1},
{0,1,1,1},
{0,0,1,1}};
 * @author yanjie
 *
 */
public class DFFrogPath {

    public static void main(String[] args) {
        int[][] maze = {{1,0,0,1},
		                {1,1,0,1},
		                {0,1,1,1},
		                {0,0,1,1}};
        DFFrogPath fp = new DFFrogPath();
        int[][] move = {{0,-1},{0,1},{-1,0},{1,0}};
        Stack<Point> s = new Stack<Point>();
        int a = fp.path(maze, move, s);
        while(!s.isEmpty()){
        	Point step = s.pop();
            System.out.println(step.x+" "+step.y);
        }
    }
    public int path(int[][] maze,int[][] move,Stack<Point> s){
    	Point temp = new Point(0,0,0,0); //���
        s.push(temp);
        //ջ��Ϊ�գ����ҵ�ǰ����С��10
        while(!s.isEmpty() && temp.p<10){
            temp = s.pop();
            int x = temp.x;
            int y = temp.y;
            int d = 0;
            int p = temp.p;
            while(d<4){
                int i = x + move[d][0];
                int j = y + move[d][1];
                //�õ�ɴ�
                if(i>=0 && j>=0 && i<maze.length && j<maze.length && maze[i][j] == 1 && temp.p<10){
                    temp = new Point(i,j,d,p); //�����µ�
                    s.push(temp);
                    x = i;
                    y = j;
                    maze[x][y] = -1;  //�����µ㣬��־�Ѿ�����
                    if(x == 0 && y == 3){
                        return 1;  //������ڣ��Թ���·������1
                    }else{
                        d = 0;  //���³�ʼ������
                    }
                }else{
                    d++; //�ı䷽��
                }
            }
        }
        return 0;
    }
    class Point{
        int x,y,d,p;
        public Point(int x,int y,int d, int p) {
            this.x = x;//������
            this.y = y;//������
            this.d = d;//����
            if(d==0){
            	this.p = p+3;//����
            }else if(d==1){
            	this.p = p;//����
            }
            else {
            	this.p = p+1;//����
            }
            
        }
    }
}
