/**
 * @File: AlertQueryParam.java 
 * @Package  com.asiainfo.gim.client.monitor.domain.query
 * @Description: 
 * @author luyang
 * @date 2015年9月22日 下午2:23:04 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.monitor.domain.query;

import java.util.Date;

import com.asiainfo.gim.client.auth.domain.query.QueryCondition;

/**
 * @author luyang
 *
 */
public class AlertQueryParam extends QueryCondition
{
	private Date startTime;
	private Date endTime;
	// 设备类型
	private Integer targetType;
	// 设备ID
	private String targetId;
	// 告警级别
	private Integer level;
	// 告警状态（是否确认状态）
	private Integer status;
	// 告警来源
	private String source;

	private Integer configId;

	public Date getStartTime()
	{
		return startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Date getEndTime()
	{
		return endTime;
	}

	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

	public String getTargetId()
	{
		return targetId;
	}

	public void setTargetId(String targetId)
	{
		this.targetId = targetId;
	}

	public String getSource()
	{
		return source;
	}

	public void setSource(String source)
	{
		this.source = source;
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

	public Integer getStatus()
	{
		return status;
	}

	public void setStatus(Integer status)
	{
		this.status = status;
	}

	public Integer getConfigId()
	{
		return configId;
	}

	public void setConfigId(Integer configId)
	{
		this.configId = configId;
	}

}
