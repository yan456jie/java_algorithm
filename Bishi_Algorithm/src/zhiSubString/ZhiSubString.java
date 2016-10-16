package zhiSubString;

import java.io.UnsupportedEncodingException;

/**
 * ��ȡ��Ҫ�㣺 1.���Ƚ��ַ���ת�����ֽ����飬�ٽ��ֽ������ÿ��Ԫ���ó������ж����޸�����һ������Ϊ���������������к���
 * 2.len�����len�ǽ��ַ���ת�����ֽ������Ҫ��ȡ�ĳ��ȣ�
 * ��"��ABC��"���ֽ����鳤��Ϊ7��-50,-46,65,66,67,-60,-29��������ȡ����6��-50,-46,65,66,67,-60����
 * 3.�Խ�ȡ���ֽ����飨-50,-46,65,66,67,-60��ͳ�Ƹ����ĸ���
 * 4.String��ķ���substring������˫�ֽڵĺ��ֵ���һ���ֽڵ��ַ���UCS2�ַ��������ˣ������ǵ��ֽ�����һ������
 * ���������ֽڣ�����Ҫ����substring����������Ҫ�������ĸ���count���Զ��ſ���
 * 
 * @author Administrator
 *
 */
public class ZhiSubString {
	public static String subString(String str, int len) {
		if (str == null && "".equals(str)) {
			return null;
		}
		// ���ַ����е�char����ת����ָ�����뷽ʽ��byte����ĺ���
		byte[] strBytes = null;
		try {
			strBytes = str.getBytes("GBK");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		// �õ��ַ����ĳ��ȣ��жϽ�ȡ�ַ����ĳ����Ƿ����жϵķ�Χ�ڣ����򷵻�ԭ��
		int strLen = strBytes.length;
		if (len >= strLen || len < 1) {
			return str;
		}
		System.out.println("strBytes.length=" + strBytes.length);
		System.out.println("len=" + len);
		int count = 0;
		for (int i = 0; i < len; i++) {
			// ��ÿ���ֽ�����ת��Ϊ����������Ϊ�������ֵ���������ж��Ƿ�Ϊ����
			int value = strBytes[i];
			System.out.print(value + ","); // ��ABC�� -50,-46,65,66,67,-60,-29
			// ���ڵ�һ�������
			// ע��һ������ת������������Ϊ����������,����ġ���ABC�㡰��
			// ת������������Ϊ-50,-46,65,66,67,-60,-29������len=6�����Խ�ȡ�����ľ���-50,-46,65,66,67,-60,count��Ϊ3
			// ����Ǻ���(��)����ͳ�ƽ�ȡ�ַ����еĺ�����ռ�ֽ���
			if (value < 0) {
				count++;
			}
			System.out.println("zh count=" + count);
		}
		// �����жϸ������ַ����Ƿ��к��֣�����String���substring()��������ȡ��ͬ�ĳ���

		// ������ͳ�Ƶ��ֽ������жϽ�ȡ���ַ��Ƿ�Ϊ������֣�����Ϊ�������
		if (count % 2 != 0) {
			// ����ڽ�ȡ����Ϊ1ʱ���򽫸ú���ȡ����
			// ��������򲻽�ȡ����Ľ�ȡ�������ַ����Ƚ�ȡ����ȡ�ֽڳ�����-��ȡ�����ֽ���/2-��ȡ���İ�����ֵ��ֽ�����
			len = (len == 1) ? len : len - count / 2 - 1; // len=6-3/2-1=4 ��ABC
			// System.out.println("������len="+len);

		} else {
			// ��ȡ�ַ�����Ϊ�ֽڳ���-������ռ�ֽڳ���/2������ռ�����ֽڣ�
			len = len - (count / 2);
		}
		return str.substring(0, len);

	}

	public static void main(String[] args) {

		// String inStrTest = "��ABC��EFG";
		// String strTest = inStrTest.substring(0, 2);
		// System.out.println(strTest);

		System.out.println("--------- ���һ-----------");
		// ���һ��
		String inStr = "��ABC��";
		String str = subString(inStr, 6);
		System.out.println(str); // ��ABC www.2cto.com

		System.out.println("---------- �����----------");
		// ����������ַ�Ϊ����
		inStr = "��ABC��DEF";
		str = subString(inStr, 1);
		System.out.println(str); // ��

		System.out.println("-----------�����---------");

		// ��������м�����������
		inStr = "��AB������CDEF";
		str = subString(inStr, 9);
		System.out.println(str); // ��AB����

		System.out.println("-----------�����---------");
		// ����ģ�û�к���
		inStr = "ABCDEF";
		str = subString(inStr, 4);
		System.out.println(str); // ABCD
	}

}
