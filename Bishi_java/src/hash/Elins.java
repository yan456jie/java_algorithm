package hash;

import java.util.*;

public class Elins {
	public static void main(String[] args) {
		Collection c = new HashSet();
		c.add("Hellow");
		c.add(new Name("最火软件站", "www.veryhuo.com"));

		System.out.println(c.remove(new Name("最火软件站", "www.veryhuo.com")));
		System.out.println(c);

	}
}

class Name extends Object{
	private String c;
	private String d;

	public Name(String a, String b) {
		this.c = a;
		this.d = b;
	}

	public String toString() {
		return c + ":" + d;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		result = prime * result + ((d == null) ? 0 : d.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Name other = (Name) obj;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		if (d == null) {
			if (other.d != null)
				return false;
		} else if (!d.equals(other.d))
			return false;
		return true;
	}

}