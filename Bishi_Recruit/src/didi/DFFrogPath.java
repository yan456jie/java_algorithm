package didi;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


/**
 * 青蛙走迷宫问题，m*n的迷宫，青蛙体力只有10，左右走消耗体力1，向上消耗体力3，向下不消耗体力，
 * 出口在(0,n-1)
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
    	Point temp = new Point(0,0,0,0); //起点
        s.push(temp);
        //栈不为空，并且当前体力小于10
        while(!s.isEmpty() && temp.p<10){
            temp = s.pop();
            int x = temp.x;
            int y = temp.y;
            int d = 0;
            int p = temp.p;
            while(d<4){
                int i = x + move[d][0];
                int j = y + move[d][1];
                //该点可达
                if(i>=0 && j>=0 && i<maze.length && j<maze.length && maze[i][j] == 1 && temp.p<10){
                    temp = new Point(i,j,d,p); //到达新点
                    s.push(temp);
                    x = i;
                    y = j;
                    maze[x][y] = -1;  //到达新点，标志已经到达
                    if(x == 0 && y == 3){
                        return 1;  //到达出口，迷宫有路，返回1
                    }else{
                        d = 0;  //重新初始化方向
                    }
                }else{
                    d++; //改变方向
                }
            }
        }
        return 0;
    }
    class Point{
        int x,y,d,p;
        public Point(int x,int y,int d, int p) {
            this.x = x;//横坐标
            this.y = y;//纵坐标
            this.d = d;//方向
            if(d==0){
            	this.p = p+3;//体力
            }else if(d==1){
            	this.p = p;//体力
            }
            else {
            	this.p = p+1;//体力
            }
            
        }
    }
}
