package prob5;

public class MyStack2<T> {
	private int top;
	private T[] buffer;

	public MyStack2(int capacity) {
		top = -1;
		buffer = (T[])new Object[capacity];
	}

	public void push(T s) {
		if (top == buffer.length - 1) {
			resize();
		}

		buffer[++top] = s;
	}

	public T pop() throws MyStackException {
		if (isEmpty()) {
			throw new MyStackException();
		}

		T result = buffer[top];
		buffer[top--] = null;

		return result;
	}

	public boolean isEmpty() {
		return top == -1;
	}

	private void resize() {
		T[] temp = (T[])new Object[buffer.length * 2];
		for (int i = 0; i <= top; i++) {
			temp[i] = buffer[i];
		}

		buffer = temp;
	}

}