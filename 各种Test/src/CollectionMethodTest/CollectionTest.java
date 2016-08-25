package CollectionMethodTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionTest {
	static List<String> list=Arrays.asList(
			"one two three four five six one".split(" "));
	public static void main(String[] args) {
		System.out.println(list);
		
		System.out.println("disjoint  :" + Collections.disjoint(list, Collections.singletonList("four")));//是否包含 four
		Collections.sort(list);
		System.out.println(list);
		
		System.out.println("max "+ Collections.max(list));
		
		System.out.println("min "+ Collections.min(list));
		
		System.out.println("indexofsublist "+ Collections.indexOfSubList(list, Arrays.asList("four")));
		
		Collections.reverse(list);//翻转list中的元素
		System.out.println("reverse "+ list);
		
		Collections.swap(list, 1, 2);//交换list中的元素位置 效率较高
		
		System.out.println(list);
	}
}
