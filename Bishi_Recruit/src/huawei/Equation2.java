package huawei;

import java.util.ArrayList;
import java.util.List;
/**
 * 从符号的角度看
 * @author Administrator
 *
 */
public class Equation2 {
	
	private static List<List<Integer>> list = new ArrayList<>();
	
	private static List<List> op_list = new ArrayList<>();
	//如若元素不是有序的则需用到
	private static int [] ele = {1,2,3,4,5,6,7,8,9};
	
	private static char [] op = {'+','-',' '};

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getResult(5);
	}
	
	public static int getResult(int c) {
		int count = 0;
		int r = fun_op(7);
		System.out.println("r:"+r);
		
		for(int i=0; i<op_list.size(); i++){
			List l = op_list.get(i);
			int sum = 0;
			
			StringBuffer sizi = new StringBuffer();
			sizi.append(ele[0]);
			
			int temp = ele[0];
			for(int j=0; j<l.size(); j++){
//				System.out.print(l.get(j));
				char o = (char) l.get(j);
				if(o=='+'){
					sizi.append("+");
				}else if(o=='-'){
					sizi.append("-");
				}
				sizi.append(ele[j+1]);
			}
			if(i<10){
				System.out.println(sizi);
			}
			if(sum==5){
				count++;
			}
		}
		System.out.println(count);
		return count;
	}
	//所有符号有可能的组合
	public static int fun_op(int c){
		if(c==0){
			for(char o: op){
				List gen = new ArrayList();
				gen.add(o);
				op_list.add(gen);
			}
			return 3;
		}
		int r = 0;
		r = r + 3*fun_op(c-1);
		
		int k = op_list.size();
		for(int i=0; i<k; i++){
			List old = op_list.get(i);
			List gen1 = new ArrayList(old);
			gen1.add(op[1]);
			List gen2 = new ArrayList(old);
			gen2.add(op[2]);
			op_list.add(gen1);
			op_list.add(gen2);
			old.add(op[0]);
		}
		return r;
	}
	
}
