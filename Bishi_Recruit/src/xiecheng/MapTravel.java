package xiecheng;

/*
0,1,2,3
1,0,4,5
2,4,0,2
3,5,2,0
 */
public class MapTravel {
	static int c = 0;
	static int path = 0;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] map = {{0,1,2,3},{1,0,4,5},{2,4,0,2},{3,5,2,0}};
		int l = map.length;
		
		int [] isTraveled = {0,0,0,0};
		int min_i=0,min_j=0;
		int min = 100;
		for(int i=0; i<l; i++){
			for(int j=0; j<i; j++){
				if(i!=j && min>map[i][j]){
					min = map[i][j];
					min_i = i;
					min_j = j;
				}
			}
		}
		path+=map[min_i][min_j];
		isTraveled[min_i] = 1;
		++c;
		while(c<l-1){
			min_j = travel(isTraveled, map, min_j);
		}
		System.out.println(path);
	}
	public static int travel(int [] isTraveled, int[][] map, int next_i){
		int min = 100;
		int min_j=0;
		for(int j=0; j<isTraveled.length; j++){
			if(next_i!=j && isTraveled[j]==0 && map[next_i][j]<min){
				min = map[next_i][j];
				min_j = j;
			}
		}
		isTraveled[min_j] = 1;
		path+=map[next_i][min_j];
		++c;
		return min_j;
	}
}
