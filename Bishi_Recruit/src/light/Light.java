package light;
/**
 * һ�ٸ������ų�һ�ţ���һ�ֽ����е��ݴ򿪣�
 * �ڶ��֡��������֣�����������Ϩ��ĵ�����������Ϩ��
 * 100���Ժ���Щ����������
 * @author root
 */
public class Light {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun(3);
	}
	public static void print(int[] light) {
		for(int i=1; i<light.length; i++){
			System.out.print(light[i]);
		}
	}
	
	public static void fun(int n) {
		int[] light = new int[101];
		for(int i=1; i<=n; i++){
			int j=1;
			while(j<=100){
				if(light[j]==0)
					light[j] = 1;
				else
					light[j] = 0;
				j+=i;
			}
		}
		print(light);
	}
}
