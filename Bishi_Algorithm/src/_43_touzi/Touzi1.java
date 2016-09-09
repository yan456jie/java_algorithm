package _43_touzi;

import java.util.HashMap;
import java.util.Map;

public class Touzi1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Map<String,String> ms = new HashMap<String,String>();
		int a,b,c,d,e,f;
		int n=2;
		int sum=0;
		for(a=0;a<=n;a++)
		{
			for(b=0;b<=n-a;b++)
			{
				for(c=0;c<=n-a-b;c++)
				{
					for(d=0;d<=n-a-b-c;d++)
					{
						for(e=0;e<=n-a-b-c-d;e++)
						{
							f=n-a-b-c-d-e;
							sum=1*a+2*b+3*c+4*d+5*e+6*f;
							String str = a+"+"+b+"+"+c+"+"+d+"+"+e+"+"+f;
							ms.put(String.valueOf(sum), str);
							
						}
					}
				}
			}
		}
		System.out.println(ms);
	}

}
