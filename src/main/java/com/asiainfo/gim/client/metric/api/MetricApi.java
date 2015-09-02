package com.asiainfo.gim.client.metric.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.gim.client.auth.api.AbstrackApi;
import com.asiainfo.gim.client.metric.domain.Metric;
import com.asiainfo.gim.client.metric.domain.query.MetricQueryParam;

public class MetricApi extends AbstrackApi
{

	public MetricApi(String endpoint)
	{
		super(endpoint);
	}
	
	public List<Metric> listMetric(MetricQueryParam metricQueryParam){
		String path = "/metric/listMetric";
		Map<String, String> queryParamters = new HashMap<String, String>();
		if (!StringUtils.isEmpty(metricQueryParam.getMetricName()))
		{
			queryParamters.put("indexName", metricQueryParam.getMetricName());
		}
		if (!StringUtils.isEmpty(metricQueryParam.getIp()))
		{
			queryParamters.put("ip", metricQueryParam.getIp());
		}
		if (metricQueryParam.getStartTime() > 0 && metricQueryParam.getEndTime() > 0)
		{
			queryParamters.put("startTime", String.valueOf(metricQueryParam.getStartTime()));
			queryParamters.put("endTime", String.valueOf(metricQueryParam.getEndTime()));
		}
		return restTemplate.getForList(path, queryParamters, null, Metric.class);
	}

}
