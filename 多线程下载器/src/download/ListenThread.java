package download;

import java.util.Timer;
import java.util.TimerTask;
//创建线程监听类
public class ListenThread {
	private DownLoadInfo downLoadInfo;
	private Timer tmr;
	private boolean isFinished;
	private boolean isError;
	private DownLoadThread[] down;
	
	public ListenThread(DownLoadInfo downLoadInfo,DownLoadThread[] downLoadThread) {
		this.downLoadInfo=downLoadInfo;
		this.down=downLoadThread;
		tmr=new Timer();
		tmr.schedule(new MyTimerTask(),0,1000);
	}
	
	//监听线程是否结束
	final private void listenFinished(){
		boolean flag=true;
		for(int i=0;i<down.length;i++){
			if(down[i].isFinished()==false){
				flag=false;
			}
			if (down[i].isError()==true) {
				isError=true;
				break;
			}
		}
		isFinished=flag;
	}


   class MyTimerTask extends TimerTask{
	public void run() {
		//获取线程状态信息
		listenFinished();
		if(isFinished){
			tmr.cancel();
			downLoadInfo.setFinished(true);
			System.out.println("资源["+downLoadInfo.getDownURL()+"]下载完毕！，文件保存在"+
			downLoadInfo.getSaveFileName());
		}else {
			if(isError){
				tmr.cancel();
				downLoadInfo.setErr(true);
				System.out.println("资源["+downLoadInfo.getDownURL()+"]下载错误！");
			}else {
				downLoadInfo.setDownSpeed();
				System.out.println("资源["+downLoadInfo.getDownURL()+"]文件长度="+
				downLoadInfo.getSaveFileName()+"byte 已下载长度="+downLoadInfo.getDownLength()
				+"byte 下载速度="+downLoadInfo.getDownSpeed()+"k 下载进度="
				+downLoadInfo.getDownProgress());
			}
		}
	}
	}
}