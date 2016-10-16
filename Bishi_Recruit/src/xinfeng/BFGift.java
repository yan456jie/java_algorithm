package xinfeng;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
/**
 * һ����Ƭװ��n���ŷ⣬�ŷ��Ƕ�ף������������ŷ�װ
 * @author root
 *
 */
public class BFGift {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		readdata();
	}

	public static void readdata(){
		Scanner in = new Scanner(System.in);
		while (in.hasNext()) {
			int n = in.nextInt();
			int x = in.nextInt();
			int y = in.nextInt();
			Letter card = new Letter(0,x,y);
			Letter []letter_data = new Letter[n+1];
			letter_data[0] = card;
			for(int i=1; i<=n; i++){
				x = in.nextInt();
				y = in.nextInt();
				Letter l1 = new Letter(i,x,y);
				letter_data[i] = l1;
			}
			putCardInLetter(letter_data);
		}
	}
	
	public static void putCardInLetter(Letter []letter_data){
		//����
		Arrays.sort(letter_data);
		
		List<Letter> final_letter = new ArrayList<Letter>();
		List<Letter> temp_letter = new ArrayList<Letter>();
		//ѡ����cardλ�ÿ�ʼ��x����ö�����������������
		boolean start = false;
		for(int i=0; i<letter_data.length; i++){
			if(letter_data[i].index==0){
				start = true;
				continue;
			}
			if(start){
				temp_letter.add(letter_data[i]);
				for(int j=i+1; j<letter_data.length; j++){
					if(letter_data[j].y>letter_data[i].y){
						temp_letter.add(letter_data[j]);
					}
				}
				if(temp_letter.size()>final_letter.size()){
					final_letter = new ArrayList<Letter>(temp_letter);
				}
				temp_letter.clear();
			}
		}
		for(int i=0; i<final_letter.size(); i++){
			System.out.println(final_letter.get(i));
		}
	}	
}
//�ŷ��ࣨ����card��
class Letter implements Comparable{
	public int x;
	public int y;
	public int index;//0��ʾ���ƣ�1��ʾ��һ���ŷ�...
	public Letter(int index, int x, int y){
		this.index = index;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public String toString() {
		return "Letter [x=" + x + ", y=" + y + ", index=" + index + "]";
	}

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		Letter t2=(Letter)o;
	  	if(this.x>t2.x){
	  		return 1;
	  	}
	  	if(this.x<t2.x){
	  		return -1;
	  	}
		return 0;
	}	
}
