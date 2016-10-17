package common;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		test4();
	}

	public static void test1(){
		//float f=3.4;//3.4是双精度数
		float f =(float)3.4;
		//short s1 = 1; s1 = s1 + 1;//
		short s1 = 1; s1 += 1;
	}
	public static void test2() {
        Integer a = new Integer(3);
        Integer b = 3;                  // 将3自动装箱成Integer类型
        int c = 3;
        System.out.println(a == b);     // false 两个引用没有引用同一对象
        System.out.println(a == c);     // true a自动拆箱成int类型再和c比较
    }
	public static void test3() {
		Integer f1 = 100, f2 = 100, f3 = 150, f4 = 150;

        System.out.println(f1 == f2);
        System.out.println(f3 == f4);
	}
	public static void test4() {
		OK:
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				if(i==1){
					break OK;
				}
				System.out.println(i+":"+j);
			}
		}
	}
}
