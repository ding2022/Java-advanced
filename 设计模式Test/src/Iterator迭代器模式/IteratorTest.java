package Iterator迭代器模式;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//迭代器(Iterator)是一种类似于c语言中指针的设计模式，是一个对象，利用next（），hasNext（）和remove（）3个方法来遍历并选择序列中的对象
public class IteratorTest {
	public static void main(String[] args) {
		addFood();
	}

	private static void addFood() {
		List<Object> list = new ArrayList<Object>(5);
		list.add("bread");
		list.add("milk");
		list.add("fries");
		list.add("xiangchang");
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object obj = iterator.next();
			System.out.print(obj+"\t");
			if ("xiangchang".equals(obj))
				iterator.remove();
		}
		for (Iterator iterator = list.iterator(); iterator.hasNext();) {
			Object obj = iterator.next();
			System.out.print(obj+"\t");
			if ("xiangchang".equals(obj))
				iterator.remove();
		}
	}
}
