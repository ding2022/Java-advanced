public class T237 {
	public static void main(String[] args) {

	}
}

class ListNode {
	int val;
	ListNode next;
	ListNode(int x) {
		val = x;
	}
}
class Solution {
    public void deleteNode(ListNode node) {
        ListNode p = null;
        while(p!=node){
        	p=p.next;
        }
        p.next=p.next.next;
    }
}
