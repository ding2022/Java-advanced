package 线程池;

import java.util.LinkedList;

public class ThreadPool extends ThreadGroup {

	private boolean isClosed = false;
	private LinkedList<Runnable> workQueue;// 表示工作队列
	private static int threadPoolID; // 表示线程池ID
	private int threadID; // 表示工作线程ID

	public ThreadPool(int poolSize) {// 指定线程池中的工作线程数目
		super("ThreadPool-" + (threadPoolID++));
		setDaemon(true);// 检查线程安全
		workQueue = new LinkedList<Runnable>();// 创建工作队列
		for (int i = 0; i < poolSize; i++)
			new WorkThread().start();
	}

	// 向工作队列中加入一个新任务，由工作线程去执行该任务
	public synchronized void execute(Runnable task) {
		if (isClosed) { // 线程池关闭
			throw new IllegalStateException();
		}
		if (task != null) {
			workQueue.add(task);
			notify();// 唤醒正在getTask（）方法中等待任务的工作线程
		}
	}

	// 从工作队列中取出一个任务，工作线程会调用此方法
	protected synchronized Runnable getTask() throws InterruptedException {
		while (workQueue.size() == 0) {
			if (isClosed)
				return null;
			wait();// 如果工作队列没有任务 就等待任务
		}
		return workQueue.removeFirst();
	}

	// 关闭线程池
	public synchronized void close() {
		if (!isClosed) {
			isClosed = true;
			workQueue.clear();// 清理线程队列
			interrupt();
		}
	}

	// 等待工作线程把所有任务执行完
	public void join() {
		synchronized (this) {
			isClosed = true;
			notify();// 唤醒还在getTask（）方法中等待任务的工作线程
		}
		Thread[] threads = new Thread[activeCount()];
		// enumerate方法继承自ThreadGroup 类，获得线程组中当前活着的所有线程

		int count = enumerate(threads);
		for (int i = 0; i < count; i++) {// 等待所有的工作线程运行结束
			try {
				threads[i].join();
			} catch (InterruptedException e) {
			}
		}
	}

	// 内部类 工作线程
	private class WorkThread extends Thread {
		public WorkThread() {
			// 加入到当前ThreadPool线程组中
			super(ThreadPool.this, "WorkThread-" + (threadID++));
		}

		public void run() {
			while (!isInterrupted()) {// 判断线程是否被中断
				Runnable task = null;
				try {// 取出任务
					task = getTask();
				} catch (InterruptedException ex) {
				}
				if (task == null)
					return;
				try {
					task.run();
				} catch (Throwable t) {
					t.printStackTrace();
				}

			}
		}
	}
}
