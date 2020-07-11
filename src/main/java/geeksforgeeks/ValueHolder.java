package geeksforgeeks;

public class ValueHolder {
	//constructor	
	public ValueHolder(int value) {
		this.value = value;
	}
	//public field
	public int value;
	//toString method
	@Override
	public String toString() {
		return "{value: "+this.value+"}";
	}
}
