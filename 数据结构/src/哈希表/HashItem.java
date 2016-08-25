package 哈希表;
//哈希表项类
public class HashItem {
	int data;	//数据元素
	int info;	//标志
	
	HashItem(int i){
		info=i;
	}
	HashItem(int d,int i){
		data=d;
		info=i;
	}
}
