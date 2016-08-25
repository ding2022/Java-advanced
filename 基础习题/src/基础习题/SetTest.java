package »ù´¡Ï°Ìâ;

import java.util.*;

public class SetTest {
	public static void main(String[] args) {
		fangfa2();
	}

	private static void fangfa2() {
		Random random =new Random(47);
		Set<Integer> inSet=new HashSet<Integer>();
		for(int i=0;i<10000;i++)
			inSet.add(random.nextInt(30));
		System.out.println(inSet);
		Integer [] a={9,7,9,1,2,5,10,5,1234};
		
		TreeSet<Integer> treeSet=new TreeSet<Integer>();
		treeSet.addAll(Arrays.asList(a));
		System.out.println(a);
		System.out.println(treeSet);
	}
}
