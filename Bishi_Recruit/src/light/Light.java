package light;
/**
 * 一百个灯泡排成一排，第一轮将所有灯泡打开；
 * 第二轮。。第三轮，隔两个，将熄灭的点亮，点亮的熄灭。
 * 100轮以后哪些灯泡是亮的
 * @author root
 */
public class Light {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fun(3);
	}
	public static void print(int[] light) {
		for(int i=1; i<light.length; i++){
			System.out.print(light[i]);
		}
	}
	
	public static void fun(int n) {
		int[] light = new int[101];
		for(int i=1; i<=n; i++){
			int j=1;
			while(j<=100){
				if(light[j]==0)
					light[j] = 1;
				else
					light[j] = 0;
				j+=i;
			}
		}
		print(light);
	}
}
