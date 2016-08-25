package cn.haofeng.domin;

public class User {
	private String uname;
	private String upass;
	private String vercode;

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getVercode() {
		return vercode;
	}

	public void setVercode(String vercode) {
		this.vercode = vercode;
	}

	public User(String uname, String upass, String vercode) {
		super();
		this.uname = uname;
		this.upass = upass;
		this.vercode = vercode;
	}

	public User() {
		super();
	}

	@Override
	public String toString() {
		return "User [uname=" + uname + ", upass=" + upass + ", vercode="
				+ vercode + "]";
	}

}
