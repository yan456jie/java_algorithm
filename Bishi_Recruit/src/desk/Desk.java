package desk;

/**
 * һ��������n�����ȳ������ȣ�������ȴ�������������һ���ʱ�����ӿ���ƽ��
 * ÿ���һ������Ҫwi�Ĵ��ۣ�������С����ʹ���ӱ���ƽ��
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
		//��������
		int[] l = {2,2,1,1,3,3};
		//Ȩ������
		int[] w = {4,3,5,5,2,1};
		//���������飬0Ϊ������1Ϊ���
		int[] b = {0,0,0,0,0,0};
		desk(l, w, b, l.length-1, curW);
		//desk1(l, w, b, 0, curW);
		System.out.println(minW);
		
		//System.out.println(isBlance(l, b));
	}
	//��С����,��ʼ��Ϊ���д��ۺͣ��˴�ʡ��
	static int minW = 100;
	//��ǰ����
	static int curW = 0;
	/**
	 * �Ӻ���ǰ�ݹ飬��������������Ⱦ�����Ǳ���
	 * @param l ����
	 * @param w ����
	 * @param b �Ƿ����
	 * @param k ��k����
	 */
	public static void desk(int [] l, int [] w, int []b, int k, int curW) {
		int temp[] = new int[b.length];
		System.arraycopy(b, 0, temp, 0, b.length);
		//�ر�ע������жϺ���һ���ж�֮���˳��
		if(isBlance(l, temp)){//��������Ƿ�ƽ��
			for(int i=0; i<l.length; i++){
				System.out.print(temp[i]);
			}
			System.out.println();
			if(minW>curW){//ƽ�⣬���������
				minW = curW;
			}
		}
		if(k<0)
			return;
		//�����k��
		desk(l, w, temp, k-1,curW);
		//�����k��
		temp[k]=1;
		desk(l, w, temp, k-1 ,curW+w[k]);
	}
	/**
	 * ��ǰ����ݹ飬��������������Ⱦ�����Ǳ���
	 * @param l ����
	 * @param w ����
	 * @param b �Ƿ����
	 * @param k ��k����
	 */
	public static void desk1(int [] l, int [] w, int []b, int k, int curW) {
		int temp[] = new int[b.length];
		System.arraycopy(b, 0, temp, 0, b.length);
		//�ر�ע������жϺ���һ���ж�֮���˳��
		if(isBlance(l, temp)){//��������Ƿ�ƽ��
			for(int i=0; i<l.length; i++){
				System.out.print(temp[i]);
			}
			System.out.println();
			if(minW>curW){//ƽ�⣬���������
				minW = curW;
			}
		}
		if(k>=l.length)
			return;
		//�����k��
		desk1(l, w, temp, k+1,curW);
		//�����k��
		temp[k]=1;
		desk1(l, w, temp, k+1 ,curW+w[k]);
	}
	/**
	 * ʹ�ö�̬�滮���
	 */
	/**
	 * @param l ���ȳ�������
	 * @param b �Ƿ������飬1���
	 * @return �Ƿ�ƽ��
	 */	
	public static boolean isBlance(int [] l, int []b) {
		int max = 0;
		int len = 0;
		//�ҵ����������ֵmax
		for(int i=0; i<l.length; i++){
			if(l[i]>max)
				max = l[i];
			if(b[i]==0)
				++len;
		}
		//��û��������Գ���Ϊkeyͳ�Ƴ��ִ���
		int count[] = new int[max+1];
		for(int i=0; i<l.length; i++){
			if(b[i]==0){
				count[l[i]]++;
			}
		}
		//�ҵ�����������ȣ��ж�������Ƿ����һ��
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
