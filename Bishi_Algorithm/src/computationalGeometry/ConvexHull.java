package computationalGeometry;
/**
 * 凸包算法
 * @author root
 *
 */
public class ConvexHull {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int pa[][] = {{0,0},{1,0},{2,0},{3,0},{4,0},
                {4,1},{4,2},{4,3},{4,4},
                {3,4},{2,4},{1,4},{0,4},
                {0,3},{0,2},{0,1},{2,2},{1,1}};
	}
	
	public static void fun(int pa[][]) {
		//找到左下角p0，先找y最小的，再在其中找x最小的
		for(int i=0; i<pa.length; i++){
			
		}
		//其余每个点和p0组成向量的余弦值大小排序，能够确定的点有p0、p1、pn-1
		//p0、p1、p2进栈，判断p0-p1、p1-p2是否左旋（一定是左旋）
		//p3进栈，判断p1-p2、p2-p3是否左旋
		//不是则p3出栈，p2出栈，p3进栈，p4进栈...
		//判断向量p1=(x1,y1),p2=(x2,y2)是否左旋，x1*y2-x2*y1的正负，正为左旋
	}
}
