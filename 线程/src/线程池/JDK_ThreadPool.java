package �̳߳�;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


//executorService jdk �Դ����̳߳���  �������̳߳����� �ֱ��Ӧ�ĸ���ͬ����
/*
 * newCachedThreadPool() ��������ʱ�Ŵ������߳�  �����̱߳�����60��
 * newFixedThreadPool(int n) �̳߳��а����̶���Ŀ���߳� �����̻߳�һֱ����������nΪ�̳߳����ֳɵ���Ŀ
 * newSingleThreadExecutor()  �̳߳���ֻ��һ�������߳� ������ִ��ÿ������
 * newScheduledThreadPool(int n) �̳߳ذ���ʱ��ƻ���ִ������
 * newSingleThreadedExecutor  �̳߳���ֻ��һ�������߳� ���ܰ���ʱ��ƻ���ִ������
 * 
 * ��Ҫע�������  ���� ϵͳ��Դ����  �������� �߳�й¶ ������� 
 */
public class JDK_ThreadPool {
	private int port=8000;
	private ServerSocket serverSocket;
	
	private ExecutorService executorService;//jdk �Դ����̳߳�
	private final int POOL_SIZE=4;//����CPUʱ�̳߳��еĹ����̵߳���Ŀ
	
	public JDK_ThreadPool()throws IOException{
		serverSocket=new ServerSocket(port);
		
		//runntime��availableProcess()�������ص�ǰϵͳ��cpu��Ŀ
		//ϵͳ��CPUԽ�࣬�̳߳��й����̵߳���ĿԽ��
		executorService=Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors()*POOL_SIZE);
		
		System.out.println("����������");
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
