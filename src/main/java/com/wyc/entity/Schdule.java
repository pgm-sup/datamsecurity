package com.wyc.entity;

import java.util.Date;

/**
 *   值班情况表
 * @author haima
 *
 */
public class Schdule {
	
	// 值班情况id
	private Integer id;
	// 街镇名称
	private String STREETNAME;
	// 单位名称
	private String value3;
	// 联系电话
	private String value2;
	// 值班人姓名
	private String value1;
	// 版本
	private String version;
	// 保存时间
	private Date saveTime;
	
	private Integer view;
	
	
	public Schdule() {
	}

	

	public Schdule(String sTREETNAME, String value3, String value2, String value1, String version, Integer view) {
		super();
		STREETNAME = sTREETNAME;
		this.value3 = value3;
		this.value2 = value2;
		this.value1 = value1;
		this.version = version;
		this.view = view;
	}



	

	public Integer getView() {
		return view;
	}



	public void setView(Integer view) {
		this.view = view;
	}



	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Date getSaveTime() {
		return saveTime;
	}

	public void setSaveTime(Date saveTime) {
		this.saveTime = saveTime;
	}

	
	public Integer getId() {
		return id;
	}



	public void setId(Integer id) {
		this.id = id;
	}



	public String getSTREETNAME() {
		return STREETNAME;
	}
	public void setSTREETNAME(String sTREETNAME) {
		STREETNAME = sTREETNAME;
	}
	public String getValue3() {
		return value3;
	}
	public void setValue3(String value3) {
		this.value3 = value3;
	}
	public String getValue2() {
		return value2;
	}
	public void setValue2(String value2) {
		this.value2 = value2;
	}
	public String getValue1() {
		return value1;
	}
	public void setValue1(String value1) {
		this.value1 = value1;
	}



	@Override
	public String toString() {
		return "Schdule [id=" + id + ", STREETNAME=" + STREETNAME + ", value3=" + value3 + ", value2=" + value2
				+ ", value1=" + value1 + ", version=" + version + ", saveTime=" + saveTime + ", view=" + view + "]";
	}
	
	
}
