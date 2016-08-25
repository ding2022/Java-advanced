package download;
/*下载任务实体类是用来抽象描述实际下载任务的
*/
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.io.Serializable;
import java.util.HashMap;

public class DownLoadInfo implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String saveFileName;//下载文件名
	private String downURL;//下载文件资源名称
	private TestResult tr;//资源链接结果
	private int threadNum;//线程数目
	private boolean isValidate;//该下载信息是否有效
	private long perdownLength;//上次文件下载长度
	private long downLength;//当前已下载长度
	private float downSpeed;//下载速度
	private long[][] downPos;//各个线程下载指针
	private boolean finished;//下载完成标志
	private boolean err;//下载错误
	
	public DownLoadInfo(String urlStr,String saveFileName,int num){
		tr=DownLoadUtil.TestURL(urlStr);
		if((tr.myResult==1)&&(tr.fileLength>0)&&setSaveFile(saveFileName)){
			downURL=urlStr;
			isValidate=true;
			setThreadNum(3);
			setDownPos();
		}else {
			isValidate=false;
		}
	}
	public HashMap<String, String> getMIME() {//获取资源链接的mime信息
		return tr.http_MIME;
	}
	public long getDownLength() {
		return downLength;
	}
	public void setDownLength(long len) {
		downLength = downLength+len;
	}
	public float getDownSpeed() {
		return downSpeed;
	}
	public void setDownSpeed() {//计算文件下载速度
		downSpeed = (downLength-perdownLength)/1024.0f;
		perdownLength=downLength;
		downSpeed=Math.round(downSpeed*100)/100.0f;
	}
	public int getDownProgress() {//获取文件下载进度
		return Math.round(100.0f*this.getDownLength()/this.getDownLength());
	}
	public boolean isFinished() {
		return finished;
	}
	public void setFinished(boolean finished) {
		this.finished = finished;
	}
	public boolean isErr() {
		return err;
	}
	public void setErr(boolean err) {
		this.err = err;
	}
	public String getDownURL(){//获得下载资源名词
		return downURL;
	}

	public boolean getIsValidate() {
		return isValidate;
	}
	public String toString() {
		return saveFileName;
	}
	public long[][] getDownPos() {
		return downPos;
	}
	private void setDownPos() {//设置文件线程下载进度信息
		downPos =new long[threadNum][2];
		long len =tr.fileLength;
		long block=(len/threadNum+1);
		for(int i=0;i<threadNum;i++){
			len=len-block;
			downPos[i][0]=i*block;
			downPos[i][1]=block;
			if(len<0)
				downPos[i][1]=block+len;
		}
	}

	public int getThreadNUm(){
		return threadNum;
	}
	private void setThreadNum(int num) {
		if(!isValidate){
			return;
		}
		if(tr.filename.equals("")){
			threadNum=1;
			return;
		}
		if(num<=0||num>10){
			threadNum=3;
		}else {
			threadNum=3;
		}
	}

	public String getSaveFileName() {
		return saveFileName;
	}
	private boolean setSaveFile(String saveFileName2) {//设置文件名称
		File tmp_File=new File(saveFileName2);
		try{
			RandomAccessFile out =new RandomAccessFile(tmp_File, "rw");
			out.setLength(tr.fileLength);
			out.close();
			this.saveFileName=saveFileName2;
			return true;
		}catch(IOException e){
			return false;
		}
	}
	
}
