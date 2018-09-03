package multiThread;


public class BeepPrint {

	public static void main(String[] args) {
		//Runnable beepTask = new BeepTask();
	//	Thread thread = new Thread(beepTask);
		Thread thread = new BeepThread();
		thread.start();
		
		
		for(int i = 0; i<5; i++) {
			System.out.println("¶ò");
			try {Thread.sleep(500);}catch(Exception e) {}
		}
		
		
	}

}
