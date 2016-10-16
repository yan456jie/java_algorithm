package jinritoutiao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class DicOrder {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			dictOrder(n, m);
		}
	}
	public static void dictOrder(int n, int m){
		List<String> list = new ArrayList<String>();
		for(int i=1; i<=n; i++){
			list.add(i+"");
		}
		Collections.sort(list);
		System.out.println(list.get(m-1));
	}
}
