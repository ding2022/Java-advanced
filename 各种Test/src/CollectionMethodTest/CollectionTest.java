package CollectionMethodTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionTest {
	static List<String> list=Arrays.asList(
			"one two three four five six one".split(" "));
	public static void main(String[] args) {
		System.out.println(list);
		
		System.out.println("disjoint  :" + Collections.disjoint(list, Collections.singletonList("four")));//�Ƿ���� four
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println("max "+ Collections.max(list));
		
		System.out.println("min "+ Collections.min(list));
		
		System.out.println("indexofsublist "+ Collections.indexOfSubList(list, Arrays.asList("four")));
		
		Collections.reverse(list);//��תlist�е�Ԫ��
		System.out.println("reverse "+ list);
		
		Collections.swap(list, 1, 2);//����list�е�Ԫ��λ�� Ч�ʽϸ�
		
		System.out.println(list);
	}
}
