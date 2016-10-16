package desk;

/**
 * 一张桌子有n个不等长的桌腿，当最常桌腿大于所有桌腿数一半的时候，桌子可以平衡
 * 每锯掉一条腿需要wi的代价，请用最小代价使桌子保持平衡
 * @author Administrator
 *
 */
public class Desk {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n=6;
		//长度数组
		int[] l = {2,2,1,1,3,3};
		//权重数组
		int[] w = {4,3,5,5,2,1};
		//锯掉标记数组，0为保留，1为锯掉
		int[] b = {0,0,0,0,0,0};
		desk(l, w, b, l.length-1, curW);
		//desk1(l, w, b, 0, curW);
		System.out.println(minW);
		
		//System.out.println(isBlance(l, b));
	}
	//最小代价,初始化为所有代价和，此处省略
	static int minW = 100;
	//当前代价
	static int curW = 0;
	/**
	 * 从后往前递归，分两种情况，桌腿锯掉或是保留
	 * @param l 长度
	 * @param w 重量
	 * @param b 是否锯腿
	 * @param k 第k条腿
	 */
	public static void desk(int [] l, int [] w, int []b, int k, int curW) {
		int temp[] = new int[b.length];
		System.arraycopy(b, 0, temp, 0, b.length);
		//特别注意这个判断和下一个判断之间的顺序
		if(isBlance(l, temp)){//检测桌子是否平衡
			for(int i=0; i<l.length; i++){
				System.out.print(temp[i]);
			}
			System.out.println();
			if(minW>curW){//平衡，考虑其代价
				minW = curW;
			}
		}
		if(k<0)
			return;
		//不锯第k条
		desk(l, w, temp, k-1,curW);
		//锯掉第k条
		temp[k]=1;
		desk(l, w, temp, k-1 ,curW+w[k]);
	}
	/**
	 * 从前往后递归，分两种情况，桌腿锯掉或是保留
	 * @param l 长度
	 * @param w 重量
	 * @param b 是否锯腿
	 * @param k 第k条腿
	 */
	public static void desk1(int [] l, int [] w, int []b, int k, int curW) {
		int temp[] = new int[b.length];
		System.arraycopy(b, 0, temp, 0, b.length);
		//特别注意这个判断和下一个判断之间的顺序
		if(isBlance(l, temp)){//检测桌子是否平衡
			for(int i=0; i<l.length; i++){
				System.out.print(temp[i]);
			}
			System.out.println();
			if(minW>curW){//平衡，考虑其代价
				minW = curW;
			}
		}
		if(k>=l.length)
			return;
		//不锯第k条
		desk1(l, w, temp, k+1,curW);
		//锯掉第k条
		temp[k]=1;
		desk1(l, w, temp, k+1 ,curW+w[k]);
	}
	/**
	 * 使用动态规划求解
	 */
	/**
	 * @param l 桌腿长度数组
	 * @param b 是否锯掉数组，1锯掉
	 * @return 是否平衡
	 */	
	public static boolean isBlance(int [] l, int []b) {
		int max = 0;
		int len = 0;
		//找到数组中最大值max
		for(int i=0; i<l.length; i++){
			if(l[i]>max)
				max = l[i];
			if(b[i]==0)
				++len;
		}
		//将没锯的桌子以长度为key统计出现次数
		int count[] = new int[max+1];
		for(int i=0; i<l.length; i++){
			if(b[i]==0){
				count[l[i]]++;
			}
		}
		//找到长度最大桌腿，判断其次数是否大于一半
		for(int i=max; i>=0; i--){
			if(count[i]>0){
				if(count[i]>(len/2))
					return true;
				else
					break;
			}
		}
		return false;
	}
}
