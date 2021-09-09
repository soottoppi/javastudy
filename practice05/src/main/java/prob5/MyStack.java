package prob5;

public class MyStack {
	private int size;
	private int top = -1;
	String[] stringArr = null;
	
	public MyStack(int size) {
		this.size = size;
		stringArr = new String[size];
	}

	public void push(String string) {
		top++;
		if(top < size) {
			stringArr[top] = string;			
		}
	}

	public boolean isEmpty() {
		return top < 0;
	}

	public String pop() {
		return stringArr[top--];
	}

	final int getTop() {
		return top;
	}

	final void setTop(int top) {
		this.top = top;
	}

	final String[] getStringArr() {
		return stringArr;
	}

	final void setStringArr(String[] stringArr) {
		this.stringArr = stringArr;
	}

	final int getSize() {
		return size;
	}

	final void setSize(int size) {
		this.size = size;
	}
	
	
}