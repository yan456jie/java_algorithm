package _43_touzi;

import java.util.HashMap;
import java.util.Map;

/**
 * n�����ӿ��ܵĵ�����
 * @author root
 *
 */
public class Touzi2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun1(2);
	}
	
	public static void fun1(int n){
		//m�ε�����
		int[] data1 = new int[6*n+1];
		//m-1�ε�����
		int[] data2 = new int[6*n+1];
		//ÿ��Ͷһ������
		for(int i=1; i<=n; i++){
			//jΪ��ǰ���ӵ���
			//��data1���Ƶ�data2
			for(int j=0; j<6*n+1; j++){
				if(data1[j]!=0){
					data2[j]=data1[j];
				}else{
					data2[j]=0;
				}
			}
			for(int j=1; j<=6; j++){
				//kΪ�����±꣬��ֵΪ��ǰ���ֳ��ִ���
				for(int k=1; k<6*i+1; k++){
					int t = j+k;
					if(data2[k]!=0 && t<6*n+1){
						data1[t]++;
					}else if(data2[k]==0){
						data1[k]=1;
					}
				}
			}
			//data1��ȥdata2�д��ڵ�һ��
			for(int j=0; j<6*n+1; j++){
				if(data2[j]!=0){
					data1[j]-=1;
				}
			}
		}
		for(int i=0; i<6*n+1; i++){
			if(data1[i]!=0){
				System.out.println(i+"="+data1[i]+" ");
			}
		}
	}
}
