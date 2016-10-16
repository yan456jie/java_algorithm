package didi;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * �����������Թ�����
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
    	//�Թ��㣬1��ʾ���ߣ�0��ʾ�����ߣ�(0,0)Ϊ��ڣ�(0,3)Ϊ����
        int[][] maze = {{1,1,1,0,1},
		        		{1,0,1,0,1},
		        		{1,0,1,1,1},
		        		{1,1,0,1,1},
		        		{0,0,0,1,1}};
        //�����ߵķ�����������
        int[][] move = {{0,-1},{0,1},{-1,0},{1,0}};
        //ʹ�ö���s�洢·��
        
        path(maze, move);
    }
    /**
     * ��(0,0)����ջ����maze[0][0]=-1����ʾ��(0,0)�Ѿ����ʹ���
     * ά��һ����ǰ��temp����һ��tempΪջ�����ж�temp����Χ�ĸ����Ƿ�ɴ
     * ����ɴ���temp����Ϊ�ɴ���Ǹ��㣬����maze·���ж�Ӧλ�ñ��λ-1����ʾ�Ѿ����ʹ�
     * ������ɴ��򵯳�ջ����ȡջ��һ��Ԫ��
     * ��stack��Ϊ��ʱ
     * @param maze
     * @param move
     * @param s
     * @return
     */
    public static void path(int[][] maze,int[][] move){
    	Queue<Point> q = new LinkedList<Point>();
    	q.add(new Point(0,0,null));
    	maze[0][0]=-1;//��ʾ�Ѿ����ʹ��������
    	int m=maze.length-1,n=maze[0].length-1;
        
        //���в�Ϊ��
        while(!q.isEmpty()){
        	//����
        	Point temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int d = 0;//
            while(d<4){
                int i = x + move[d][0];
                int j = y + move[d][1];
                //�õ㲻Խ�磬�ҿɴ�
                if(i>=0 && j>=0 && i<=m && j<=n && maze[i][j]==1){
                	Point point = new Point(i,j,temp); //�½ڵ�ָ��temp
                	if(x==1 && y==4){
                		System.out.println(i+"+"+j);
                	}
                    q.add(point);
                    maze[i][j] = -1;  //�����µ㣬��־�Ѿ�����
                    
                    if(x == 0 && y == n){
                    	//������ڣ��Թ���·�����ŵ�ǰ�ڵ���ǰ��
                    	System.out.println("�ҵ���");
                    	Point cur = temp;
                    	while(cur!=null){
                    		System.out.println(cur.x+" "+cur.y);
                    		cur = cur.pre;
                    	}
                    }
                }else{
                    d++; //�ı䷽��
                }
            }
        }
    }
    static class Point{
        int x,y;
        Point pre;//ǰ���ڵ�
        public Point(int x,int y,Point pre) {
            this.x = x;//������
            this.y = y;//������
            this.pre = pre;//ǰ���ڵ�
        }
    }
}
