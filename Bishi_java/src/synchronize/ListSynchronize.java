package synchronize;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListSynchronize {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test();
	}
	public static void test(){
		List<String> list = Collections.synchronizedList(new ArrayList<String>());
		list.add("aaa");
		System.out.println(list.get(0));
	}
}
