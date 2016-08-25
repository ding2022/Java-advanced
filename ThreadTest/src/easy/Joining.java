package easy;

public class Joining {

	public static void main(String[] args) {
		Sleeper sleepy=new Sleeper("sleepy", 7500),
				grumpy=new Sleeper("Grumpy", 1500);
		joiner  dopey =new joiner("Dopey", sleepy),
				doc =new joiner("Doc",grumpy);
		grumpy.interrupt();
	}

}
class Sleeper extends Thread{
	private int duration;
	public Sleeper(String name,int sleepTime){
		super(name);
		duration=sleepTime;
		start();
	}
	public void run() {
		try{
			sleep(duration);
		}catch(InterruptedException e){
			System.out.println(getName()+" was interrupted."
					+"isInterrupted():"+isInterrupted());
			return;
		}
		System.out.println(getName()+" has awakened");
	}
}
class joiner extends Thread{
	private Sleeper sleeper;
	public joiner(String name,Sleeper sleeper){
		super(name);
		this.sleeper=sleeper;
		start();
	}
	public void run(){
		try{
			sleeper.join();
		}catch(InterruptedException e){
			System.out.println(" Interrupted");
		}
		System.out.println(getName()+" join completed");
	}
}