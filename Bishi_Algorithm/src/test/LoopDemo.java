package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LoopDemo {  
    public static void main(String[] args) {  
        zengzs:
        for (int i = 0; i < 2; i++) {  
        	System.out.println("���е�һ��ѭ��" + i);  
            for (int j = 0; j < 2; j++) {  
                // label: for (int j = 0; j <2; i++) {  
                System.out.println("���еڶ���ѭ��" + j);  
                for (int k = 0; k < 2; k++) {  
                    // break label;
                    if (k == 1) {
                        System.out.println("��������ѭ��");  
                        break zengzs;
                    }
                    System.out.println("���е�����ѭ��" + k);  
                    System.out.println("**************************");  
                }  
            }  
        }  
    }  
}
