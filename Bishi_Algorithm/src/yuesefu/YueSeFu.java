package yuesefu;

public class YueSeFu {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int N = 10;
		int[] data = new int[N];
		int[] state = new int[N];
		//��ʼ�� 
	    for(int i=0; i<N; i++){  
	    	data[i] = i+1;
	    	state[i] = 0;
	    }
	    //out_c��ʾ��Ȧ������temp_cΪ������indexΪ��ǰ����
	    int out_c=0, temp_c=0, m=3, index=0;
	    while(out_c<(N-1)){
	    	index = index%N;
	    	for(int i=0; i<N && out_c<(N-1); i++){
	    		if(state[i]==1){
	    			continue;
	    		}
	    		++temp_c;
	    		if(temp_c==m){
	    			state[i]=1;
	    			++out_c;
	    			temp_c=0;
	    		}
	    	}
	    }
	    //���
	    for(int i=0; i<N; i++){
	    	System.out.println(state[i]);
	    }
	}

}
