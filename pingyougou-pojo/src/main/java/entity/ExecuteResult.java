package entity;
/**
 * 执行结果封装对象
 * @author Administrator
 *
 */
public class ExecuteResult {
	private boolean success;
	private String message;

	public ExecuteResult(boolean success, String message) {
		super();
		this.success = success;
		this.message = message;
	}
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
