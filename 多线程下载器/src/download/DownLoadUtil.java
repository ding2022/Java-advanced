package download;

import java.io.IOException;
import java.io.Serializable;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import javax.net.ssl.HttpsURLConnection;

public class DownLoadUtil {
	public static TestResult TestURL(String tmp){
		TestResult r=new TestResult();
		URL tmp_Url;
		try{
			tmp_Url=new URL(tmp);
			//建立url连接
			HttpsURLConnection http=(HttpsURLConnection)tmp_Url.openConnection();
			//判断返回的url连接码
			if(http.getResponseCode()>=400){
				System.out.println("资源["+tmp_Url+"]服务器响应错误！");
				r.myUrl=null;
				r.myResult=-1;
				return r;
			}else {
				System.out.println("资源["+tmp_Url+"]连接成功！");
				r.myUrl=tmp_Url;
				r.myResult=1;
				r.fileLength=http.getContentLength();
				if(r.fileLength==-1){
					System.out.println("资源["+tmp_Url+"]无法获知文件长度！");
				}else {
					System.out.println("资源["+tmp_Url+"]文件大小为"+
				Math.round(r.fileLength/1024*100)/100.0+"k。");
				}
				//获取文件名
				r.filename=getFileName(http);
				r.http_MIME=getMIME(http);
				return r;
			}
		}catch(MalformedURLException el){
			System.out.println("资源["+tmp+"]格式错误！");
			r.myUrl=null;
			r.myResult=-2;
			return r;
		}catch ( IOException e2) {
			System.out.println("资源["+tmp+"]连接错误！");
			r.myResult=-3;
			r.myUrl=null;
			return r;
		}
		
	}

	private static HashMap<String, String> getMIME(HttpsURLConnection http) {
		//构造泛型的哈希表用来存放连接的mime信息
		HashMap<String, String>http_MIME=new HashMap<String, String>();
		//循环遍历mime信息 将其放入哈希表中
		for(int i = 0;;i++){
			String mine= http.getHeaderField(i);
			if(mine==null){
				break;
			}
			http_MIME.put(http.getHeaderFieldKey(i), http.getHeaderField(i));
		}
		return http_MIME;
	}

	private static String getFileName(HttpsURLConnection http) {
		String filename =http.getURL().getFile();
		return filename;
	}
}
class TestResult implements Serializable{
	public URL myUrl;
	public int myResult;
	public int fileLength;
	public String filename;
	//使用泛型声明hashmap 对象
	public HashMap<String, String> http_MIME;
}