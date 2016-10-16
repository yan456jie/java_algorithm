package baidu;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Yuangong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		if(sc.hasNext()) {
			int line_num = sc.nextInt();
			while(line_num>0){
				int n = sc.nextInt();
				//long num[] = new long[n];
				//long card[] = new long[n-1];
				HashSet<Long> allEm = new HashSet<Long>();
				HashSet<Long> signd = new HashSet<Long>();
				int i=0;
				long temp = 0;
				for(i=0;i<n;i++){
					temp=sc.nextLong();
					allEm.add(temp);
				}
				for(i=0;i<n-1;i++){
					temp=sc.nextLong();
					signd.add(temp);
				}
				sign(allEm, signd);
				--line_num;
			}
			
		}
	}

	public static void sign(HashSet<Long> allEm, HashSet<Long> signd){
		Iterator<Long> iterator=allEm.iterator();
		while(iterator.hasNext()){
			Long l = iterator.next();
			if(!signd.contains(l)){
				System.out.println(l);
			}
		}
	}
}
