package 递归算法;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class MiGong {

	int mazeSize; //路口个数
	InterSection[] intSec;
	int exit;
	
	public MiGong(String filename) {
		String line;
		Integer temp;
		
		try{
			BufferedReader in=new BufferedReader(new FileReader(filename));
			
			line=in.readLine();
			
			mazeSize=Integer.parseInt(line.trim());
			
			intSec=new InterSection[mazeSize+1]; //创建对象
			
			for(int i=1;i<mazeSize;i++){
				line=in.readLine();
				StringTokenizer tokenizer=new StringTokenizer(line);
				
				InterSection curr=new InterSection();
				curr.left=Integer.parseInt(tokenizer.nextToken());
				//
				curr.forward=Integer.parseInt(tokenizer.nextToken());
				curr.right=Integer.parseInt(tokenizer.nextToken());
				
				intSec[i]=curr;//对象赋值
			}
			exit=Integer.parseInt(in.readLine());//读取文件最后一行 表示出口处
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean travelMaze(int intSecValue){
		//用回溯法搜索迷宫的所有分支，intSecValue为当前所处路口号
		//当搜索到出口时返回1
		if(intSecValue>0){
			if(intSecValue==exit){
				System.out.println(intSecValue+"<==");
				return true;
			}
			
			else if (travelMaze(intSec[intSecValue].left)) {
				System.out.println(intSecValue+"<==");
				return true;
			}
			
			else if(travelMaze(intSec[intSecValue].forward)){
				System.out.println(intSecValue+"<==");
				return true;
			}
			
			else if(travelMaze(intSec[intSecValue].right)){
				System.out.println(intSecValue+"<==");
				return true;
			}
		}
		return false;
	}
}
class InterSection{//路口类  哪个不为0 表示哪个可以走通
	int left;
	int forward;
	int right;
}