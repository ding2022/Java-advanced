package Base;

import java.util.HashSet;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import java.util.TreeSet;

public class HashSetTest {

	public static void main(String[] args) {
		String str="gghgaifuerbbaaccddffee";
		char[] in = str.toCharArray();
		Set set=new HashSet<Character>();
		
		HashSet<Character> hashSet=new HashSet<Character>();
		
		SortedSet<Character> sortedSet=new TreeSet();
		
		//SortedMap<, >
		for(int i=0;i<in.length;i++){
			set.add(in[i]);
			hashSet.add(in[i]);
			sortedSet.add(in[i]);
			switch(in[i]){
			
			}
		}
		
		System.out.println(set);
		System.out.println(hashSet);
		System.out.println(sortedSet);
	}

}
