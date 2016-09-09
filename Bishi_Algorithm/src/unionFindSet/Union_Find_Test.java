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
 * 并查集，数据结构 采用泛型编程
 * 采用指向父节点方式实现，即map.get(key)的值是父节点的key，根节点的key和value相等，也是一个并查集的入口
 * 
 * @author "zhshl"
 * @date 2014-10-20
 *
 */
class Union_Find<T> {
	public HashMap<T, T> unionMap = new HashMap<T, T>(); // 记录节点之间的关系
	public HashMap<T, Integer> unionSize = new HashMap<T, Integer>();// /某个树的大小，某一个并查集的大小
	public int count = 0;// /并查集数目

	/**
	 * 获取并查集总数
	 * 
	 * @return
	 */
	public int getCount() {
		return count;
	}
	/**
	 * 返回key属于的并查集的根的value,如果不存在key则返回NULL
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
			// /如果key和value不相等，则不是根节点

			// /路劲压缩，将该节点的父节点指向其爷爷节点
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
	 * 将key1，key2加入并查集
	 * 
	 * @param key1
	 * @param key2
	 */
	public void union(T key1, T key2) {
		// /首次加入则存入map中
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
			// /如果已经属于同一个并查集，直接返回
			return;
		}
		if (unionSize.get(root1) > unionSize.get(root2)) {
			// //第一个并查集包含节点多时, 让第二颗树根节点指向第一颗树根节点,并修改对应的并查集大小
			unionMap.put(root2, root1);

			int size = unionSize.get(root1) + unionSize.get(root2);
			unionSize.put(root1, size);
		} else {
			unionMap.put(root1, root2);
			int size = unionSize.get(root1) + unionSize.get(root2);
			unionSize.put(root2, size);
		}
		count--;// //总并查集数目减少一
	}
}
