package xuHua;

public class C {

	public static Data d = new Data(0);
	
}
class Data{
	int value = 0;
	public Data(int value){
		this.value = value;
	}
	@Override
	public String toString() {
		return "Data [value=" + value + "]";
	}
	
}