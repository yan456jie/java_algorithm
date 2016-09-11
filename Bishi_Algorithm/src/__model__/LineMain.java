package __model__;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class LineMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		while(sc.hasNext()) {
			String[] s_arr = sc.nextLine().split(",");
			int[] i_arr = new int[s_arr.length];
			for(int i=0; i<s_arr.length; i++) {
				i_arr[i] = Integer.parseInt(s_arr[i]);
			}
			System.out.println(Arrays.toString(i_arr));
		}
	}

}
