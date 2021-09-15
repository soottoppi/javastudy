package thread;

public class ThreadEx03 {

	public static void main(String[] args) {
		Thread thread1 = new DigitThread();
		Thread thread2 = new AlphabetThread();
		// Thread를 생성시 Runnable 구현한 객체를 넣어주어야함
		Thread thread3 = new Thread(new UpperCaseAlphabetRunnableImpl());	
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}
