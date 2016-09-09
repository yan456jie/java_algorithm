package unionFindSet;

import java.util.HashMap;

public class Union_Find_Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Union_Find<String> uf = new Union_Find<String>();
		uf.union("aaa", "bbb");
		System.out.println(uf.unionMap);
		uf.union("bbb", "ccc");
		System.out.println(uf.unionMap);
		uf.union("bbb", "ddd");
		System.out.println(uf.unionMap);
		uf.union("eee", "fff");
		System.out.println(uf.unionMap);
		uf.union("ggg", "ggg");
		System.out.println(uf.unionMap);
		uf.union("ddd", "hhh");
		System.out.println(uf.unionMap);
		/*
		String str1 = uf.find("s5");
		String str2 = uf.find("s2");
		System.out.println(str1 + ":::::" + str2);
		*/
		/*
		 * Union_Find<Integer> uf2=new Union_Find<Integer>(); uf2.union(1, 2);
		 * uf2.union(3, 2); uf2.union(4, 2); uf2.union(5, 2); uf2.union(3, 5);
		 * uf2.union(2, 4);
		 */

		
	}

}

/**
 * ���鼯�����ݽṹ ���÷��ͱ��
 * ����ָ�򸸽ڵ㷽ʽʵ�֣���map.get(key)��ֵ�Ǹ��ڵ��key�����ڵ��key��value��ȣ�Ҳ��һ�����鼯�����
 * 
 * @author "zhshl"
 * @date 2014-10-20
 *
 */
class Union_Find<T> {
	public HashMap<T, T> unionMap = new HashMap<T, T>(); // ��¼�ڵ�֮��Ĺ�ϵ
	public HashMap<T, Integer> unionSize = new HashMap<T, Integer>();// /ĳ�����Ĵ�С��ĳһ�����鼯�Ĵ�С
	public int count = 0;// /���鼯��Ŀ

	/**
	 * ��ȡ���鼯����
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}
	/**
	 * ����key���ڵĲ��鼯�ĸ���value,���������key�򷵻�NULL
	 * 
	 * @param key
	 * @return
	 */
	public T find(T key) {

		if (!unionMap.containsKey(key)) {
			return null;
		}

		T value = unionMap.get(key);
		while (!value.equals(key)) {
			// /���key��value����ȣ����Ǹ��ڵ�

			// /·��ѹ�������ýڵ�ĸ��ڵ�ָ����үү�ڵ�
			unionMap.put(key, unionMap.get(unionMap.get(key)));

			key = value;
			if (!unionMap.containsKey(key)) {
				return null;
			}
			value = unionMap.get(key);
		}
		return value;
	}
	/**
	 * ��key1��key2���벢�鼯
	 * 
	 * @param key1
	 * @param key2
	 */
	public void union(T key1, T key2) {
		// /�״μ��������map��
		if (!unionMap.containsKey(key1)) {
			unionMap.put(key1, key1);
			unionSize.put(key1, 1);
			count++;
		}
		if (!unionMap.containsKey(key2)) {
			unionMap.put(key2, key2);
			unionSize.put(key2, 1);
			count++;
		}
		T root1 = find(key1);
		T root2 = find(key2);

		if (root1.equals(root2)) {
			// /����Ѿ�����ͬһ�����鼯��ֱ�ӷ���
			return;
		}
		if (unionSize.get(root1) > unionSize.get(root2)) {
			// //��һ�����鼯�����ڵ��ʱ, �õڶ��������ڵ�ָ���һ�������ڵ�,���޸Ķ�Ӧ�Ĳ��鼯��С
			unionMap.put(root2, root1);

			int size = unionSize.get(root1) + unionSize.get(root2);
			unionSize.put(root1, size);
		} else {
			unionMap.put(root1, root2);
			int size = unionSize.get(root1) + unionSize.get(root2);
			unionSize.put(root2, size);
		}
		count--;// //�ܲ��鼯��Ŀ����һ
	}
}
