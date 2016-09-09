package editDistance;
/**
 * �༭����(ɾ������ӣ��滻 �õ�����ַ����������)�㷨
 * s = "eeba", t="abac"
 * ʹ��һ����ά�����¼����༭����(sΪ����tΪ����)��
	0 1 2 3 4 
	1 1 2 3 4 
	2 2 2 3 4 
	3 3 2 3 4 
	4 3 3 2 3 
	�ڶ���Ϊ��tȡһ���ַ�a��ʱ��s����Ϊ  ""��"e"��"ee"��"eeb"��"eeba"����ı༭����
	���������
	�Զ�̬�滮�Ƕ���������edit(i,j)����������е�Ԫ�أ�������Ϊi����sȡǰi���ַ���j����tȡǰ���ַ�
	��edit(2,2)����s="ee"��t="ab"�ı༭���룬�ھ�����Ϊ2�������л���һ��0�У�
	edit(i,j)=minist(edit(i,j-1)+1, edit(i-1,j)+1, edit(i-1,j-1)+cost)
	edit(2,2)=minist(edit(2,1)+1, edit(1,2)+1, edit(1,1)+cost)
	��ȡ("ee","a")("e","ab")("ee","ab")�����༭�����е���Сֵ
	s.charAt(i-1)==t.charAt(j-1)ʱ��cost=1
 * @author yanjie
 *
 */
public class EditDistance {
	
	public static void main(String[] args) {
		String s = "eeba", t="abac";
		int d = getEditDistance(s, t);
		System.out.println(d);
	}
	//����������Сֵ
    private static int Minimum(int a, int b, int c) {
    	int im =  a<b ? a : b;
    	return im<c ? im : c;
    }
   
    public static int getEditDistance(String s, String t) {
        int d[][]; // matrix
        int n; // length of s
        int m; // length of t
        int i; // iterates through s
        int j; // iterates through t
        char s_i; // ith character of s
        char t_j; // jth character of t
        int cost; // cost
        
        // Step 1
        n = s.length();
        m = t.length();
        if (n == 0) {
            return m;
        }
        if (m == 0) {
            return n;
        }
        d = new int[n + 1][m + 1];
        
        // Step 2
        for (i = 0; i <= n; i++) {
            d[i][0] = i;
        }
        for (j = 0; j <= m; j++) {
            d[0][j] = j;
        }
        
        // Step 3
        for (i = 1; i <= n; i++) {
            s_i = s.charAt(i - 1);
            // Step 4
            for (j = 1; j <= m; j++) {
                t_j = t.charAt(j - 1);
                // Step 5
                cost = (s_i == t_j) ? 0 : 1;
                // Step 6
                d[i][j] = Minimum(d[i - 1][j] + 1, d[i][j - 1] + 1,
                        d[i - 1][j - 1] + cost);
            }
        }
        // Step 7
        print(d, m, n);
        return d[n][m];
    }
    public static void print(int d[][],int m, int n){
    	for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
            	System.out.print(d[i][j]+" ");
            }
            System.out.println();
    	}
    }
}
