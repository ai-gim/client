package com.asiainfo.gim.client.monitor.domain;

import java.util.Map;

public class AlertConfig
{
	private String id;
	private Integer targetType;
	private String targetId;
	// 告警级别
	private Integer level;
	// 告警类型(metric, heartbeat)
	private Integer type;
	// 专属字段的json数据
	private Map<String, String> properties;

	public String getId()
	{
		return id;
	}

	public void setId(String id)
	{
		this.id = id;
	}

	public String getTargetId()
	{
		return targetId;
	}

	public void setTargetId(String targetId)
	{
		this.targetId = targetId;
	}

	public Integer getTargetType()
	{
		return targetType;
	}

	public void setTargetType(Integer targetType)
	{
		this.targetType = targetType;
	}

	public Integer getLevel()
	{
		return level;
	}

	public void setLevel(Integer level)
	{
		this.level = level;
	}

	public Integer getType()
	{
		return type;
	}

	public void setType(Integer type)
	{
		this.type = type;
	}

	public Map<String, String> getProperties()
	{
		return properties;
	}

	public void setProperties(Map<String, String> properties)
	{
		this.properties = properties;
	}

}
