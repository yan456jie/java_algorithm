package xiecheng;

import java.util.Scanner;

public class BinarySearch {
	
    public static int search(int[] data, int des) {
    	if(data==null){
    		return 0;
    	}
        int low = 0,mid=0,high = data.length - 1;  
        while (low <= high) {
            mid = (low + high) / 2;  
            if (data[mid] < des)
                low = mid + 1;
            else if (data[mid] > des)  
            	high = mid - 1;  
            else{
            	while((mid-1)>=0 && data[mid-1]==des){
            		--mid;
            	}
                return mid;
            }
        }
        if(des>data[high]){
        	mid= high+1;
        }
        return -1-mid;
    }  
  
    public static void main(String[] args) {  
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
			int des = sc.nextInt();
			int n = sc.nextInt();
			int [] data = new int[n];
			for(int i=0; i<n; i++) {
				data[i] = sc.nextInt();
			}
	        int m = search(data, des);
	        System.out.println(m);
		}
    }  
}
/*
5
4
1 2 3 4
 */
 

