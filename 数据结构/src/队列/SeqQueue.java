package ����;
//ѭ������
import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class SeqQueue implements Queue<Object>{

	//�Զ���
	static final int defauleSize=10;
	
	int front;//��ͷ
	int rear;//��β
	int count;
	int maxsize;
	Object[] data;
	
	public SeqQueue(){
		initiate(defauleSize);
	}
	public SeqQueue(int sz){
		initiate(sz);
	}
	private void initiate(int sz){
		maxsize=sz;
		front=rear=0;
		count=0;
		data=new Object[sz];
	}
	
	public void append(Object obj)throws Exception{
		if(count>0&&front==rear){
			throw new Exception("��������");
		}
		
		data[rear]=obj;
		rear=(rear+1)%maxsize;	//��1 ����ģ ��Ϊѭ������ ˵��ѭ����
		count++;
	}
	public Object delete()throws Exception{
		if(count==0){
			throw new Exception("�����ѿ�");
		}
		Object tmp=data[front];
		front=(front+1)%maxsize;
		count--;
		return tmp;
	}
	
	
	//
	@Override
	public int size() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean contains(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Iterator<Object> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object[] toArray() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T[] toArray(T[] a) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean remove(Object o) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean containsAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean addAll(Collection<? extends Object> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean retainAll(Collection<?> c) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean add(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean offer(Object e) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Object remove() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object poll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object element() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object peek() {
		// TODO Auto-generated method stub
		return null;
	}

}
