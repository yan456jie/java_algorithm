package mazeTravel;

import java.util.Stack;

/**
 * ��������Թ�����
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
public class DFPath {

    public static void main(String[] args) {
    	//�Թ��㣬1��ʾ���ߣ�0��ʾ�����ߣ�(0,0)Ϊ��ڣ�(0,3)Ϊ����
        int[][] maze = {{1,1,1,0,1},
		        		{1,0,1,0,1},
		        		{1,0,1,1,1},
		        		{1,1,0,1,1},
		        		{0,0,0,1,1}};
        //�����ߵķ�����������
        int[][] move = {{0,-1},{0,1},{-1,0},{1,0}};
        //ʹ��ջs�洢·��
        Stack<Point> s = new Stack<Point>();
        int a = path(maze, move, s);
        if(a==1){
        	while(!s.isEmpty()){//����ǵ���
            	Point step = s.pop();
                System.out.println(step.x+" "+step.y);
            }
        }
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
    public static int path(int[][] maze,int[][] move,Stack<Point> s){
    	Point temp = new Point(0,0); //���
    	maze[0][0]=-1;//��ʾ�Ѿ����ʹ��������
    	int m=maze.length-1,n=maze[0].length-1;
        s.push(temp);
        //ջ��Ϊ��
        while(!s.isEmpty()){
        	//ȡջ���ĵ�
            temp = s.peek();
            int d = 0;
            //�������������ĸ�����
            while(d<4){
                int i = temp.x + move[d][0];
                int j = temp.y + move[d][1];
                //�õ㲻Խ�磬�ҿɴ�
                if(i>=0 && j>=0 && i<=m && j<=n && maze[i][j]==1){
                    temp = new Point(i,j); //�����µ�
                    s.push(temp);
                    maze[i][j] = -1;  //�����µ㣬��־�Ѿ�����
                    if(i == 0 && j == n){
                        return 1;  //������ڣ��Թ���·������1
                    }else{
                        d = 0;  //��ʱtemp���Ѿ�����Ϊ�µ��ˣ����³�ʼ������
                    }
                }else{
                    d++; //�ı䷽��
                }
            }
            //��������Χ�ĸ��㣬��û��ͨ�����򵯳������
            s.pop();
        }
        return 0;
    }
    static class Point{
        int x,y;
        public Point(int x,int y) {
            this.x = x;//������
            this.y = y;//������
        }
    }
}
