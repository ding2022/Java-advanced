package �̳߳�;

public class ThreadPoolTest1 {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("lala");
		}
		int numTasks = Integer.parseInt(args[0]);
		int poolSize = Integer.parseInt(args[1]);

		ThreadPool threadPool = new ThreadPool(poolSize);// �����Զ�����̳߳�

		// ��������
		for (int i = 0; i < numTasks; i++) {
			threadPool.execute(createTask(i));
		}
		threadPool.join();// �����߳�ȫ��ִ����� �ر��̳߳�
	}

	// ������һ����������
	private static Runnable createTask(final int taskID) {
		return new Runnable() {

			@Override
			public void run() {
				System.out.println(taskID);
				try {
					Thread.sleep(500);
				} catch (Exception e) {
					System.out.println(taskID);
				}
			}
		};
	}

}
