package ԭ��ģʽ;

//����¡���� ����̳� Cloneable�ӿ� 
public class prototypeTest implements Cloneable {

	private String Name;
	private String age;
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		Object obj=super.clone();  //�˴�ʵ���˿�¡ �����ȥԴ����Է�������һ�� native���� ��object���У���ֱ�Ӻͺ���c++�򽻵���
		//�ڴ����Ч�ʷǳ���  �Դ���� ģʽ�ĸ���Ч�ʷǳ��� 
		return obj;
	}
	
	public prototypeTest(String name,String age) {
		this.age=age;
		this.Name=name;
	}
	public prototypeTest() {
	}
}
