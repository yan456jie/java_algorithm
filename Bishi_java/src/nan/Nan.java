package nan;
/**
 * NaN������޷��Ƚϴ�С
 * @author root
 *
 */
public class Nan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 // ����������ͨ����
        int[] a = new int[2];
        int[] b = new int[2];
        // �������Ԫ�ظ�ֵ
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
            b[i] = i + 1;
        }
        swapIntArray(a, b);
        System.out.println('\n' + "�����������齻����a[0] = " + a[0] + ", a[1] = " + a[1]);
        System.out.println("�����������齻����b[0] = " + b[0] + ", b[1] = " + b[1]);
	}
	// ����������������
    public static void swapIntArray(int[] x, int[] y) {
        int[] tmp = x;
        x = y;
        y = tmp;
    }
}
abstract class MyClass{
	public int constInt = 5;
	public void method() {	
	}
	public int method(int a) {
		return 0;
	}
	public abstract void anatohr();
}
