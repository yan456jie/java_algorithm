package zhToNum;

import java.util.HashMap;
import java.util.Stack;
/**
 * 中文字符转数字（可能会很大）
 * @author root
 *
 */
public class ChineseToNum {
	static String []unit = {"","十","百","千","万","亿"};
	static String []num = {"零","一","二","三","四","五","六","七","八","九"};
	static HashMap<String,Integer> numHash = new HashMap<String, Integer>();
	static HashMap<String,Integer> unitHash = new HashMap<String, Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String chi = "一千三百八十二万亿九百九十九万八千五百六十";
		String chi = "一千零二万";
		init();
		fun(chi,chi.length()-1);
	}
	public static void init(){
		
		for(int i=0; i<10; i++){
			numHash.put(num[i], i);
		}
		unitHash.put(unit[1], 1);//十//这位后面几个零
		unitHash.put(unit[2], 2);//百
		unitHash.put(unit[3], 3);//千
		unitHash.put(unit[4], 4);//万
		unitHash.put(unit[5], 8);//亿
		
	}
	/**
	 * 相当于使用递归了，返回的值是没有用的(只能作为退出条件)，程序会一直递归到字符串最前面，将其输出
	 * @param chi 待转的中文字符串
	 * @param max_unit
	 * @param index 从哪个位置开始转，从后往前
	 * @return
	 */
	public static int fun(String chi, int index){
		Stack<String> stack = new Stack<String>();
		char [] chs = chi.toCharArray();
		int i=index;
		for(; i>=0; i--){
			String c = chs[i]+"";
			if(unitHash.containsKey(c)){
				int u = unitHash.get(c);
				//找到当前单位以后，找其前面一个单位是否小于此，如“万亿”,如果前面没有单位了
				int temp = i-1;
				while(temp>0 && !unitHash.containsKey(chs[temp]+"")){
					--temp;
				}
				if(temp>0 && unitHash.get(chs[temp]+"")<u){//小于
					i = fun(chi,i-1);
					//System.out.println("i:"+i);
				}
				while(stack.size()<u){
					stack.push("0");
				}
			}
			if(numHash.containsKey(c)){
				int u = numHash.get(c);
				stack.push(u+"");
			}
		}
		while(stack.size()>0){
			System.out.print(stack.pop());
		}
		return i;
	}
	//一千三百八十二万亿九百九十九万八千五百六十
	
}
