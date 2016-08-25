package 责任链;

/**
 * 主任审批
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
			System.out.println("员工：" + request.getEmpName() + " 请假\n天数："
					+ request.getLeaveDays() + "\n原因：" + request.getReason());
			System.out.println("主任：" + this.name + " 审批通过\n");
		} else {
			if (this.nextLeader != null) {
				this.nextLeader.handleRequest(request);
			}
		}
	}
}
