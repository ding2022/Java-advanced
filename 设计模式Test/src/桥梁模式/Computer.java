package 桥梁模式;
/**
 * 传统方法 处理多层次继承关系的时候 会很麻烦  在每一级做改动时 都要同时改动很多类
 * 桥梁模式 是为解决多层继承结构而做的 
 * 适用的场景是 多种变化的维度 将各个维度设计成独立的继承结构 
 * 使各个维度可以独立的扩展在抽象层建立关联
 * 
 * 使用组合的方式 使得不同维度联系起来 维度各自的变化互不影响 独立变化 
 * 方便了后期的扩展
 * @author feng
 *
 */
public interface Computer {
	void sale();
}

class Desktop implements Computer {

	@Override
	public void sale() {
		System.out.println("销售台式机");
	}
}

class Laptop implements Computer {

	@Override
	public void sale() {
		System.out.println("销售笔记本");
	}

}

class Pad implements Computer {

	@Override
	public void sale() {
		System.out.println("销售平板电脑");
	}

}

class LenovoDesktop extends Desktop {
	@Override
	public void sale() {
		System.out.println("销售联想台式电脑");
	}
}

class LenovoLaptop extends Laptop {
	@Override
	public void sale() {
		System.out.println("销售联想笔记本");
	}
}

class LenovoPad extends Pad {
	@Override
	public void sale() {
		System.out.println("销售联想平板");
	}
}

class ShenzhouDesktop extends Desktop {
	@Override
	public void sale() {
		System.out.println("销售神州台式电脑");
	}
}

class ShenzhouLaptop extends Laptop {
	@Override
	public void sale() {
		System.out.println("销售神州笔记本");
	}
}

class ShenzhouPad extends Pad {
	@Override
	public void sale() {
		System.out.println("销售神州平板");
	}
}

class DellDesktop extends Desktop {
	@Override
	public void sale() {
		System.out.println("销售戴尔台式电脑");
	}
}

class DellLaptop extends Laptop {
	@Override
	public void sale() {
		System.out.println("销售戴尔笔记本");
	}
}

class DellPad extends Pad {
	@Override
	public void sale() {
		System.out.println("销售戴尔平板");
	}
}