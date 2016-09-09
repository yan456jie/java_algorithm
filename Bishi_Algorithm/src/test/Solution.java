package test;

public class Solution {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "hello world";
		char ss[] = {'h','e','l','l','o',' ','w','o','r','l','d'};
		System.out.println(replaceBlank(s.toCharArray(), s.length()));
	}
    /**
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public static int replaceBlank(char[] string, int length) {
        // Write your code here
        //统空格个数
        int c=0;
        for(int i=0; i<length; i++){
            if(string[i]==' '){
                ++c;
            }
        }
        System.out.println(c);
        int p=length-1+c*2;
        for(int i=length-1; i>=0 && p>=0; i--){
            if(string[i]==' '){
                string[p--] = '0';
                string[p--] = '2';
                string[p--] = '%';
            }else{
                string[p--] = string[i];
            }
        }
        int l = length+2*c;
        return l;
    }
}