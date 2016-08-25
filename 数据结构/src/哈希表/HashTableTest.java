package ��ϣ��;

//��ϣ����
public class HashTableTest {
	private HashItem[] ht; // ��ϣ������
	private int tableSize; // ��ϣ����
	private int currentSize; // ��ǰ�ı������

	HashTableTest(int m) {
		tableSize = m;
		ht = new HashItem[tableSize];
		currentSize = 0;
	}

	public boolean isIn(int x) {// x�Ƿ��Ѿ�����
		int i = find(x);
		if (i >= 0)
			return true;
		else {
			return false;
		}
	}

	public int getValue(int i) {// ȡ����Ԫ��ֵ
		return ht[i].data;
	}

	public int find(int x) {// ����
		int i = x % tableSize;
		int j = i;

		if (ht[j] == null)
			ht[j] = new HashItem(0);
		while (ht[j].info == 1 && ht[j].data != x) {// ���ڳ�ͻ
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
