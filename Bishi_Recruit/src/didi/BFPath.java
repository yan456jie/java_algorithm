package didi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 广度优先求解迷宫问题
{{1,1,0,1},
{1,1,0,1},
{0,1,1,1},
{0,0,1,1}};

{1,1,1,0,1},
{1,0,1,0,1},
{1,0,1,1,1},
{1,1,0,1,1},
{0,0,0,1,1},
 * @author yanjie
 *
 */
public class BFPath {

    public static void main(String[] args) {
    	//迷宫点，1表示可走，0表示不可走，(0,0)为入口，(0,3)为出口
        int[][] maze = {{1,1,1,0,1},
		        		{1,0,1,0,1},
		        		{1,0,1,1,1},
		        		{1,1,0,1,1},
		        		{0,0,0,1,1}};
        //可以走的方向，上下左右
        int[][] move = {{0,-1},{0,1},{-1,0},{1,0}};
        //使用队列s存储路径
        
        path(maze, move);
    }
    /**
     * 将(0,0)点入栈，将maze[0][0]=-1，表示点(0,0)已经访问过了
     * 维护一个当前点temp，第一次temp为栈顶，判断temp其周围四个点是否可达，
     * 如果可达则将temp更新为可达的那个点，并将maze路径中对应位置标记位-1，表示已经访问过
     * 如果不可达则弹出栈顶，取栈下一个元素
     * 当stack不为空时
     * @param maze
     * @param move
     * @param s
     * @return
     */
    public static void path(int[][] maze,int[][] move){
    	Queue<Point> q = new LinkedList<Point>();
    	q.add(new Point(0,0,null));
    	maze[0][0]=-1;//表示已经访问过这个点了
    	int m=maze.length-1,n=maze[0].length-1;
        
        //队列不为空
        while(!q.isEmpty()){
        	//出队
        	Point temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int d = 0;//
            while(d<4){
                int i = x + move[d][0];
                int j = y + move[d][1];
                //该点不越界，且可达
                if(i>=0 && j>=0 && i<=m && j<=n && maze[i][j]==1){
                	Point point = new Point(i,j,temp); //新节点指向temp
                	if(x==1 && y==4){
                		System.out.println(i+"+"+j);
                	}
                    q.add(point);
                    maze[i][j] = -1;  //到达新点，标志已经到达
                    
                    if(x == 0 && y == n){
                    	//到达出口，迷宫有路，沿着当前节点往前找
                    	System.out.println("找到！");
                    	Point cur = temp;
                    	while(cur!=null){
                    		System.out.println(cur.x+" "+cur.y);
                    		cur = cur.pre;
                    	}
                    }
                }else{
                    d++; //改变方向
                }
            }
        }
    }
    static class Point{
        int x,y;
        Point pre;//前驱节点
        public Point(int x,int y,Point pre) {
            this.x = x;//横坐标
            this.y = y;//纵坐标
            this.pre = pre;//前驱节点
        }
    }
}
