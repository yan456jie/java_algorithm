package computationalGeometry;
/**
 * ͹���㷨
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
		//�ҵ����½�p0������y��С�ģ�����������x��С��
		for(int i=0; i<pa.length; i++){
			
		}
		//����ÿ�����p0�������������ֵ��С�����ܹ�ȷ���ĵ���p0��p1��pn-1
		//p0��p1��p2��ջ���ж�p0-p1��p1-p2�Ƿ�������һ����������
		//p3��ջ���ж�p1-p2��p2-p3�Ƿ�����
		//������p3��ջ��p2��ջ��p3��ջ��p4��ջ...
		//�ж�����p1=(x1,y1),p2=(x2,y2)�Ƿ�������x1*y2-x2*y1����������Ϊ����
	}
}
