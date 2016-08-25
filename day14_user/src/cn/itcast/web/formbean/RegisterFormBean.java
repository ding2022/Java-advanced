package cn.itcast.web.formbean;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;


public class RegisterFormBean {

	private String username;
	private String password;
	private String password2;
	private String email;
	private String birthday;
	
	private Map<String,String> errors = new HashMap();
	
	
	public Map<String, String> getErrors() {
		return errors;
	}
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	
	/*
	private String username;  用户名不能为空，并且要是3-8的字符 abcdABcd
	private String password;  密码不能为空，并且要是3-8的数字
	private String password2; 两次密码要一致
	private String email;     可以为空，不为空要是一个合法的邮箱
	private String birthday;  可以为空，不为空时，要是一个合法的日期
	 * 
	 */
	public boolean validate(){
		
		boolean isOk = true;
		
		if(this.username==null || this.username.trim().equals("") ){
			isOk = false;
			errors.put("username", "用户名不能为空！！");
		}else{
			if(!this.username.matches("[a-zA-Z]{3,8}")){
				isOk = false;
				errors.put("username", "用户名必须是3-8位的字母！！");
			}
		}
		
		
		if(this.password==null || this.password.trim().equals("")){
			isOk = false;
			errors.put("password", "密码不能为空！！");
		}else{
			if(!this.password.matches("\\d{3,8}")){
				isOk = false;
				errors.put("password", "密码必须是3-8位的数字！！");
			}
		}
		
		//private String password2; 两次密码要一致
		if(this.password2!=null){
			if(!this.password2.equals(this.password)){
				isOk = false;
				errors.put("password2", "两次密码不一致！！");
			}
		}
		
		//private String email;     可以为空，不为空要是一个合法的邮箱
		// flx_itcast@sina.com.cn
		if(this.email!=null){
			if(!this.email.matches("\\w+@\\w+(\\.\\w+)+")){
				isOk = false;
				errors.put("email", "邮箱不是一个合法邮箱！！");
			}
		}
		
		
		//private String birthday;  可以为空，不为空时，要是一个合法的日期
		if(this.birthday!=null){
			try{
				DateLocaleConverter conver = new DateLocaleConverter();
				conver.convert(this.birthday);
			}catch (Exception e) {
				isOk = false;
				errors.put("birthday", "生日必须要是一个日期！！");
			}
		}
		
		return isOk;
	}
	
	
	
}
