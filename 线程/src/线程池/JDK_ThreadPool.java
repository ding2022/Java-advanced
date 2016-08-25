package 线程池;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//executorService jdk 自带的线程池类  有四种线程池类型 分别对应四个不同方法
/*
 * newCachedThreadPool() 在有任务时才创建新线程  空闲线程被保留60秒
 * newFixedThreadPool(int n) 线程池中包含固定数目的线程 空闲线程会一直保留。参数n为线程池中现成的数目
 * newSingleThreadExecutor()  线程池中只有一个工作线程 它依次执行每个任务
 * newScheduledThreadPool(int n) 线程池按照时间计划来执行任务
 * newSingleThreadedExecutor  线程池中只有一个工作线程 它能按照时间计划来执行任务
 * 
 * 需要注意的问题  死锁 系统资源不足  并发错误 线程泄露 任务过载 
 */
public class JDK_ThreadPool {
	private int port=8000;
	private ServerSocket serverSocket;
	
	private ExecutorService executorService;//jdk 自带的线程池
	private final int POOL_SIZE=4;//单个CPU时线程池中的工作线程的数目
	
	public JDK_ThreadPool()throws IOException{
		serverSocket=new ServerSocket(port);
		
		//runntime的availableProcess()方法返回当前系统的cpu数目
		//系统的CPU越多，线程池中工作线程的数目越多
		executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
		
		System.out.println("服务器启动");
	}
	public void service(){
		while(true){
			Socket socket=null;
			try{
				socket =serverSocket.accept();
				executorService.execute(new Handler(socket));
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	
	public static void main(String[] args)throws IOException {
		new JDK_ThreadPool().service();
	}
	
	class Handler implements Runnable{

		@Override
		public void run() {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("start");
		}
		Handler(Socket s){
		}
	}
}
