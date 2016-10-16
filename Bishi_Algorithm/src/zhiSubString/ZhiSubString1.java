package zhiSubString;

import java.io.UnsupportedEncodingException;

public class ZhiSubString1 {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String str = "ÓÐººABEF";
		System.out.println(new String(str.getBytes("GBK"),0,2)); // ABCD
	}

}
