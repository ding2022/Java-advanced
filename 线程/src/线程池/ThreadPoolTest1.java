package 线程池;

public class ThreadPoolTest1 {
	public static void main(String[] args) {
		if (args.length != 2) {
			System.out.println("lala");
		}
		int numTasks = Integer.parseInt(args[0]);
		int poolSize = Integer.parseInt(args[1]);

		ThreadPool threadPool = new ThreadPool(poolSize);// 创建自定义的线程池

		// 运行任务
		for (int i = 0; i < numTasks; i++) {
			threadPool.execute(createTask(i));
		}
		threadPool.join();// 工作线程全部执行完毕 关闭线程池
	}

	// 定义了一个简单任务类
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
