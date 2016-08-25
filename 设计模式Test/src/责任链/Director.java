package ������;

/**
 * ��������
 * 
 * @author feng
 *
 */
public class Director extends Leader {

	public Director(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		// System.out.println();
		if (request.getLeaveDays() < 3) {
			System.out.println("Ա����" + request.getEmpName() + " ���\n������"
					+ request.getLeaveDays() + "\nԭ��" + request.getReason());
			System.out.println("���Σ�" + this.name + " ����ͨ��\n");
		} else {
			if (this.nextLeader != null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}
}
