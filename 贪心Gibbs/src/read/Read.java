package read;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Read {

	public static void main(String[] args) throws IOException, InterruptedException {
		try{
		
			FileReader reader=new FileReader("sequences.txt");
			BufferedReader br=new BufferedReader(reader);
			
			String str=null;
			str=br.readLine();
			while(str!= null){
				//System.out.println(str+"\n\n");
				//System.out.println(str.length());
				
				//String pipei=null;
				//new Thread().sleep(10000);
				result(str);
				
			}
		}catch(FileNotFoundException e){
			System.out.println("文件未找到！");
		}
	}
	public static int match(String input,String sub){
		int num=0;
		for(int i=0;i<input.length()-1;i++){
			if(input.regionMatches(false, i, sub, 0, 30)){
				num++;
			}
		}
		return num;
	}
	public static void result(String input){
		int num=0;
		HashMap<String, Integer> map=new HashMap<String, Integer>();
		
		for(int i=0;i<input.length()-29;i++){
			String sub = input.substring(i, i+30);
			num=match(input, sub);
			
			if(num>1){
				map.put(sub, num);
				System.out.println(sub+" 字符串个数为： "+num);
			}
		}
	}
}
