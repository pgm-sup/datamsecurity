package com.wyc.entity;

import java.io.Serializable;

/**
 * ���
 * @author haima
 *
 */
public class LogEntity implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	// logid
	private int id;

	private String username;

	private String module;
	// IP
	private String ip;

	private String data;

	private String comment;

	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getModule() {
		return module;
	}
	public void setModule(String module) {
		this.module = module;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	
	

}
