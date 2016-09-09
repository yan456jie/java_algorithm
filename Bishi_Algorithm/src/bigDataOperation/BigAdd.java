package bigDataOperation;

import java.math.BigInteger;
/**
 * 大數相乘
 * @author root
 *
 */
public class BigAdd {  
	  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
    	//String str1 = "23456789009877666555544444";
        //String str2 = "346587436598437594375943875943875";
    	String str1 = "19";
        String str2 = "1";
        
        String result = bigNumberAdd(str1, str2);
  
        System.out.println("加数："+str1);
        System.out.println("加数："+str2);
        System.out.println("结果："+result);
    }
    public static String bigNumberAdd(String f, String s) {  
        //翻转两个字符串，并转换成数组  
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();  
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();  
        int lenA = a.length;  
        int lenB = b.length;  
        //计算两个长字符串中的较长字符串的长度  
        int len = lenA > lenB ? lenA : lenB;  
        int[] result = new int[len + 1];  
        for (int i = 0; i < len + 1; i++) {  
            //如果当前的i超过了其中的一个，就用0代替，和另一个字符数组中的数字相加  
            int aint = i < lenA ? (a[i] - '0') : 0;  
            int bint = i < lenB ? (b[i] - '0') : 0;  
            result[i] = aint + bint;  
        }  
        //处理结果集合，如果大于10的就向前一位进位，本身进行除10取余  
        for (int i = 0; i < result.length; i++) {  
            if (result[i] >= 10) {  
                result[i + 1] += result[i] / 10;  
                result[i] %= 10;  
            }  
        }  
        StringBuffer sb = new StringBuffer();  
        //该字段用于标识是否有前置0，如果有就不要存储  
        boolean flag = true;  
        for (int i = len; i >= 0; i--) {  
            if (result[i] == 0 && flag) {  
                continue;  
            } else {  
                flag = false;  
            }  
            sb.append(result[i]);  
        }  
        return sb.toString();  
    }
    
    public static String bigNumberSub(String f, String s) {  
        System.out.print("减法:" + f + "-" + s + "=");  
        // 将字符串翻转并转换成字符数组  
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();  
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();  
        int lenA = a.length;
        int lenB = b.length;
        // 找到最大长度  
        int len = lenA > lenB ? lenA : lenB;  
        int[] result = new int[len];  
        // 表示结果的正负  
        char sign = '+';  
        // 判断最终结果的正负 
        if (lenA < lenB) {  
            sign = '-';  
        } else if (lenA == lenB) {  
            int i = lenA - 1;  
            while (i > 0 && a[i] == b[i]) {  
                i--;  
            }  
            if (a[i] < b[i]) {  
                sign = '-';  
            }  
        }  
        // 计算结果集，如果最终结果为正，那么就a-b否则的话就b-a
        for (int i = 0; i < len; i++) {  
            int aint = i < lenA ? (a[i] - '0') : 0;  
            int bint = i < lenB ? (b[i] - '0') : 0;  
            if (sign == '+') {  
                result[i] = aint - bint;  
            } else {  
                result[i] = bint - aint;  
            }  
        }  
        // 如果结果集合中的某一位小于零，那么就向前一位借一，然后将本位加上10。其实就相当于借位做减法  
        for (int i = 0; i < result.length - 1; i++) {  
            if (result[i] < 0) {  
                result[i + 1] -= 1;  
                result[i] += 10;  
            }  
        }  
  
        StringBuffer sb = new StringBuffer();  
        // 如果最终结果为负值，就将负号放在最前面，正号则不需要  
        if (sign == '-') {  
            sb.append('-');  
        }  
        // 判断是否有前置0  
        boolean flag = true;  
        for (int i = len - 1; i >= 0; i--) {  
            if (result[i] == 0 && flag) {  
                continue;  
            } else {  
                flag = false;  
            }  
            sb.append(result[i]);  
        }  
        // 如果最终结果集合中没有值，就说明是两值相等，最终返回0  
        if (sb.toString().equals("")) {  
            sb.append("0");  
        }  
        // 返回值  
        System.out.println(sb.toString());  
        return sb.toString();  
    }
}
