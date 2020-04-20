package com.wdg.bean;

public class Log {
	private Integer loginId;//除了id其它的值设置为空,否则出现Field 'loginId' doesn't have a default value错误
	private Integer id;

	public Integer getId() {
		return id;
	}

	public void setLoginId(Integer loginId) {
		this.loginId = loginId;
	}

	public Integer getLoginId() {
		return loginId;
	}

	public void setId(Integer loginId) {
		this.loginId = loginId;
	}

	private String name;
	private String loginTime;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLoginTime() {
		return loginTime;
	}

	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}

}
