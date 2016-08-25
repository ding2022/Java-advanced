package �̳߳�;

import java.util.LinkedList;

public class ThreadPool extends ThreadGroup {

	private boolean isClosed = false;
	private LinkedList<Runnable> workQueue;// ��ʾ��������
	private static int threadPoolID; // ��ʾ�̳߳�ID
	private int threadID; // ��ʾ�����߳�ID

	public ThreadPool(int poolSize) {// ָ���̳߳��еĹ����߳���Ŀ
		super("ThreadPool-" + (threadPoolID++));
		setDaemon(true);// ����̰߳�ȫ
		workQueue = new LinkedList<Runnable>();// ������������
		for (int i = 0; i < poolSize; i++)
			new WorkThread().start();
	}

	// ���������м���һ���������ɹ����߳�ȥִ�и�����
	public synchronized void execute(Runnable task) {
		if (isClosed) { // �̳߳عر�
			throw new IllegalStateException();
		}
		if (task != null) {
			workQueue.add(task);
			notify();// ��������getTask���������еȴ�����Ĺ����߳�
		}
	}

	// �ӹ���������ȡ��һ�����񣬹����̻߳���ô˷���
	protected synchronized Runnable getTask() throws InterruptedException {
		while (workQueue.size() == 0) {
			if (isClosed)
				return null;
			wait();// �����������û������ �͵ȴ�����
		}
		return workQueue.removeFirst();
	}

	// �ر��̳߳�
	public synchronized void close() {
		if (!isClosed) {
			isClosed = true;
			workQueue.clear();// �����̶߳���
			interrupt();
		}
	}

	// �ȴ������̰߳���������ִ����
	public void join() {
		synchronized (this) {
			isClosed = true;
			notify();// ���ѻ���getTask���������еȴ�����Ĺ����߳�
		}
		Thread[] threads = new Thread[activeCount()];
		// enumerate�����̳���ThreadGroup �࣬����߳����е�ǰ���ŵ������߳�

		int count = enumerate(threads);
		for (int i = 0; i < count; i++) {// �ȴ����еĹ����߳����н���
			try {
				threads[i].join();
			} catch (InterruptedException e) {
			}
		}
	}

	// �ڲ��� �����߳�
	private class WorkThread extends Thread {
		public WorkThread() {
			// ���뵽��ǰThreadPool�߳�����
			super(ThreadPool.this, "WorkThread-" + (threadID++));
		}

		public void run() {
			while (!isInterrupted()) {// �ж��߳��Ƿ��ж�
				Runnable task = null;
				try {// ȡ������
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
