package sort_common;

import java.util.ArrayList;
import java.util.List;

public class BuketSort {
	
	static int[] data = {22,23,25,22,34,30};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		sort(data);
	}

	public static void sort(int[] data){
		ArrayList<List> temp = new ArrayList<List>();
		//���ݸ�λ����
		initArray(temp);
		sortByPosition(temp, 1);
		getArrayToData(temp, data);
		print(data);
		//����ʮλ����
		initArray(temp);
		sortByPosition(temp, 2);
		getArrayToData(temp, data);
		print(data);
	}
	/*
	 * ��ʼ����������
	 */
	public static void initArray(ArrayList<List> temp){
		for(int i=0; i<10; i++){
			ArrayList<Integer> list = new ArrayList<Integer>();
			temp.add(list);
		}
	}
	
	/*
	 * ����ĳһλ����Ͱ��k=1,��λ��k=2ʮλ
	 */
	public static void sortByPosition(ArrayList<List> temp, int k){
		int p = 1;
		while(k>1){
			p=p*10;
			k--;
		}
		int t = 0;
		//���ݸ�λ����Ͱ��
		for(int i=0; i<data.length; i++){
			data[i] = data[i]/p;
			t = data[i]%p;
			ArrayList<Integer> list = (ArrayList<Integer>) temp.get(t);
			list.add(data[i]);
		}
	}
	
	/*
	 * ȡ�����������е����ݣ�����data��
	 */
	public static void getArrayToData(ArrayList<List> temp, int[] data){
		//ȡ��Ͱ������
		for(int i=0,k=0; i<temp.size(); i++){
			ArrayList<Integer> list = (ArrayList<Integer>) temp.get(i);
			if(list!=null){
				for(int j=0; j<list.size(); j++){
					data[k++]=list.get(j);
				}
			}
		}
	}
	
	
	public static void print(int[] data){
		for(int i=0; i<data.length; i++){
			System.out.println(data[i]);
		}
	}
}
