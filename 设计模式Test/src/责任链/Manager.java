package ������;

/**
 * ��������
 * 
 * @author feng
 *
 */
public class Manager extends Leader {

	public Manager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		// System.out.println();
		if (request.getLeaveDays() >= 3&&request.getLeaveDays()<10) {
			System.out.println("Ա����" + request.getEmpName() + " ���\n������"
					+ request.getLeaveDays() + "\nԭ��" + request.getReason());
			System.out.println("����" + this.name + " ����ͨ��\n");
		} else {
			if (this.nextLeader != null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}
}
