package ������;

public class ClientChainOfRespon {
	public static void main(String[] args) {
		Leader a = new Director("����");
		Leader b = new Manager("����");
		Leader c = new GeneralManager("����");

		// ��֯��������

		a.setNextLeader(b);
		b.setNextLeader(c);

		LeaveRequest request = new LeaveRequest("�Ƹ�", 10, "��");
		a.handleRequest(request);
	}
}
