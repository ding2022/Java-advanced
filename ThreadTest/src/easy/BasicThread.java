package easy;

public class BasicThread {

	public static void main(String[] args) throws InterruptedException {
		//运用thread构造器来实现
		Thread thread=new Thread(new LiftOff());
		Thread thread2=new Thread();
		
		thread.start();
		thread2.sleep(3000);
		System.out.println("waiting for liftoff");
	}

}
