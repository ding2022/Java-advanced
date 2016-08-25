package download;

import java.io.IOException;
import java.io.InputStream;
//线程下载类
import java.io.RandomAccessFile;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
public class DownLoadThread extends Thread{
	private InputStream in;//网络下载文件输入流
	private RandomAccessFile out;//下载文件输出流
	private URL downUrl;//下载url地址
	private long block;//每次下载剩余文件块
	private int threadId=-1;//线程ID号
	private boolean finished=false;//下载完成标志位
	private boolean err=false;//下载失败标志位
	private DownLoadInfo downInfo;//下载任务实体对象
	private long startP;//下载实体位置
	
	public DownLoadThread(DownLoadInfo downLoadInfo,int threadId){
		this.block=downLoadInfo.getDownPos()[threadId][1];
		this.threadId=threadId;
		this.downInfo=downLoadInfo;
		startP=downLoadInfo.getDownPos()[threadId][0];
	}
	
	public boolean isFinished() {
		return finished;
	}
	public boolean isError() {
		return err;
	}
	public void run(){
		HttpsURLConnection http;
		try{
			downUrl=new URL(downInfo.getDownURL());
			http=(HttpsURLConnection)downUrl.openConnection();
			String sProperty ="bytes="+startP+"-";
			http.setRequestProperty("Range", sProperty);
			in=http.getInputStream();
			out=new RandomAccessFile(downInfo.getSaveFileName(), "rw");
		}catch(IOException e){
			System.err.println("资源文件["+downInfo.getDownURL()+"]线程"+threadId+"报文申请错误！");
			err=true;
			return;
		}
		
		byte[] buffer=new byte[1024];//声明读、写流的字节缓冲数组
		int offset=0;
		long localSize=0;
		long step=0;
		try{
			//输出流跳过起始位置
			out.seek(startP);
			//判断剩余文件块的大小是否超过1024字节
			step=(block>1024)?1024:block;
			while((offset=in.read(buffer,0,(int)step))>0&&localSize<=block){
				//判断其他线程是否出错 如果出错 跳出循环 结束下载线程
				if(downInfo.isErr())break;
				out.write(buffer,0,offset);
				localSize+=offset;
				//修改文件下载线程进度信息
				{
					downInfo.getDownPos()[threadId][0]=startP+localSize;
					downInfo.getDownPos()[threadId][1]=block-localSize;
				}
				step=block-localSize;
				step=(step>1024)?1024:step;
				//更改文件下载长度
				downInfo.setDownLength(offset);
			}
			out.close();
			in.close();
			http.disconnect();
			if(!downInfo.isErr()){
				finished=true;
				System.out.println("资源文件["+downInfo.getDownURL()+"]线程"+threadId+"完成下载");
			}
		}catch(Exception e){
			System.out.println("资源文件["+downInfo.getDownURL()+"]线程"+threadId+"下载出错");
			err=true;
			finished=true;
			try {
				http.disconnect();
				in.close();
				out.close();
			} catch (Exception e2) {
			}
		}
		
	}
}
