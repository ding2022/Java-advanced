package 数组_集合_矩阵;
//Vector 向量类，扩充了数组的功能 能够自动扩充数组的长度 在数据结构构成里 当其长度超过最大值时  创建一个新的数组 长度为2倍或更大 赋值给新数组
import java.util.Vector;

public class Matrix_JuZhen {
	private Vector<Object> values;//矩阵中的元素
	private int h;
	private int w;
	
	public Matrix_JuZhen(int h,int w){//构造一个空矩阵
		if(h<=0||w<=0){
			throw new ArrayIndexOutOfBoundsException("h or w <"+1);
		}
		
		values=new Vector<Object>(h); //创建有h行的对象
		
		for (int i = 0; i < h; i++) {//循环把每个row数组 付给行values数组
			Vector<Object> row=new Vector<Object>(w);
			values.add(row);
			for(int j=0;j<w;j++){
				row.add(null);
			}
		}
		this.h=h;
		this.w=w;
	}
	public void set(int row,int col,Object value) {
		if(row<0||w<0||row>=h||col>=w){
			throw new ArrayIndexOutOfBoundsException("h or w <"+"-1");
		}
		Vector<Object> selrow=(Vector<Object>) values.get(row);
		selrow.set(col,value);
	}
	public Object get(int row ,int col){
		if(row<0||w<0||row>=h||col>=w){
			throw new ArrayIndexOutOfBoundsException("h or w <"+"-1");
		}
		Vector<Object> selrow=(Vector<Object>) values.get(row);
		return selrow.get(col);
	}
	
}