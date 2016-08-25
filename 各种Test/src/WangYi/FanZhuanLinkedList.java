package WangYi;

import java.util.Scanner;

public class FanZhuanLinkedList {
	public static void main(String[] args) {
		ListNode head=new ListNode(0);
		ListNode pp=head;
		Scanner in=new Scanner(System.in);
		while(in.hasNext()){
			for(int i=0;i<4;i++){
				pp.val=in.nextLine();
				pp=pp.next;
			}
			ReverseList(head);
			for(int i=0;i<4;i++){
				System.out.println(head.val);
				head=head.next;
			}
		}
	}
	public static ListNode ReverseList(ListNode head) {
		ListNode p1, p2, p3;
		if (head == null || head.next == null) {
			return head;
		}
		p1 = head;
		p2 = head.next;
		while (p2 != null) {
			p3 = p2.next;
			p2.next = p1;
			p1 = p2;
			p2 = p3;
		}
		head.next = null;
		head = p1;
		return head;
	}
}

class ListNode {
	Object val;
	ListNode next = null;

	ListNode(int val) {
		this.val = val;
	}
}