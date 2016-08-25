package ����ģʽ;
/**
 * ��ͳ���� ������μ̳й�ϵ��ʱ�� ����鷳  ��ÿһ�����Ķ�ʱ ��Ҫͬʱ�Ķ��ܶ���
 * ����ģʽ ��Ϊ������̳нṹ������ 
 * ���õĳ����� ���ֱ仯��ά�� ������ά����Ƴɶ����ļ̳нṹ 
 * ʹ����ά�ȿ��Զ�������չ�ڳ���㽨������
 * 
 * ʹ����ϵķ�ʽ ʹ�ò�ͬά����ϵ���� ά�ȸ��Եı仯����Ӱ�� �����仯 
 * �����˺��ڵ���չ
 * @author feng
 *
 */
public interface Computer {
	void sale();
}

class Desktop implements Computer {

	@Override
	public void sale() {
		System.out.println("����̨ʽ��");
	}
}

class Laptop implements Computer {

	@Override
	public void sale() {
		System.out.println("���۱ʼǱ�");
	}

}

class Pad implements Computer {

	@Override
	public void sale() {
		System.out.println("����ƽ�����");
	}

}

class LenovoDesktop extends Desktop {
	@Override
	public void sale() {
		System.out.println("��������̨ʽ����");
	}
}

class LenovoLaptop extends Laptop {
	@Override
	public void sale() {
		System.out.println("��������ʼǱ�");
	}
}

class LenovoPad extends Pad {
	@Override
	public void sale() {
		System.out.println("��������ƽ��");
	}
}

class ShenzhouDesktop extends Desktop {
	@Override
	public void sale() {
		System.out.println("��������̨ʽ����");
	}
}

class ShenzhouLaptop extends Laptop {
	@Override
	public void sale() {
		System.out.println("�������ݱʼǱ�");
	}
}

class ShenzhouPad extends Pad {
	@Override
	public void sale() {
		System.out.println("��������ƽ��");
	}
}

class DellDesktop extends Desktop {
	@Override
	public void sale() {
		System.out.println("���۴���̨ʽ����");
	}
}

class DellLaptop extends Laptop {
	@Override
	public void sale() {
		System.out.println("���۴����ʼǱ�");
	}
}

class DellPad extends Pad {
	@Override
	public void sale() {
		System.out.println("���۴���ƽ��");
	}
}