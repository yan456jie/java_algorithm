package findMaxPalindrome;
/** 
 * ���ַ���������ӻ��Ĵ������õݹ��˼�룺start��end�ֱ�ָ��ͷ��β��
 * ���ֵ��ȣ��򳤶�+2�����ߵȼ�����start��end-1��start+1��end��������Ӵ���
 * 
 */  
public class Huiwen {
	public static void main(String[] args) {  
        // TODO Auto-generated method stub  
        String str = "edaabcbaded";  
        getStrLen(str.toCharArray(), 0, str.length()-1);  
        System.out.println(count);
        System.out.println(tmp_string);
    }
	
	public static int count=0; //��������ӻ��Ĵ�����
	public static String tmp_string="";//���������Ĵ���ǰ�벿��
	//������ӻ��Ĵ�����
	public static int getStrLen(char[] chars,int start,int end){
	    if(start==end){
	        count++;
	        tmp_string+=chars[start];
	    }
	    if(start<end){
	        if(chars[start]==chars[end]){
	            count +=2;
	            tmp_string+=chars[start];
	            getStrLen(chars,start+1,end-1);
	        }else{
	            int tempCount=count;
	            String tempString=tmp_string;
	            int a=getStrLen(chars,start,end-1);//�ú�����ı�tmp_string��ֵ
	            String tempsString1=tmp_string;//��ʱ���澭�����仯����Ӵ�

	            count=tempCount;      //�˻ص��ϵݹ����֮ǰ��״̬
	            tmp_string=tempString;//�˻ص��ϵݹ����֮ǰ��״̬
	            int b=getStrLen(chars,start+1,end);
	            String tempsString2=tmp_string;//��ʱ���澭�����仯����Ӵ�
	            if(a>b){
	                count=a;
	                tmp_string=tempsString1;
	            }
	            else {
	                count=b;
	                tmp_string=tempsString2;
	            }
	        }
	    }
	    return count;
	}
}
