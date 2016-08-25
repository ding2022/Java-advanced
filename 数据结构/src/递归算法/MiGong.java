package �ݹ��㷨;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class MiGong {

	int mazeSize; //·�ڸ���
	InterSection[] intSec;
	int exit;
	
	public MiGong(String filename) {
		String line;
		Integer temp;
		
		try{
			BufferedReader in=new BufferedReader(new FileReader(filename));
			
			line=in.readLine();
			
			mazeSize=Integer.parseInt(line.trim());
			
			intSec=new InterSection[mazeSize+1]; //��������
			
			for(int i=1;i<mazeSize;i++){
				line=in.readLine();
				StringTokenizer tokenizer=new StringTokenizer(line);
				
				InterSection curr=new InterSection();
				curr.left=Integer.parseInt(tokenizer.nextToken());
				//
				curr.forward=Integer.parseInt(tokenizer.nextToken());
				curr.right=Integer.parseInt(tokenizer.nextToken());
				
				intSec[i]=curr;//����ֵ
			}
			exit=Integer.parseInt(in.readLine());//��ȡ�ļ����һ�� ��ʾ���ڴ�
			in.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	public boolean travelMaze(int intSecValue){
		//�û��ݷ������Թ������з�֧��intSecValueΪ��ǰ����·�ں�
		//������������ʱ����1
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
class InterSection{//·����  �ĸ���Ϊ0 ��ʾ�ĸ�������ͨ
	int left;
	int forward;
	int right;
}