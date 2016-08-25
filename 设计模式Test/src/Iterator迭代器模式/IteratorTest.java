package Iterator������ģʽ;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

//������(Iterator)��һ��������c������ָ������ģʽ����һ����������next������hasNext������remove����3��������������ѡ�������еĶ���
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
