package ����_����_����;
//Vector �����࣬����������Ĺ��� �ܹ��Զ���������ĳ��� �����ݽṹ������ ���䳤�ȳ������ֵʱ  ����һ���µ����� ����Ϊ2������� ��ֵ��������
import java.util.Vector;

public class Matrix_JuZhen {
	private Vector<Object> values;//�����е�Ԫ��
	private int h;
	private int w;
	
	public Matrix_JuZhen(int h,int w){//����һ���վ���
		if(h<=0||w<=0){
			throw new ArrayIndexOutOfBoundsException("h or w <"+1);
		}
		
		values=new Vector<Object>(h); //������h�еĶ���
		
		for (int i = 0; i < h; i++) {//ѭ����ÿ��row���� ������values����
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