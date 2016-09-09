package loserTree;
/**
 * �������ڽ�������ѵ�ԭ���������
 * �����:���ڵ���󣬵ڶ���������ڵ�ֱ�������Ľڵ���ѡ��
 * ���������ĵ�һ����������
 * @author yanjie
 *
 */
public class LoserTree {
	//
	static int[] data1 = {0, 3 ,5 ,7 ,1 ,9 ,11 ,12 ,13};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//sort(data1);
		print(data1);
		allocMem(data1);
	}
	
	/**
	 * ����ռ䣬����ԭ����������������
	 */
	public static void allocMem(int[] data1){
		int[] data = new int[2*data1.length-2];
		System.arraycopy(data1, 0, data, data1.length-2, data1.length);
		print(data);
		sort(data);
		print(data);
		searchFirstAndSecond(data);
	}
	//Ѱ�����͵ڶ����
	public static void searchFirstAndSecond(int[] data){
		if(data.length<3){
			return;
		}
		int first=data[1],second=data[2];
		int j=2;
		while(j<data.length){//
			int next = j;
			if(data[j]!=data[1]){//����ȣ������Ϊ�Ƚ���,����·����nextΪj+1
				next = j+1;
			}else{
				j+=1;
			}
			System.out.println(data[j]);
			if(second<data[j]){
				second = data[j];
			}
			j=2*next;
		}
		System.out.println("first:"+first+" second:"+second);
	}
	/*
	 * ���ƶѵ���
	 */
	public static void sort(int[] data){
		int length = data.length-1;
		//�����һ�����ڵ㿪ʼ����
		//(n/2)*log(n)
		for(int i=length/2; i>0; --i){
			//����s�ڵ�������ӽڵ㣬��֤s�ڵ�ֵΪ�ӽڵ��нϴ�һ��
			int j=2*i;
			if((j+1)<=length && data[j]<data[j+1])//�����ҽڵ㣬������ڵ�С���ҽڵ�
			{
				j+=1;
			}
			data[i] = data[j];
		}		
	}
	
	public static void print(int[] data){
		for(int i=1; i<data.length; i++){
			System.out.print(data[i]+" ");
		}
		System.out.println();
	}
}
