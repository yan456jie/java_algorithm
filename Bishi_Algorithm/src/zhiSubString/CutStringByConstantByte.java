package zhiSubString;

import java.io.IOException;  

public class CutStringByConstantByte {  
  
    public static void main(String[] args) throws IOException {  
        // TODO Auto-generated method stub  
        String str = "我不道你xia我gsm是hai你shi那个地方那条街";  
        System.out.println(CutStringMethod(str.getBytes("GBK"),12));   
    }  
  
    public static String CutStringMethod(byte[] bs,int count) {  
        // TODO Auto-generated method stub  
        int countNum = 0;  
        int cutNum = 0;  
        //汉字的2个字节的ASCII码都大于128,统计要截取的字节中汉字字节的数目  
        for (int i = 0; i < count;i++) {  
            if(bs[i]<0){  //判断是否为汉字  
                countNum++;  
            }  
        }  
        /*一个汉字是由两个字节组成的*/  
        if(countNum%2==0){ //如果汉字的字节数为偶数时，则截取的字节数不变  
            cutNum = count;  
        }else{   //如果汉字的字节数为奇数时，则截取的字节数要少一个  
            cutNum = count-1;  
        }  
          
        return new String(bs, 0, cutNum);  
          
    }  
  
}  
