package bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * ��������,ÿ����Ʒ�м�ֵ
 * @author root
 *
 */
public class Bag {  
	  
    private char [] bags;
    private int all_goods = 3;//�ж��ٸ���Ʒ
    private int [] volume = {0,1,2,1};
    private int [] price  = {0,2,7,3};
    private int capacity  = 2;
    
    public static void main(String[] args) {  
        // TODO Auto-generated method stub 
    	Bag bag = new Bag();
    	bag.init2();
    	bag.dynamicPlaying();
    	//bag.f1();
    }
    public void init1(){
    	bags  = new char[]{'1','2','3'};
        all_goods = 3;//�ж��ٸ���Ʒ
        volume  = new int[]{1,2,1};
        price  = new int[]{2,7,3};
        capacity  = 2;
    }
    
    public void init2(){
    	bags  = new char[]{'e','d','c','b','a'};
        all_goods = 5;//�ж��ٸ���Ʒ
        volume  = new int[]{4,5,6,2,2};
        price  = new int[]{6,4,5,3,6};
        capacity  = 10;
    }
    //��һ�֣��ݹ鷽��
    public void f1() {  
    	recursion(0, 0, 0, "");
    	System.out.println("max_value:"+max_value);
    	System.out.println("bag:"+bagpath);
    }
    
    //��k����Ʒѡ��ѡ�������һ����ʼѡ
    static int max_value = 0;
    static String bagpath = "";
    /**
     * 
     * @param k ��k����Ʒ
     * @param v ������ǰ��װ����
     * @param p ��ǰ��ֵ
     * @param s ��¼ѡ����Щ��Ʒ
     */
    public void recursion(int k, int v, int p, String s) {  
        if(k>=all_goods || v>=capacity){
        	if(max_value<p){
            	max_value = p;
            	bagpath = s;
            }
        	return;
        }
        //��װ��
        recursion(k+1,v, p, s);
        //װ��
        if(v+volume[k]<=capacity)//װ����
        	recursion(k+1,v+volume[k], p+price[k], s+bags[k]);
            
    }
    //�ڶ��֣���̬�滮���,����ö�ά����
    public void dynamicPlaying() {
    	//��price��volume����ǰ���0�����ڼ���
    	int [] price1  = new int[price.length+1];
    	System.arraycopy(price, 0, price1, 1, price.length);
    	int [] volume1  = new int[volume.length+1];
    	System.arraycopy(volume, 0, volume1, 1, volume.length);
    	//ʹ�ø���ά����洢����ֵ
    	//��������ʾ������1����������ʾ��Ʒ��
    	//�����ĳ��Ԫ��price_arr[i][j]��ʾ����Ʒ1��i��������1��j����ǰ������ֵ
    	int[][] best_price = new int[all_goods+1][capacity+1];
    	//״̬ת�Ʒ��̣���Ϊ���������(���ʻ�����Ʒi�Ƿ���뱳��)
    	//1����Ʒi�������ڵ�ǰ����v�������Ž���ǰi-1����Ʒ��
    	//2����Ʒi����С�ڵ�ǰ����v�����Ž��ǰ�����Ʒi��
    	//3����Ʒi����С�ڵ�ǰ����v�����Žⲻ������Ʒi��
    	//f(n,v)=f(n-1,v);(volume[n]>v)
    	//f(n,v)=f(n-1,v-c[n])+price[n];(volume[n]<v)
    	//f(n,v)=f(n-1,v-c[n])+price[n];(volume[n]<v)
    	//f(n,v)Ϊ����������
    	for(int v=1; v<=capacity; ++v){
    		for(int i=1; i<=all_goods; ++i){
    			//��Ʒi�������ڵ�ǰ������j��������
    			int temp1 = 0, temp2 = 0;
    			if(volume1[i]>v){
    				temp1 = best_price[i-1][v];
    			}else{
    				//����,������price1[i],����������ȥvolume1[i]
    				int put_temp2 = best_price[i-1][v-volume1[i]]+price1[i];
    				//��Ʒi�������ڵ�ǰ������j��Ҳ������
    				int noput_temp2 = best_price[i-1][v];
    				//ȡ���߽ϴ�
    				temp2 = put_temp2>noput_temp2?put_temp2:noput_temp2;
    			}
    			//ȡ���߽ϴ�
    			best_price[i][v] = temp1>temp2?temp1:temp2;
    		}
    	}
    	//���
    	for(int i=1; i<=all_goods; ++i){
    		for(int j=1; j<=capacity; ++j){
    			System.out.print(best_price[i][j]+" ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    	//��ⱳ�����,���a[i][v]>a[i-1][v]�����i����Ʒһ�������ˣ�v=v-volume1[i],i=i-1��ѭ���ж�
    	List<String> selectd_objects = new ArrayList<String>();
    	int v = capacity;
		for(int i=all_goods; i>0; --i){
			if(best_price[i][v]>best_price[i-1][v]){
				v=v-volume1[i];
				selectd_objects.add(""+bags[i-1]);
			}else if(best_price[i][v]>0 && i==1){
				selectd_objects.add(""+bags[i-1]);
			}
		}
		System.out.println(selectd_objects);
    }
    
}
