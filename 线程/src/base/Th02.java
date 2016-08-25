package base;

public class Th02 {

	public static void main(String[] args) {
		t02 thread3 = new t02("线程1");
		t02 thread4 = new t02("线程2");

		Thread thread1 = new Thread(thread3);
		Thread thread2 = new Thread(thread4);

		thread1.start();
		thread2.start();
	}

}

class t02 implements Runnable {
	private String id;

	public t02(String str) {
		id = str;
	}

	public void run() {
		try {
			for (int i = 0; i < 4; i++) {
				System.out.println(id + "正在运行………………");
				// sleep(500);
			}
		} catch (Exception e) {
			System.out.println("error");
		}
	}
}