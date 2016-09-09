package sort_common;
/**
 * �����
 * @author root
 *
 */
public class HeapSort {
	
	static int[] data = {0,9,4,6,2,5};
	static int[] data1 = {0,2,4,5,3,1,7,6};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort(data1);
		print(data1);
	}
	//������
	public static void sort(int[] data){
		int length = data.length-1;
		//��������ѣ������һ�����ӽڵ㿪ʼ���������µ���
		//(n/2)*log(n)
		for(int i=length/2; i>0; --i){
			heapAjdust1(data, i, length);
		}
		//����ÿ�ν��Ѷ��ŵ����棬Ȼ������ѣ�
		for(int i=length; i>1; --i){
			int t = data[1];
			data[1] = data[i];
			data[i] = t;
			heapAjdust1(data, 1, i-1);
		}
	}
	//���µ���(�α��ϵ�)
	public static void heapAjdust(int[] data, int s, int m){
		int temp = data[s];
		for(int j=2*s; j<=m; j*=2){
			if((j+1)<=m && data[j]<data[j+1])
				j++;
			if(data[s]>=data[j])
				break;
			data[s] = data[j];
			s=j;
		}
		data[s] = temp;
	}
	/**
	 * ���µ���(�Լ���д��)�����ں��ӽڵ���������������ϴ��ӽ������������µ���
	 * ��������������������ȣ�log(n)
	 * @param data 
	 * @param s ��Ҫ���µ����Ľڵ����
	 * @param m ���һ���ڵ����
	 */
	public static void heapAjdust1(int[] data, int s, int m){
		for(int j=2*s; j<=m; j*=2){//��s���ӽڵ㿪ʼ��һֱ�����һ���ڵ�
			//ȡ�ϴ�ڵ�
			if((j+1)<=m && data[j]<data[j+1])//�����ҽڵ㣬������ڵ�С���ҽڵ�
				j++;
			if(data[s]>=data[j])//s�ڵ�ֵ���ڽϴ�ڵ㣬��s�ڵ�����������ﶼ�󣬽���
				break;
			int t = data[s];//sС�ں��ӣ���s�뺢�ӽ���
			data[s] = data[j];
			data[j] = t;
			s=j;//sת�����ӽڵ��ϣ������뺢�ӱȽ�
		}
	}
	
	public static void print(int[] data){
		for(int i=1; i<data.length; i++){
			System.out.println(data[i]);
		}
	}
}
