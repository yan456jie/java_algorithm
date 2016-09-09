package __model__;
/**
 * 塞码编程模板
 * 输入为:第一行为接下来的数据行数
	2
	2
	3
 * @author yanjie
 *
 */
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Main m = new Main();
		while(sc.hasNext()) {
			int num = sc.nextInt();
			for(int i=0; i<num; i++) {
				System.out.println(m.fun(sc.nextInt()));
			}
		}
	
	}
	public int fun(int n) {
		return 0;
	}
}
