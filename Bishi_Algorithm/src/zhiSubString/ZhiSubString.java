package zhiSubString;

import java.io.UnsupportedEncodingException;

/**
 * 截取的要点： 1.首先将字符串转换成字节数组，再将字节数组的每个元素拿出来，判断有无负数（一个汉字为两个负数），即有汉字
 * 2.len：这个len是将字符串转换成字节数组的要截取的长度，
 * 如"我ABC你"的字节数组长度为7（-50,-46,65,66,67,-60,-29），而截取的是6（-50,-46,65,66,67,-60），
 * 3.对截取的字节数组（-50,-46,65,66,67,-60）统计负数的个数
 * 4.String里的方法substring方法将双字节的汉字当成一个字节的字符（UCS2字符）处理了，而我们的字节数组一个函数
 * 就是两个字节，所以要想用substring方法，还需要将负数的个数count除以二才可以
 * 
 * @author Administrator
 *
 */
public class ZhiSubString {
	public static String subString(String str, int len) {
		if (str == null && "".equals(str)) {
			return null;
		}
		// 将字符串中的char数组转换成指定编码方式的byte数组的函数
		byte[] strBytes = null;
		try {
			strBytes = str.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// 得到字符串的长度，判断截取字符串的长度是否在判断的范围内，否则返回原串
		int strLen = strBytes.length;
		if (len >= strLen || len < 1) {
			return str;
		}
		System.out.println("strBytes.length=" + strBytes.length);
		System.out.println("len=" + len);
		int count = 0;
		for (int i = 0; i < len; i++) {
			// 将每个字节数组转换为整型数，以为后面根据值的正负来判断是否为汉字
			int value = strBytes[i];
			System.out.print(value + ","); // 我ABC你 -50,-46,65,66,67,-60,-29
			// 对于第一种情况：
			// 注，一个函数转换成整型数就为两个负整数,上面的”我ABC你“，
			// 转换成整型数就为-50,-46,65,66,67,-60,-29，但是len=6，所以截取下来的就是-50,-46,65,66,67,-60,count就为3
			// 如果是汉字(负)，则统计截取字符串中的汉字所占字节数
			if (value < 0) {
				count++;
			}
			System.out.println("zh count=" + count);
		}
		// 依据判断给定的字符串是否含有汉字，利用String类的substring()方法来截取不同的长度

		// 根据所统计的字节数，判断截取到字符是否为半个汉字，奇数为半个汉字
		if (count % 2 != 0) {
			// 如果在截取长度为1时，则将该汉字取出，
			// 其他情况则不截取这里的截取长度则按字符长度截取（截取字节长度数-截取汉字字节数/2-截取到的半个汉字的字节数）
			len = (len == 1) ? len : len - count / 2 - 1; // len=6-3/2-1=4 我ABC
			// System.out.println("处理后的len="+len);

		} else {
			// 截取字符长度为字节长度-汉字所占字节长度/2（汉字占两个字节）
			len = len - (count / 2);
		}
		return str.substring(0, len);

	}

	public static void main(String[] args) {

		// String inStrTest = "我ABC你EFG";
		// String strTest = inStrTest.substring(0, 2);
		// System.out.println(strTest);

		System.out.println("--------- 情况一-----------");
		// 情况一：
		String inStr = "我ABC你";
		String str = subString(inStr, 6);
		System.out.println(str); // 我ABC www.2cto.com

		System.out.println("---------- 情况二----------");
		// 情况二：首字符为汉字
		inStr = "我ABC汉DEF";
		str = subString(inStr, 1);
		System.out.println(str); // 我

		System.out.println("-----------情况三---------");

		// 情况三：中间有连续汉字
		inStr = "我AB爱孩子CDEF";
		str = subString(inStr, 9);
		System.out.println(str); // 我AB爱孩

		System.out.println("-----------情况四---------");
		// 情况四：没有汉字
		inStr = "ABCDEF";
		str = subString(inStr, 4);
		System.out.println(str); // ABCD
	}

}
