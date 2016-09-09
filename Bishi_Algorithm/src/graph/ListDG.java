package graph;
/**
 * 
 * @author yanjie
 *
 */
public class ListDG {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] vexs = {'1','2','3','4','5','6'};
		char[][] edges = {
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'},
				{'1','2','3'}
				};
		
	}

	// �ڽӱ��б��Ӧ������Ķ���
    private class ENode {
        int ivex;       // �ñ���ָ��Ķ����λ��
        int weight;       // �ñ�Ȩֵ
        ENode nextEdge; // ָ����һ������ָ��
    }
    
    // �ڽӱ��б�Ķ���
    private class VNode {
        char data;          // ������Ϣ
        ENode firstEdge;    // ָ���һ�������ö���Ļ�
    };
    
    private VNode[] mVexs;  // ��������
    
    /*
     * ����ͼ(�����ṩ�ľ���)
     *
     * ����˵����
     *     vexs  -- ��������
     *     edges -- ������
     */
    public ListDG(char[] vexs, char[][] edges) {
        
        // ��ʼ��"������"��"����"
        int vlen = vexs.length;
        int elen = edges.length;
        
        // ��ʼ��"����"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstEdge = null;
        }
        
        // ��ʼ��"��"
        for (int i = 0; i < elen; i++) {
            // ��ȡ�ߵ���ʼ����ͽ�������
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);
            int weight = edges[i][2];
            // ��ʼ��node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            // ��node1���ӵ�"p1���������ĩβ"
            if(mVexs[p1].firstEdge == null)
              mVexs[p1].firstEdge = node1;
            else
                linkLast(mVexs[p1].firstEdge, node1);
        }
    }
    
    private int getPosition(char c){
    	for(int i=0; i<mVexs.length; i++){
    		if(mVexs[i].data==c)
    			return i;
    	}
    	System.out.println("��������!");
    	System.exit(0);
    	return -1;
    }
    
    private void linkLast(ENode cur, ENode new_node){
    	while(cur.nextEdge!=null)
    		cur = cur.nextEdge;
    	cur.nextEdge = new_node;
    }
}
