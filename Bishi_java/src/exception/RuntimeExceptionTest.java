package exception;

import test.TestJar;

/**
 * RuntimeException≤‚ ‘
 * 
 * ArithmeticEcxeption
 * MissingResourceException
 * ClassNotFoundException
 * NullPointerException
 * IllegalArgumentException
 * ArrayIndexOutOfBoundsException
 * UnkownTypeException
 * 
 * @author yanjie
 *
 */
public class RuntimeExceptionTest {
	
	//ArithmeticEcxeption
	public static void test1(){
		int a=1,b=0;
		int c=a/b;
	}
	//MissingResourceException
	public static void test2(){
	}
	//ClassNotFoundException
	public static void test3() throws ClassNotFoundException, InstantiationException, IllegalAccessException{
		Class cl = Class.forName("test.TestJar");
		TestJar t = (TestJar)cl.newInstance();
		t.test();
	}
	//NullPointerException
	public static void test4(){
		Node node = null;
		System.out.println(node.value);
	}
	//IllegalArgumentException
	public static void test5(char a){
		System.out.println(a);
	}
	//ArrayIndexOutOfBoundsException
	public static void test6(){
	}
	//UnkownTypeException
	public static void test7(){
	}
	
    public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
    	test3();
    }
    
    class Node{
    	public int value;
    	public Node left = null;
    	public Node right = null;
    }
    
}

