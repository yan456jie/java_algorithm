package zhiSubString;

import java.io.IOException;  

public class CutStringByConstantByte {  
  
    public static void main(String[] args) throws IOException {  
        // TODO Auto-generated method stub  
        String str = "�Ҳ�����xia��gsm��hai��shi�Ǹ��ط�������";  
        System.out.println(CutStringMethod(str.getBytes("GBK"),12));   
    }  
  
    public static String CutStringMethod(byte[] bs,int count) {  
        // TODO Auto-generated method stub  
        int countNum = 0;  
        int cutNum = 0;  
        //���ֵ�2���ֽڵ�ASCII�붼����128,ͳ��Ҫ��ȡ���ֽ��к����ֽڵ���Ŀ  
        for (int i = 0; i < count;i++) {  
            if(bs[i]<0){  //�ж��Ƿ�Ϊ����  
                countNum++;  
            }  
        }  
        /*һ���������������ֽ���ɵ�*/  
        if(countNum%2==0){ //������ֵ��ֽ���Ϊż��ʱ�����ȡ���ֽ�������  
            cutNum = count;  
        }else{   //������ֵ��ֽ���Ϊ����ʱ�����ȡ���ֽ���Ҫ��һ��  
            cutNum = count-1;  
        }  
          
        return new String(bs, 0, cutNum);  
          
    }  
  
}  
