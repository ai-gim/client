package com.asiainfo.gim.client.monitor.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asiainfo.gim.client.auth.api.AbstrackApi;
import com.asiainfo.gim.client.monitor.domain.AlertConfig;
import com.asiainfo.gim.client.monitor.domain.query.AlertConfigQueryParam;

public class AlertConfigApi extends AbstrackApi
{
	
	public AlertConfigApi(String endpoint)
	{
		super(endpoint);
	}

	public AlertConfig findAlertConfigById(int id)
	{
		String path = "/alertconfig";
		Map<String, String> queryParamters = new HashMap<String, String>();
		queryParamters.put("id", String.valueOf(id));
		return restTemplate.get(path, queryParamters, null, AlertConfig.class);
	}

	public List<AlertConfig> getAlertConfigs()
	{
		String path = "/alertconfigs";
		return restTemplate.getForList(path, null, null, AlertConfig.class);
	}
	
	public List<AlertConfig> getAlertConfigs(AlertConfigQueryParam alertConfigQueryParam)
	{
		String path = "/alertconfigs";
		Map<String, String> queryParamters = new HashMap<String, String>();
		queryParamters.put("targetType", String.valueOf(alertConfigQueryParam.getTargetType()));
		queryParamters.put("targetId", alertConfigQueryParam.getTargetId());
		queryParamters.put("level", String.valueOf(alertConfigQueryParam.getLevel()));
		queryParamters.put("type", String.valueOf(alertConfigQueryParam.getType()));
		return restTemplate.getForList(path, queryParamters, null, AlertConfig.class);
	}

	public AlertConfig addAlertConfig(AlertConfig alertConfig)
	{
		String path = "/alertconfig";
		return restTemplate.post(path, alertConfig, null, AlertConfig.class);
	}

	public AlertConfig updateAlertConfig(AlertConfig alertConfig)
	{
		String path = "/alertconfig";
		return restTemplate.put(path, alertConfig, null, AlertConfig.class);
	}

	public void deleteAlertConfig(int id)
	{
		String path = "/alertconfig/" + id;
		restTemplate.delete(path, null);
	}
	
}
