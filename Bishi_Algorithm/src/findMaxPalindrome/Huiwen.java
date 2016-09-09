package findMaxPalindrome;
/** 
 * 求字符串的最大子回文串，采用递归的思想：start、end分别指向头和尾，
 * 如果值相等，则长度+2，否者等价于在start与end-1、start+1与end间找最大子串。
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
	
	public static int count=0; //保存最大子回文串长度
	public static String tmp_string="";//保存最大回文串的前半部分
	//求最大子回文串长度
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
	            int a=getStrLen(chars,start,end-1);//该函数会改变tmp_string的值
	            String tempsString1=tmp_string;//临时保存经上述变化后的子串

	            count=tempCount;      //退回到上递归调用之前的状态
	            tmp_string=tempString;//退回到上递归调用之前的状态
	            int b=getStrLen(chars,start+1,end);
	            String tempsString2=tmp_string;//临时保存经上述变化后的子串
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
