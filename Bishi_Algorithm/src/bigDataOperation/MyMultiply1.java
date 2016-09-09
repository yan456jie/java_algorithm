package bigDataOperation;

import java.math.BigInteger;
/**
 * 大數相乘
 * @author root
 *
 */
public class MyMultiply1 {  
	  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
    	String str1 = "23456789009877666555544444";
        String str2 = "346587436598437594375943875943875";
        
        String result = multiply(str1, str2);
        String result1 = multiply1(str1, str2);
  
        System.out.println("乘数："+str1);
        System.out.println("乘数："+str2);
        System.out.println("结果："+result);
        System.out.println("结果："+result1);
    }
    
    private static String multiply1(String str1, String str2){
    	BigInteger bigInteger1=new BigInteger(str1);
    	BigInteger bigInteger2=new BigInteger(str2);
    	//multiplay
    	bigInteger1=bigInteger1.multiply(bigInteger2);
    	return bigInteger1.toString();
    }
  
    public static String multiply(String str1, String str2) {  
        //判断符号
    	char flag1;
    	char flag2;
    	char flag;
    	if(str1.charAt(0)=='-'){
    		flag1 = '-';
    		str1 = str1.substring(1);
    	}else if(str1.charAt(0)=='+'){
    		flag1 = '+';
    		str1 = str1.substring(1);
    	}else{
    		flag1 = '+';
    	}
    	if(str2.charAt(0)=='-'){
    		flag2 = '-';
    		str2 = str2.substring(1);
    	}else if(str2.charAt(0)=='+'){
    		flag2 = '+';
    		str2 = str2.substring(1);
    	}else{
    		flag2 = '+';
    	}
    	if(flag1==flag2){
    		flag = '+';
    	}else{
    		flag = '-';
    	}
    	// 两数乘积位数不会超过乘数位数和+ 3位 
    	char [] s1 = new StringBuffer(str1).reverse().toString().toCharArray();
    	char [] s2 = new StringBuffer(str2).reverse().toString().toCharArray();
    	
    	int [] result = new int[str1.length()+str2.length()+3];
    	//逐位相乘
    	for(int i=0; i<s1.length; i++){
    		for(int j=0; j<s2.length; j++){
    			result[i+j]+= (s1[i]-'0')*(s2[j]-'0');
    		}
    	}
    	//进位
    	for(int i=0; i<result.length-1; i++){
    		result[i+1]+=result[i]/10;
    		result[i] = result[i]%10;
    	}
    	//输出,数据是倒的，需要去除0
    	boolean start = false;
    	StringBuilder sb = new StringBuilder();
    	sb.append(flag);
    	for(int i=result.length-1; i>=0; i--){
    		if(result[i]!=0){
    			start=true;
    		}
    		if(start){
    			sb.append(result[i]);
    		}
    	}
    	return sb.toString();
    }
}
