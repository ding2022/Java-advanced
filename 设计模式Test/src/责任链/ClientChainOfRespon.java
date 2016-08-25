package 责任链;

public class ClientChainOfRespon {
	public static void main(String[] args) {
		Leader a = new Director("张三");
		Leader b = new Manager("李四");
		Leader c = new GeneralManager("王五");

		// 组织成责任链

		a.setNextLeader(b);
		b.setNextLeader(c);

		LeaveRequest request = new LeaveRequest("浩哥", 10, "玩");
		a.handleRequest(request);
	}
}
