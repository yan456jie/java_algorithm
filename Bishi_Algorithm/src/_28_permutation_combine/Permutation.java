package _28_permutation_combine;
import java.util.Arrays;
/**
 * 全排列
 * @author root
 *
 */
public class Permutation {
	public static void main(String[] args) {
		//int[] array = new int[] { 1, 2, 3};
		int[] array = new int[] { 1, 1, 1};
		permute1(array, 0);
	}
	/*
	 * 不存在重复字符的
	 */
	public static void permute(int a[], int k) {
		if (k == a.length) {
			System.out.println(Arrays.toString(a));
		} else
			for (int i = k; i < a.length; ++i) {
				swap(a, k, i);
				permute(a, k + 1);
				swap(a, k, i);
			}
	}
	/*
	 * 存在重复字符的
	 */
	public static void permute1(int a[], int k) {
		if (k == a.length) {
			System.out.println(Arrays.toString(a));
		} else
			for (int i = k; i < a.length; ++i) {
				if(i==k || a[i]!=a[k]){
					swap(a, k, i);
					permute1(a, k + 1);
					swap(a, k, i);
				}
			}
	}
	private static void swap(int[] a, int s, int i) {
		int t = a[s];
		a[s] = a[i];
		a[i] = t;
	}
}
