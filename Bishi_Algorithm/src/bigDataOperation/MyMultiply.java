package bigDataOperation;

public class MyMultiply {  
	  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        // System.out.println("Hello world");  
        //String str1 = "1076060999";  
        //String str2 = "90188905567";  
        String str1 = "23456789009877666555544444";
        String str2 = "346587436598437594375943875943875";
  
        int len1 = str1.length();  
        int len2 = str2.length();  
  
        char[] s1 = str1.toCharArray();  
        char[] s2 = str2.toCharArray();  
  
        // 高低位对调  
        covertdata(s1, len1);  
        covertdata(s2, len2);  
  
        System.out.println("乘数："+str1);  
        System.out.println("乘数："+str2);  
        multiply(s1, len1, s2, len2);  
  
    }  
  
    public static void covertdata(char data[], int len) {  
        //高低位对调  
        for (int i = 0; i < len / 2; i++) {  
            data[i] += data[len - 1 - i];  
            data[len - 1 - i] = (char) (data[i] - data[len - 1 - i]);  
            data[i] = (char) (data[i] - data[len - 1 - i]);  
        }  
    }  
  
    public static void multiply(char a[], int alen, char b[], int blen) {  
        // 两数乘积位数不会超过乘数位数和+ 3位  
        int csize = alen + blen + 3;  
        // 开辟乘积数组  
        int[] c = new int[csize];  
        // 乘积数组填充0  
        for (int ii = 0; ii < csize; ii++) {  
            c[ii] = 0;  
        }  
        // 对齐逐位相乘  
        for (int j = 0; j < blen; j++) {  
            for (int i = 0; i < alen; i++) {  
                c[i + j] +=  Integer.parseInt(String.valueOf(a[i]))* Integer.parseInt(String.valueOf(b[j]));  
            }  
        }  
        int m = 0;  
        // 进位处理  
        for (m = 0; m < csize; m++) {  
            int carry = c[m] / 10;  
            c[m] = c[m] % 10;  
            if (carry > 0)  
                c[m + 1] += carry;  
        }  
        // 找到最高位  
        for (m = csize - 1; m >= 0;) {  
            if (c[m] > 0)  
                break;  
            m--;  
        }  
        // 由最高位开始打印乘积  
        System.out.print("乘积：");  
        for (int n = 0; n <= m; n++) {  
            System.out.print(c[m - n]);  
        }  
        System.out.println("");  
    }
    
    public static void bigNumberSimpleMulti(String f, String s) {  
        System.out.print("乘法：\n" + f + "*" + s + "=");  
        // 获取首字符，判断是否是符号位  
        char signA = f.charAt(0);  
        char signB = s.charAt(0);  
        char sign = '+';  
        if (signA == '+' || signA == '-') {  
            sign = signA;  
            f = f.substring(1);  
        }  
        if (signB == '+' || signB == '-') {  
            if (sign == signB) {  
                sign = '+';
            } else {
                sign = '-';
            }
            s = s.substring(1);  
        }  
        // 将大数翻转并转换成字符数组  
        char[] a = new StringBuffer(f).reverse().toString().toCharArray();  
        char[] b = new StringBuffer(s).reverse().toString().toCharArray();  
        int lenA = a.length;  
        int lenB = b.length;  
        // 计算最终的最大长度  
        int len = lenA + lenB;  
        int[] result = new int[len];  
        // 计算结果集合  
        for (int i = 0; i < a.length; i++) {  
            for (int j = 0; j < b.length; j++) {  
                result[i + j] += (int) (a[i] - '0') * (int) (b[j] - '0');  
            }  
        }  
        // 处理结果集合，如果是大于10的就向前一位进位，本身进行除10取余  
        for (int i = 0; i < result.length; i++) {  
            if (result[i] > 10) {  
                result[i + 1] += result[i] / 10;  
                result[i] %= 10;  
            }  
        }
        StringBuffer sb = new StringBuffer();  
        // 该字段用于标识是否有前置0，如果是0就不需要打印或者存储下来  
        boolean flag = true;  
        for (int i = len - 1; i >= 0; i--) {  
            if (result[i] == 0 && flag) {  
                continue;  
            } else {  
                flag = false;  
            }  
            sb.append(result[i]);  
        }
        if (!sb.toString().equals("")) {
            if (sign == '-') {
                sb.insert(0, sign);
            }
        } else {
            sb.append(0);
        }
        // 返回最终结果
        System.out.println(sb.toString());
    }
}
