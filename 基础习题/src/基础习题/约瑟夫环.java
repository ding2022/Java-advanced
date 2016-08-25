package 基础习题;

import java.util.Iterator;
import java.util.LinkedList;
//采用迭代器   将数到10 的人 移除迭代器  用链表实现
public class 约瑟夫环 {
	public static void main(String[] args) {
		LinkedList<Integer> lucky = new LinkedList<Integer>();

		int num, cnt;// num为报数的周期 cnt为当前剩下的人

		for (num = 1; num <= 100; num++)
			// 全部编号
			lucky.addLast(num);
		System.out.println(lucky);
		cnt = 100;
		num = 0;
		Iterator<Integer> it = lucky.iterator();
		// 循环删除退出的人
		while (cnt > 1) {
			if (it.hasNext()) {// 没有到末尾
				it.next();
				++num;
			} else {
				it = lucky.iterator();
				System.out.println(lucky);
			}

			if (num == 10) { //数到 10 了   一个循环结束了
				num = 0;
				it.remove();
				--cnt;
			}
		}
		System.out.println(lucky.element());
	}
}
