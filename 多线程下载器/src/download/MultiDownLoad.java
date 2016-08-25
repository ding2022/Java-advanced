package download;
//根据下载文件信息 创建下载线程
public class MultiDownLoad {
	private DownLoadInfo myDownInfo;
	private DownLoadThread[] down;
	
	public MultiDownLoad(DownLoadInfo mydowninfo){
		this.myDownInfo=mydowninfo;
	}
	//创建下载线程
	private void startDownFile(){
		//开始下载
		down=new DownLoadThread[myDownInfo.getThreadNUm()];
		for(int i=0;i<down.length;i++){
			down[i]=new DownLoadThread(myDownInfo, i);
			down[i].setPriority(7);
			down[i].start();
		}
	}
	
	//调度多线程下载
	public void MultiDown() {
		startDownFile();
		new ListenThread(myDownInfo, down);
	}

}
