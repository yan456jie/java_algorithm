package bag;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 背包问题,每个物品有价值
 * @author root
 *
 */
public class Bag {  
	  
    private char [] bags;
    private int all_goods = 3;//有多少个物品
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
        all_goods = 3;//有多少个物品
        volume  = new int[]{1,2,1};
        price  = new int[]{2,7,3};
        capacity  = 2;
    }
    
    public void init2(){
    	bags  = new char[]{'e','d','c','b','a'};
        all_goods = 5;//有多少个物品
        volume  = new int[]{4,5,6,2,2};
        price  = new int[]{6,4,5,3,6};
        capacity  = 10;
    }
    //第一种，递归方法
    public void f1() {  
    	recursion(0, 0, 0, "");
    	System.out.println("max_value:"+max_value);
    	System.out.println("bag:"+bagpath);
    }
    
    //第k个物品选不选，从最后一个开始选
    static int max_value = 0;
    static String bagpath = "";
    /**
     * 
     * @param k 第k个物品
     * @param v 背包当前已装容量
     * @param p 当前价值
     * @param s 记录选了哪些物品
     */
    public void recursion(int k, int v, int p, String s) {  
        if(k>=all_goods || v>=capacity){
        	if(max_value<p){
            	max_value = p;
            	bagpath = s;
            }
        	return;
        }
        //不装入
        recursion(k+1,v, p, s);
        //装入
        if(v+volume[k]<=capacity)//装得下
        	recursion(k+1,v+volume[k], p+price[k], s+bags[k]);
            
    }
    //第二种，动态规划求解,可求得二维数组
    public void dynamicPlaying() {
    	//在price和volume数组前面加0，便于计算
    	int [] price1  = new int[price.length+1];
    	System.arraycopy(price, 0, price1, 1, price.length);
    	int [] volume1  = new int[volume.length+1];
    	System.arraycopy(volume, 0, volume1, 1, volume.length);
    	//使用个二维数组存储最大价值
    	//数组横向表示容量从1到最大，纵向表示物品，
    	//数组的某个元素price_arr[i][j]表示从物品1到i，从容量1到j，当前的最大价值
    	int[][] best_price = new int[all_goods+1][capacity+1];
    	//状态转移方程，分为三种情况：(本质还是物品i是否放入背包)
    	//1、物品i容量大于当前容量v，则最优解在前i-1个物品中
    	//2、物品i容量小于当前容量v，最优解是包含物品i的
    	//3、物品i容量小于当前容量v，最优解不包含物品i的
    	//f(n,v)=f(n-1,v);(volume[n]>v)
    	//f(n,v)=f(n-1,v-c[n])+price[n];(volume[n]<v)
    	//f(n,v)=f(n-1,v-c[n])+price[n];(volume[n]<v)
    	//f(n,v)为三者中最大的
    	for(int v=1; v<=capacity; ++v){
    		for(int i=1; i<=all_goods; ++i){
    			//物品i容量大于当前总容量j，不放入
    			int temp1 = 0, temp2 = 0;
    			if(volume1[i]>v){
    				temp1 = best_price[i-1][v];
    			}else{
    				//放入,即加上price1[i],并且容量减去volume1[i]
    				int put_temp2 = best_price[i-1][v-volume1[i]]+price1[i];
    				//物品i容量大于当前总容量j，也不放入
    				int noput_temp2 = best_price[i-1][v];
    				//取两者较大
    				temp2 = put_temp2>noput_temp2?put_temp2:noput_temp2;
    			}
    			//取两者较大
    			best_price[i][v] = temp1>temp2?temp1:temp2;
    		}
    	}
    	//输出
    	for(int i=1; i<=all_goods; ++i){
    		for(int j=1; j<=capacity; ++j){
    			System.out.print(best_price[i][j]+" ");
    		}
    		System.out.println();
    	}
    	System.out.println();
    	//求解背包组成,如果a[i][v]>a[i-1][v]，则第i个物品一定放入了，v=v-volume1[i],i=i-1，循环判断
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
