package ��ָoffer;

/**
 * ��Ŀ����
 * 
 * ���������������������������������ϳɺ��������Ȼ������Ҫ�ϳɺ���������㵥����������
 * 
 * @author feng
 *
 */
public class Solve {
	public ListNode Merge(ListNode list1, ListNode list2) {
		ListNode list = null;
		if(list1==null){
			return list2;
		}else if(list2==null){
			return list1;
		}else if(list1.val<list2.val){
			list=list1;
			list.next=Merge(list1.next, list2);
		}else {
			list=list2;
			list.next=Merge(list1, list2.next);
		}
		return list;
		/*while(list1.next!=null&&list2.next!=null)
		if(list1.val>=list2.val){
			list.next.val=list2.val;
			list2=list2.next;
		}else {
			list.next.val=list1.val;
			list1=list2.next;
		}
		return list;*/
	}
	public static void main(String[] args) {
		ListNode list1=new ListNode(1);
//		list1.next;
	}
}

class ListNode {
	int val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}