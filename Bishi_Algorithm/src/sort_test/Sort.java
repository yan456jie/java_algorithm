package sort_test;

public class Sort {

	static int[] data = {9,4,6,2,5};
	
	public static void main(String[] args) {
		
	}
	
	/**  
	 * ð�ݷ�����<br/>  

	 * <li>�Ƚ����ڵ�Ԫ�ء������һ���ȵڶ����󣬾ͽ�������������</li>  
	 * <li>��ÿһ������Ԫ����ͬ���Ĺ������ӿ�ʼ��һ�Ե���β�����һ�ԡ�����һ�㣬����Ԫ��Ӧ�û�����������</li>  
	 * <li>������е�Ԫ���ظ����ϵĲ��裬�������һ����</li>  
	 * <li>����ÿ�ζ�Խ��Խ�ٵ�Ԫ���ظ�����Ĳ��裬ֱ��û���κ�һ��������Ҫ�Ƚϡ�</li>  

	 *   
	 * @param numbers  
	 *            ��Ҫ�������������  
	 */  
	public static void bubbleSort(int[] numbers) {   
	    int temp; // ��¼��ʱ�м�ֵ   
	    int size = numbers.length; // �����С   
	    for (int i = 0; i < size - 1; i++) {   
	        for (int j = i + 1; j < size; j++) {   
	            if (numbers[i] < numbers[j]) { // ����������λ��   
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	            }   
	        }   
	    }   
	}  
	
	/**  
	 * ��������<br/>  
	 * <ul>  
	 * <li>������������һ��Ԫ�أ���Ϊ����׼��</li>  
	 * <li>�����������У�����Ԫ�رȻ�׼ֵС�İڷ��ڻ�׼ǰ�棬����Ԫ�رȻ�׼ֵ��İ��ڻ�׼�ĺ��棨��ͬ�������Ե���һ�ߣ���������ָ�֮��  
	 * �û�׼���������λ�á������Ϊ�ָpartition��������</li>  
	 * <li>�ݹ�ذ�С�ڻ�׼ֵԪ�ص������кʹ��ڻ�׼ֵԪ�ص�����������</li>  
	 * </ul>
	 *   
	 * @param numbers  
	 * @param start  
	 * @param end  
	 */  
	public static void quickSort(int[] numbers, int start, int end) {   
	    if (start < end) {   
	        int base = numbers[start]; // ѡ���Ļ�׼ֵ����һ����ֵ��Ϊ��׼ֵ��   
	        int temp; // ��¼��ʱ�м�ֵ   
	        int i = start, j = end;   
	        do {   
	            while ((numbers[i] < base) && (i < end))   
	                i++;   
	            while ((numbers[j] > base) && (j > start))   
	                j--;   
	            if (i <= j) {
	                temp = numbers[i];   
	                numbers[i] = numbers[j];   
	                numbers[j] = temp;   
	                i++;   
	                j--;   
	            }   
	        } while (i <= j);
	        if (start < j)   
	            quickSort(numbers, start, j);   
	        if (end > i)   
	            quickSort(numbers, i, end);   
	    }   
	}  
	
	/**  
	 * ѡ������<br/>  
	 * <li>��δ�����������ҵ���СԪ�أ���ŵ��������е���ʼλ��</li>  
	 * <li>�ٴ�ʣ��δ����Ԫ���м���Ѱ����СԪ�أ�Ȼ��ŵ���������ĩβ��</li>  
	 * <li>�Դ����ƣ�ֱ������Ԫ�ؾ�������ϡ�</li>  

	 *   
	 * @param numbers  
	 */  
	public static void selectSort(int[] numbers) {   
	    int size = numbers.length, temp;   
	    for (int i = 0; i < size; i++) {   
	        int k = i;   
	        for (int j = size - 1; j >i; j--)  {   
	            if (numbers[j] < numbers[k])  k = j;   
	        }   
	        temp = numbers[i];   
	        numbers[i] = numbers[k];   
	        numbers[k] = temp;   
	    }   
	}  
	
	/**  
	 * ��������<br/>  
	 * <ul>  
	 * <li>�ӵ�һ��Ԫ�ؿ�ʼ����Ԫ�ؿ�����Ϊ�Ѿ�������</li>  
	 * <li>ȡ����һ��Ԫ�أ����Ѿ������Ԫ�������дӺ���ǰɨ��</li>  
	 * <li>�����Ԫ�أ������򣩴�����Ԫ�أ�����Ԫ���Ƶ���һλ��</li>  
	 * <li>�ظ�����3��ֱ���ҵ��������Ԫ��С�ڻ��ߵ�����Ԫ�ص�λ��</li>  
	 * <li>����Ԫ�ز��뵽��λ����</li>  
	 * <li>�ظ�����2</li>  
	 * </ul>  
	 *   
	 * @param numbers  
	 */  
	public static void insertSort(int[] numbers) {   
	    int size = numbers.length, temp, j;   
	    for(int i=1; i<size; i++) {   
	        temp = numbers[i];   
	        for(j = i; j > 0 && temp < numbers[j-1]; j--)   
	            numbers[j] = numbers[j-1];   
	        numbers[j] = temp;   
	    }   
	}  
	
	/**  
	 * �鲢����<br/>  
	 * <ul>  
	 * <li>����ռ䣬ʹ���СΪ�����Ѿ���������֮�ͣ��ÿռ�������źϲ��������</li>  
	 * <li>�趨����ָ�룬���λ�÷ֱ�Ϊ�����Ѿ��������е���ʼλ��</li>  
	 * <li>�Ƚ�����ָ����ָ���Ԫ�أ�ѡ�����С��Ԫ�ط��뵽�ϲ��ռ䣬���ƶ�ָ�뵽��һλ��</li>  
	 * <li>�ظ�����3ֱ��ĳһָ��ﵽ����β</li>  
	 * <li>����һ����ʣ�µ�����Ԫ��ֱ�Ӹ��Ƶ��ϲ�����β</li>  
	 * </ul>  
	 *   
	 * @param numbers  
	 */  
	public static void mergeSort(int[] numbers, int left, int right) {   
	    int t = 1;// ÿ��Ԫ�ظ���   
	    int size = right - left + 1;   
	    while (t < size) {   
	        int s = t;// ����ѭ��ÿ��Ԫ�ظ���   
	        t = 2 * s;   
	        int i = left;   
	        while (i + (t - 1) < size) {   
	            merge(numbers, i, i + (s - 1), i + (t - 1));   
	            i += t;   
	        }   
	        if (i + (s - 1) < right)   
	            merge(numbers, i, i + (s - 1), right);   
	    }   
	}   
	/**  
	 * �鲢�㷨ʵ��  
	 *   
	 * @param data  
	 * @param p  
	 * @param q  
	 * @param r  
	 */  
	private static void merge(int[] data, int p, int q, int r) {   
	    int[] B = new int[data.length];   
	    int s = p;   
	    int t = q + 1;   
	    int k = p;   
	    while (s <= q && t <= r) {   
	        if (data[s] <= data[t]) {   
	            B[k] = data[s];   
	            s++;   
	        } else {   
	            B[k] = data[t];   
	            t++;   
	        }   
	        k++;   
	    }   
	    if (s == q + 1)   
	        B[k++] = data[t++];   
	    else  
	        B[k++] = data[s++];   
	    for (int i = p; i <= r; i++)   
	        data[i] = B[i];   
	}  
}
