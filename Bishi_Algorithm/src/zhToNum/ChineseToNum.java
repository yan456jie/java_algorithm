package zhToNum;

import java.util.HashMap;
import java.util.Stack;
/**
 * �����ַ�ת���֣����ܻ�ܴ�
 * @author root
 *
 */
public class ChineseToNum {
	static String []unit = {"","ʮ","��","ǧ","��","��"};
	static String []num = {"��","һ","��","��","��","��","��","��","��","��"};
	static HashMap<String,Integer> numHash = new HashMap<String, Integer>();
	static HashMap<String,Integer> unitHash = new HashMap<String, Integer>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//String chi = "һǧ���ٰ�ʮ�����ھŰپ�ʮ�����ǧ�����ʮ";
		String chi = "һǧ�����";
		init();
		fun(chi,chi.length()-1);
	}
	public static void init(){
		
		for(int i=0; i<10; i++){
			numHash.put(num[i], i);
		}
		unitHash.put(unit[1], 1);//ʮ//��λ���漸����
		unitHash.put(unit[2], 2);//��
		unitHash.put(unit[3], 3);//ǧ
		unitHash.put(unit[4], 4);//��
		unitHash.put(unit[5], 8);//��
		
	}
	/**
	 * �൱��ʹ�õݹ��ˣ����ص�ֵ��û���õ�(ֻ����Ϊ�˳�����)�������һֱ�ݹ鵽�ַ�����ǰ�棬�������
	 * @param chi ��ת�������ַ���
	 * @param max_unit
	 * @param index ���ĸ�λ�ÿ�ʼת���Ӻ���ǰ
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
				//�ҵ���ǰ��λ�Ժ�����ǰ��һ����λ�Ƿ�С�ڴˣ��硰���ڡ�,���ǰ��û�е�λ��
				int temp = i-1;
				while(temp>0 && !unitHash.containsKey(chs[temp]+"")){
					--temp;
				}
				if(temp>0 && unitHash.get(chs[temp]+"")<u){//С��
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
	//һǧ���ٰ�ʮ�����ھŰپ�ʮ�����ǧ�����ʮ
	
}
