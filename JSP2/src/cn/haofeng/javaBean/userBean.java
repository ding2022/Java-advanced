package cn.haofeng.javaBean;

public class userBean {
	public String name;
	public String gender;
	public String age;

	@Override
	public String toString() {
		return "userBean [name=" + name + ", gender=" + gender + ", age=" + age
				+ "]";
	}

	public userBean() {
		super();
	}

	public userBean(String name, String gender, String age) {
		super();
		this.name = name;
		this.gender = gender;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}
	
	
}
