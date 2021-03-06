package com.asiainfo.gim.client.deploy.domain;

import java.util.Date;

public class Image {
	
	private Integer id;
	
	private String name;
	
	private String desc;
	
	private Date createTime;
	
	private String osType;
	
	private String osVersion;
	
	private String osArch;
	
	private String isoFile;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getOsType() {
		return osType;
	}

	public void setOsType(String osType) {
		this.osType = osType;
	}

	public String getOsVersion() {
		return osVersion;
	}

	public void setOsVersion(String osVersion) {
		this.osVersion = osVersion;
	}

	public String getOsArch() {
		return osArch;
	}

	public void setOsArch(String osArch) {
		this.osArch = osArch;
	}

	public String getIsoFile() {
		return isoFile;
	}

	public void setIsoFile(String isoFile) {
		this.isoFile = isoFile;
	}

}
