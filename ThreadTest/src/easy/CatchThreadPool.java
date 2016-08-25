package easy;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CatchThreadPool {

	public static void main(String[] args) {
		//ExecutorService exec=Executors.newCachedThreadPool();
		//划分数量
		ExecutorService exec=Executors.newFixedThreadPool(5);
		for(int i=0;i<5;i++){
			exec.execute(new LiftOff());
			exec.shutdown();//可以防止新任务被交给exectors
		}
	}

}
