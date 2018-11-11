package entity;

import java.io.Serializable;
import java.util.List;

/**
 * 分页结果封装对象
 * @author Administrator
 *
 */

public class PageResult implements Serializable{
	private long total;  //总记录数
	private List list;  //当前页面显示的结果
	
	
	
	@Override
	public String toString() {
		return "PageResult [total=" + total + ", list=" + list + "]";
	}
	public PageResult() {
		super();
	}
	public PageResult(long total, List list) {
		super();
		this.total = total;
		this.list = list;
	}
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List getList() {
		return list;
	}
	public void setList(List list) {
		this.list = list;
	}
	
	

}
