package 责任链;

/**
 * 抽象类
 * 
 * @author feng
 *
 */
public abstract class Leader {
	protected String name;
	protected Leader nextLeader;// 责任链上的后记对象

	public Leader(String name) {
		super();
		this.name = name;
	}

	public Leader getNextLeader() {
		return nextLeader;
	}

	// 设定责任链上的后继对象
	public void setNextLeader(Leader nextLeader) {
		this.nextLeader = nextLeader;
	}

	/**
	 * 处理请求的核心业务方法
	 * 
	 * @param request
	 */
	public abstract void handleRequest(LeaveRequest request);

}
