package base;

class t01 extends Thread {
	private String id;
	public t01(String str){
		id=str;
	}
	public void run(){
		try{
			for(int i=0;i<4;i++){
				System.out.println(id+"�������С�����������");
				sleep(500);
			}
		}catch(InterruptedException e){
		System.out.println("error");	
		}
	}
}
public class Th01{
	public static void main(String[] args) {
		t01 thread1=new t01("�߳�1");
		t01 thread2=new t01("�߳�2");
		thread1.start();
		thread2.start();
	}
}
