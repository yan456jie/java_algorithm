package saima;

import java.util.Scanner;

/**
 * 
С������һ���������Щ�ԵĹ�����N�����;�������ɸ���ׯ���Բ���ʳ�
��������ʳ���㹻�����ߵ���һ����ׯ��ʱ�����Ͳ��ò��䣬�������������۶��Ҳ�����ʱ�䡣
��ͼ�Ͽ��Կ�����ׯ֮��ľ��룬������Ҫ�滮һ������·�ߣ�ȷ������Щ��ׯ����ʳ�����ʹ��;����ʳ��Ĵ������١�
���ܰ��С����
 ����
��һ�����������֣���һ������Ϊ���װ�������ߵĹ���������Nֵ���ڶ�������Ϊ��㵽�յ�֮��Ĵ�ׯ������
�ڶ���Ϊ���ʹ�ׯ����ׯ֮�䡢��ׯ���յ�֮��ľ��롣��Щ���ֶ�Ϊ�������ҷ�Χ���ܳ���һ��int�ͱ��ķ�Χ��
��������
7 4
5  6  3  2  2
��� �������Ϊ������Ҫ����ʳ��Ĵ�����
2
 * @author yanjie
 *
 */
public class Viliage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Viliage m = new Viliage();
		while(sc.hasNext()) {
			int volumn = sc.nextInt();
			int n = sc.nextInt();
			int [] distance = new int[n+1];
			for(int i=0; i<n+1; i++) {
				distance[i] = sc.nextInt();
				if (distance[i] > volumn){
	                System.out.println(0);
	                return;
	            }
			}
			System.out.println(searchCount(distance,volumn));
		}
	}
	public static int searchCount(int [] distance, int volumn){
		int i = 0;
		int c = 0;
		int sum = 0;
		while(i<distance.length){
			if(sum<=volumn){
				sum+=distance[i];
				++i;
			}else{
				sum=0;
				--i;
				++c;
			}
		}
		return c;
	}
}
