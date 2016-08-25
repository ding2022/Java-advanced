package ������;

/**
 * ������
 * 
 * @author feng
 *
 */
public abstract class Leader {
	protected String name;
	protected Leader nextLeader;// �������ϵĺ�Ƕ���

	public Leader(String name) {
		super();
		this.name = name;
	}

	public Leader getNextLeader() {
		return nextLeader;
	}

	// �趨�������ϵĺ�̶���
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}

	/**
	 * ��������ĺ���ҵ�񷽷�
	 * 
	 * @param request
	 */
	public abstract void handleRequest(LeaveRequest request);

}
