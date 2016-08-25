package 基础习题;

import java.util.*;
public class MapTest {

	public static void main(String[] args) {
		Random random =new Random();//濡傛灉涓嶅～鏁板�肩殑璇� 榛樿浠ユ椂闂翠负绉嶅瓙
		Map<Integer, Integer> map=new HashMap<Integer, Integer>();
		for(int i=0;i<10000;i++){
			int r=random.nextInt(20);
			Integer freq=map.get(r);
			map.put(r, freq==null?1:freq+1);
		}
		System.out.println(map);
		Iterator iterator=map.keySet().iterator();
		while(iterator.hasNext()){
			Object keyObject=iterator.next();
			System.out.println(map.get(keyObject));
		}
	}
 class arralist implements Comparable<Object>{

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	 
 }
}
