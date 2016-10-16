package xinfeng;

import java.util.Scanner;
/**
 * 装糖果(背包问题)
 * @author root
 *
 */
public class TangGuo {  
/*
3 2
1 2
2 7
1 3
*/
/*
5 10
4 6
5 4
6 5
2 3
2 6
*/
    public static void main(String[] args) {  
        // TODO Auto-generated method stub  
    	getBiggestMagic();
    }  
  
    public static void getBiggestMagic(){
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();//糖果数量
			int capacity = in.nextInt();//卡车容量
			int [] candy  = new int[n];//存放序号
		    int [] checked_candy  = new int[n];
		    int [] volume = new int[n];//糖的大小
		    int [] magic  = new int[n];//糖的魔幻指数
		    
			for (int i = 0; i <n; i++) {
				int v = in.nextInt();
				int m = in.nextInt();
				candy[i] = i+1;
				volume[i] =v;
				magic[i] =m;
			}
			f(n-1, capacity,candy,checked_candy,volume,magic);
			print_candys( checked_candy, candy);
			//print_value(candy, checked_candy, volume, magic);
		}
	}
    
    public static int f(int i, int j,int [] candy,int [] checked_candy,int [] volume,int [] magic) {  
        if(i<0)  
            return 0;  
        if(j<=0)  
            return 0;  
        //不装入  
        int a = f(i-1,j,candy,checked_candy,volume,magic);  
        //装入  
        int b;  
        if(j-volume[i]>=0)//装得下  
            b = f(i-1,j-volume[i],candy,checked_candy,volume,magic) + magic[i];  
        else//装不下 
            b = 0;
        //记录选择了哪些糖编号
        if(a>b)  
        	checked_candy[i] = 0;  
        else  
        	checked_candy[i] = 1;  
        return a>b?a:b;
    }
    public static void print_value(int [] candy,int [] checked_candy,int [] volume,int [] magic){  
        for(int i=0; i<5; i++){
            for(int j=1; j<11; j++){
                System.out.print(f(i,j,candy,checked_candy,volume,magic) + "  ");  
            }  
            System.out.println();
        }  
    }
    public static void print_candys(int [] checked_candy,int [] candy){  
        for(int i=0; i<checked_candy.length; i++){            
            if(checked_candy[i]==1){
                System.out.print(candy[i]+" ");
            }
        }
    }
}
