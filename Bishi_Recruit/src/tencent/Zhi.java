package tencent;

import java.util.Arrays;
import java.util.Scanner;

public class Zhi {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()) {
			int d = sc.nextInt();
			int count = CountPrime(d);
			System.out.println(count);
		}
	}
	public static int CountPrime(int a){
		if(a<2 || a>1000){
			return 0;
		}
		int count = 0;
		for(int i=2; i<=a/2; i++){
			if(isPrime(i) && isPrime(a-i)){
				++count;
			}
		}
		return count;
	}
	//�ж��Ƿ�������
    public static boolean isPrime(int a) {  
        boolean flag = true;  
        if (a < 2) {// ������С��2
            return false;  
        } else {
            for (int i = 2; i <= Math.sqrt(a); i++) {  
                if (a % i == 0) {// ���ܱ���������˵����������������false  
                    flag = false;  
                    break;// ����ѭ��  
                }
            }
        }
        return flag;  
    }
}
