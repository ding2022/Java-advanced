package ����ģʽ;
//����һ�����ṩ��������Ľӿ� �����������ʵ����һ������ ȥ���˼򵥹���ģʽ�й��������ľ�̬����
public class ��������ģʽ {
	public static void main(String[] args) {
		Forms forms=new shanxi();//�ڽӿ���������Ӧ��Լ�� ʵ���������� ����Ȼ��ϵ������
		meet meet1=forms.place();
		
		meet1.form();
	}
}
interface meet{
	public void form();
}
interface Forms{
	public meet place();
}
class jiudian implements meet{
	@Override
	public void form() {
		System.out.println("jiudian");
	}
}
class jia implements meet{
	@Override
	public void form() {
		System.out.println("jia ");
	}
}
class shanxi implements Forms{
	@Override
	public meet place() {
		return new jiudian();
	}
}
class weinan implements Forms{
	@Override
	public meet place() {
		// TODO Auto-generated method stub
		return new jia();
	}
}