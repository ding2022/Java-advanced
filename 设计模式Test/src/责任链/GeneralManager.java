package ������;

/**
 * ��������
 * 
 * @author feng
 *
 */
public class GeneralManager extends Leader {

	public GeneralManager(String name) {
		super(name);
	}

	@Override
	public void handleRequest(LeaveRequest request) {
		// System.out.println();
		if (request.getLeaveDays() < 30) {
			System.out.println("Ա����" + request.getEmpName() + " ���\n������"
					+ request.getLeaveDays() + "\nԭ��" + request.getReason());
			System.out.println("�ܾ���" + this.name + " ����ͨ��\n");
		} else {
			System.out.println("��ͬ��!!");
		}
	}
}
