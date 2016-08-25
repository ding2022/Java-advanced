package 哈希表;

//哈希表类
public class HashTableTest {
	private HashItem[] ht; // 哈希表数组
	private int tableSize; // 哈希表长度
	private int currentSize; // 当前的表项个数

	HashTableTest(int m) {
		tableSize = m;
		ht = new HashItem[tableSize];
		currentSize = 0;
	}

	public boolean isIn(int x) {// x是否已经存在
		int i = find(x);
		if (i >= 0)
			return true;
		else {
			return false;
		}
	}

	public int getValue(int i) {// 取数据元素值
		return ht[i].data;
	}

	public int find(int x) {// 查找
		int i = x % tableSize;
		int j = i;

		if (ht[j] == null)
			ht[j] = new HashItem(0);
		while (ht[j].info == 1 && ht[j].data != x) {// 存在冲突
			j = (j + 1) % tableSize;
			if (j == i)
				return -tableSize;
		}
		if (ht[j].info == 1)
			return j;
		else {
			return -j;
		}
	}

	public void insert(int x) throws Exception {
		int i = find(x);

		if (i > 0) {
			throw new Exception();
		} else if (i != -tableSize) {
			ht[-i] = new HashItem(x, 1);
			currentSize++;
		} else {
			throw new Exception();
		}
	}

	public void delete(int x) throws Exception {
		int i = find(x);

		if (i >= 0) {
			ht[i].info = 0;
			currentSize--;
		} else {
			throw new Exception();
		}
	}
}
