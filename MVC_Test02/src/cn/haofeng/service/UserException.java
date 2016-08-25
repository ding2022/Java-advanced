package cn.haofeng.service;
/**
 * 自定义异常类 一般只需要重写其父类的构造器即可。
 * @author hao.feng
 *
 */
public class UserException extends Exception {

	public UserException() {
		super();
	}

	public UserException(String message, Throwable cause,
			boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UserException(String message, Throwable cause) {
		super(message, cause);
	}

	public UserException(String message) {
		super(message);
	}

	public UserException(Throwable cause) {
		super(cause);
	}

}
