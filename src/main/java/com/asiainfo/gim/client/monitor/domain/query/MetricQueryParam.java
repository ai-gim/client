package com.asiainfo.gim.client.monitor.domain.query;


public class MetricQueryParam
{
	private String ip;
	private long startTime;
	private long endTime;
	private String metricName;

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}

	public String getMetricName()
	{
		return metricName;
	}

	public void setMetricName(String metricName)
	{
		this.metricName = metricName;
	}

	public long getStartTime()
	{
		return startTime;
	}

	public void setStartTime(long startTime)
	{
		this.startTime = startTime;
	}

	public long getEndTime()
	{
		return endTime;
	}

	public void setEndTime(long endTime)
	{
		this.endTime = endTime;
	}

}
