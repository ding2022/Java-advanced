package ����ģʽ;

//ָ�������������ʱ��ʹ�õ�һ�ֹ���ģʽ �빤������ģʽ�����ͬ  4����󹤳���ɫ�����幤����ɫ�������Ʒ��ɫ�������Ʒ��ɫ �ϸ��Ӷ���
public class ���󹤳�ģʽ {
	public static void main(String[] args) {
		PropBook book1 = showBook.getPropBook("lala");
		System.out.println(book1.getAuthor().getName() + " "
				+ book1.getBookName().getName() + " "
				+ book1.getPrice().getName());
	}
}

class book {
	String name;

	public book(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

abstract class PropBook {
	public abstract book getAuthor();

	public abstract book getPrice();

	public abstract book getBookName();
}

class computer extends PropBook {
	@Override
	public book getAuthor() {
		return new book("zhang3");
	}

	@Override
	public book getPrice() {
		return new book("100");
	}

	@Override
	public book getBookName() {
		return new book("jisuanji");
	}
}

class showBook {
	private static PropBook po;

	public static PropBook getPropBook(String type) {
		po = new computer();
		if (type.equals("other")) {
			return null;
		}
		return po;
	}
}