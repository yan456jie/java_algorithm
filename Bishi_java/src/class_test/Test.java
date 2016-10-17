package class_test;
/**
 * 静态函数、父类、子类执行顺序
 * @author root
 *
 */
public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("7");
		B b = new B();
	}

}

class A{
	public static int i=generate();
	public A(){
		
		System.out.println("A");
	}
	public static int generate(){
		i=5;
		System.out.println(i);
		return i;
	}
}
class B extends A{
	public static int j=generate2();
	//j=;
	public B(){
		System.out.println("B");
	}
	public static int generate2(){
		j=6;
		System.out.println(j);
		return j;
	}
	public static int print(){
		System.out.println(j);
		return j;
	}
}