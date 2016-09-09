package sort_test;

public class MySort {

	static int[] data = { 9, 0, 4, 6, 2, 5 };

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// bubbleSort(data);
		// insertSort(data);
		//sort(data, 0, data.length - 1);
		sort1(data, 1, data.length-1);
		for (int i = 0; i < data.length; i++) {
			System.out.println(data[i]);
		}
	}

	// 冒泡法排序
	public static void bubbleSort(int[] numbers) {
		if (data == null || data.length <= 1) {
			return;
		}
		int temp; // 记录临时中间值
		int size = numbers.length; // 数组大小
		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < size - i - 1; j++) {
				if (numbers[j] > numbers[j + 1]) { // 交换两数的位置
					temp = numbers[j];
					numbers[j] = numbers[j + 1];
					numbers[j + 1] = temp;
				}
			}
		}
	}

	/*
	 * 直接插入排序
	 */
	public static void insertSort(int[] data) {
		if (data == null || data.length <= 1) {
			return;
		}
		for (int i = 1; i < data.length; i++) {
			if (data[i] < data[i - 1]) {
				int temp = data[i];
				data[i] = data[i - 1];
				int j;
				for (j = i - 2; j >= 0 && data[j] > temp; j--)
					data[j + 1] = data[j];
				data[j + 1] = temp;
			}
		}
	}

	// 快速排序
	public static void sort(int[] data, int low, int high) {
		if (low < high) {
			int mid = partition(data, low, high);
			sort(data, low, mid - 1);
			sort(data, mid + 1, high);
		}
	}

	// 以某个数字为枢轴，小的在其左，大的在其右
	public static int partition(int[] data, int low, int high) {
		int temp = data[low];
		while (low < high) {
			while (low < high && data[high] > temp)
				high--;
			data[low] = data[high];
			while (low < high && data[low] < temp)
				low++;
			data[high] = data[low];
		}
		data[low] = temp;
		return low;
	}

	// 二路归并算法
	public static void sort1(int[] data, int low, int high) {
		if (low < high) {
			int mid = (low + high) / 2;
			sort1(data, low, mid);
			sort1(data, mid + 1, high);
			merge(data, low, mid, high);
		}
	}

	// 归并两个数组,将data中data[i]-data[m]和data[m+1]-data[n]归并到target
	public static void merge(int[] data, int low, int mid, int high) {
		if (low == high) {
			return;
		}
		int[] target = new int[high - low + 1];
		int i = low;
		int j = mid + 1;
		int k = 0;

		while (i <= mid && j <= high) {
			if (data[i] <= data[j]) {
				target[k++] = data[i++];
			} else {
				target[k++] = data[j++];
			}
		}
		while (i <= mid) {
			target[k++] = data[i++];
		}
		while (j <= high) {
			target[k++] = data[j++];
		}
		for (i = 0, j = low; i < target.length; i++, j++) {
			data[j] = target[i];
		}
	}
}
