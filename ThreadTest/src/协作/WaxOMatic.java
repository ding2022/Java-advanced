package Ð­×÷;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WaxOMatic {
	public static void main(String[] args) throws InterruptedException {
		Car car=new Car();
		ExecutorService exec=Executors.newCachedThreadPool();
		exec.execute(new WaxOff(car));
		exec.execute(new WaxOn(car));
		TimeUnit.SECONDS.sleep(200);
		exec.shutdownNow();
	}
}

class Car{
	private boolean waxOn=false;
	public synchronized void waxed(){
		waxOn=true;
		notifyAll();
	}
	public synchronized void buffed() {
		waxOn=false;
		notifyAll();
	}
	public synchronized void waitForWaxing() throws InterruptedException{
		while(waxOn==false)
			wait();
	}
}
class WaxOn implements Runnable{
	private Car car;
	public WaxOn(Car c){car=c;}
	public void run(){
		try{
			while(!Thread.interrupted())
				System.out.println("Wax On!");
			TimeUnit.MILLISECONDS.sleep(2000);
			car.waxed();
			car.waitForWaxing();
		}catch(InterruptedException e){
			System.out.println("Exiting via interrupt");
		}
		System.out.println("Ending Wax On task");
	}
}
class WaxOff implements Runnable{
	private Car car;
	public WaxOff(Car c){car=c;}
	public void run(){
		try{
			while(!Thread.interrupted()){
				car.waitForWaxing();
				System.out.println("Wax Off!");
				TimeUnit.MILLISECONDS.sleep(2000);
				car.buffed();
			}
		}catch(InterruptedException e){
			System.out.println("Exiting via interrupt!");
		}
		System.out.println("Ending Wax Off task");
	}
}