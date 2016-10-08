package combination;

import java.util.ArrayList;
import java.util.List;

/**
 * 给n个字符串找出其所有的k位组合，可重复使用字符
 * @author root
 *
 */
public class Combination1 {
    private static char[] is = new char[] { '1', '2', '4', '5', '6', '7', '8', '9'};
    private static int total;
    private static int m = 2;
    public static void main(String[] args) {
        List<Integer> iL = new ArrayList<Integer>();
        new Combination1().plzh("", iL,  m);
        System.out.println("total : " + total);
    }
    private void plzh(String s, List<Integer> iL, int m) {
        if(m == 0) {
            System.out.println(s);
            total++;
            return;
        }
        List<Integer> iL2;
        for(int i = 0; i < is.length; i++) {
            iL2 = new ArrayList<Integer>();
            iL2.addAll(iL);
            if(!iL.contains(i)) {
                String str = s + is[i];
                iL2.add(i);
                plzh(str, iL2, m-1);
            }
        }
    }
}
