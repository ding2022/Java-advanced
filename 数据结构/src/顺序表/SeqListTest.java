package 顺序表;

import java.util.Arrays;

public class SeqListTest {
	final int defaultSize=10;//初始长度为10
	
	int maxSize;//线性表的最大长度
	int size;	//线性表当前大小
	
	Object[] listArray;
	
	public SeqListTest(){ //构造方法里面初始化线性表
		initiate(defaultSize); //创建线性表函数
	}
	
	private void initiate(int sz){ 
		maxSize=sz;
		size=0;
		listArray=new Object[sz];
	}
	
	public void insert(int i,Object obj) throws Exception{
		if(size==maxSize){
			throw new Exception("顺序表已满");
		}
		if(i<0||i>size){
			throw new Exception("参数错误");
		}
		
		for(int j=size;j>i;j--){   //移动元素
			listArray[j]=listArray[j-1];
		}
		
		listArray[i]=obj;
		size++;
	}
	
	public Object delete(int i)throws Exception{
		if(size==0){
			throw new Exception("顺序表已空 无法删除");
		}
		if(i<0||i>size){
			throw new Exception("参数错误");
		}
		
		Object it=listArray[i];
		
		for(int j=i;j<size-1;j++){
			listArray[j]=listArray[j+1];
		}
		
		size--;
		return it;
	}
	
	public Object getDate(int i)throws Exception {
		if(i<0||i>=size){
			throw new Exception("参数有误");
		}
		return listArray[i];
	}
	public int size(){
		return size;
	}
	
	public boolean isEmpty(){
		return size==0;
	}
	
	public int MoreDateDelete(SeqListTest L,Object x)throws Exception{
		int i;
		int tag=0;
		
		for(i=0;i<L.size;i++){
			if(x.equals(L.getDate(i))){
				L.delete(i);
				i--;
				tag=1;
			}
		}
		return tag;
	}
	public static void main(String[] args) throws Exception {
		SeqListTest L=new SeqListTest();
		for(int i=0;i<10;i++)
			L.insert(i, i);
		L.delete(5);
		System.out.println(L.getDate(5));
		System.out.println(Arrays.asList(L.listArray));
	}
}
