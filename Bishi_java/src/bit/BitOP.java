package bit;

public class BitOP {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a=-3;
		System.out.println(a>>2);
		//结果为-1，-3在计算机中用补码表示为（符号位为1其余位取反加1）
		//11111111 11111111 11111111 11111101
		//求原码也是符号位不变，其余位取反加1
	}

}
