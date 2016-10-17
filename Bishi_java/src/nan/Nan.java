package nan;
/**
 * NaN情况下无法比较大小
 * @author root
 *
 */
public class Nan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		 // 建立两个普通数组
        int[] a = new int[2];
        int[] b = new int[2];
        // 给数组个元素赋值
        for (int i = 0; i < a.length; i++) {
            a[i] = i;
            b[i] = i + 1;
        }
        swapIntArray(a, b);
        System.out.println('\n' + "基本类型数组交换后：a[0] = " + a[0] + ", a[1] = " + a[1]);
        System.out.println("基本类型数组交换后：b[0] = " + b[0] + ", b[1] = " + b[1]);
	}
	// 交换基本类型数组
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
