package com.wyc.entity;

import java.util.Date;

public class Polling {

    private Integer id;

    private Integer iconNumber;

    private String eventUrl;

    private String eventType;

    private String iconName;

    private String STREETNAME;

    private String imgUrl;

    private String version;

    private Date saveTime;
    
    private Integer view;
    
    

    public Integer getView() {
		return view;
	}


	public void setView(Integer view) {
		this.view = view;
	}


	public Polling() {
	}

	




	public Polling(Integer iconNumber, String eventUrl, String eventType, String iconName, String sTREETNAME,
			String imgUrl, String version, Integer view) {
		super();
		this.iconNumber = iconNumber;
		this.eventUrl = eventUrl;
		this.eventType = eventType;
		this.iconName = iconName;
		STREETNAME = sTREETNAME;
		this.imgUrl = imgUrl;
		this.version = version;
		this.view = view;
	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIconNumber() {
        return iconNumber;
    }

    public void setIconNumber(Integer iconNumber) {
        this.iconNumber = iconNumber;
    }

    public String getEventUrl() {
        return eventUrl;
    }

    public void setEventUrl(String eventUrl) {
        this.eventUrl = eventUrl;
    }

    public String getEventType() {
        return eventType;
    }

    public void setEventType(String eventType) {
        this.eventType = eventType;
    }

    public String getIconName() {
        return iconName;
    }

    public void setIconName(String iconName) {
        this.iconName = iconName;
    }

    public String getSTREETNAME() {
        return STREETNAME;
    }

    public void setSTREETNAME(String STREETNAME) {
        this.STREETNAME = STREETNAME;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
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

    @Override
    public String toString() {
        return "Polling{" +
                "id=" + id +
                ", iconNumber=" + iconNumber +
                ", eventUrl='" + eventUrl + '\'' +
                ", eventType='" + eventType + '\'' +
                ", iconName='" + iconName + '\'' +
                ", STREETNAME='" + STREETNAME + '\'' +
                ", imgUrl='" + imgUrl + '\'' +
                ", version=" + version +
                ", saveTime=" + saveTime +
                '}';
    }
}
