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

	// 邻接表中表对应的链表的顶点
    private class ENode {
        int ivex;       // 该边所指向的顶点的位置
        int weight;       // 该边权值
        ENode nextEdge; // 指向下一条弧的指针
    }
    
    // 邻接表中表的顶点
    private class VNode {
        char data;          // 顶点信息
        ENode firstEdge;    // 指向第一条依附该顶点的弧
    };
    
    private VNode[] mVexs;  // 顶点数组
    
    /*
     * 创建图(用已提供的矩阵)
     *
     * 参数说明：
     *     vexs  -- 顶点数组
     *     edges -- 边数组
     */
    public ListDG(char[] vexs, char[][] edges) {
        
        // 初始化"顶点数"和"边数"
        int vlen = vexs.length;
        int elen = edges.length;
        
        // 初始化"顶点"
        mVexs = new VNode[vlen];
        for (int i = 0; i < mVexs.length; i++) {
            mVexs[i] = new VNode();
            mVexs[i].data = vexs[i];
            mVexs[i].firstEdge = null;
        }
        
        // 初始化"边"
        for (int i = 0; i < elen; i++) {
            // 读取边的起始顶点和结束顶点
            int p1 = getPosition(edges[i][0]);
            int p2 = getPosition(edges[i][1]);
            int weight = edges[i][2];
            // 初始化node1
            ENode node1 = new ENode();
            node1.ivex = p2;
            // 将node1链接到"p1所在链表的末尾"
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
    	System.out.println("数据有误!");
    	System.exit(0);
    	return -1;
    }
    
    private void linkLast(ENode cur, ENode new_node){
    	while(cur.nextEdge!=null)
    		cur = cur.nextEdge;
    	cur.nextEdge = new_node;
    }
}
