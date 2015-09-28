/**
 * @File: AlertApi.java 
 * @Package  com.asiainfo.gim.client.monitor.api
 * @Description: 
 * @author luyang
 * @date 2015年9月22日 下午2:34:39 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.monitor.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asiainfo.gim.client.auth.api.AbstrackApi;
import com.asiainfo.gim.client.monitor.domain.Alert;
import com.asiainfo.gim.client.monitor.domain.AlertAction;
import com.asiainfo.gim.client.monitor.domain.query.AlertQueryParam;

/**
 * @author luyang
 *
 */
public class AlertApi extends AbstrackApi
{
	public AlertApi(String endpoint)
	{
		super(endpoint);
	}
	
	public List<Alert> listAlerts()
	{
		String path = "/alerts";
		return restTemplate.getForList(path, null, null, Alert.class);
	}

	public List<Alert> listAlerts(AlertQueryParam alertQueryParam)
	{
		String path = "/alerts";
		Map<String, String> queryParamters = new HashMap<String, String>();
		queryParamters.put("status", String.valueOf(alertQueryParam.getStatus()));
		queryParamters.put("start", String.valueOf(alertQueryParam.getStart()));
		queryParamters.put("limit", String.valueOf(alertQueryParam.getLimit()));
		queryParamters.put("targetType", String.valueOf(alertQueryParam.getTargetType()));
		queryParamters.put("targetId", String.valueOf(alertQueryParam.getTargetId()));
		queryParamters.put("level", String.valueOf(alertQueryParam.getLevel()));
		queryParamters.put("source", String.valueOf(alertQueryParam.getSource()));
		if (alertQueryParam.getStartTime() != null)
		{
			queryParamters.put("startTime", String.valueOf(alertQueryParam.getStartTime().getTime()));
		}
		if (alertQueryParam.getEndTime() != null)
		{
			queryParamters.put("endTime", String.valueOf(alertQueryParam.getEndTime().getTime()));
		}
		
		return restTemplate.getForList(path, queryParamters, null, Alert.class);
	}
	
	public void confirmAlert(String id)
	{
		String path = "/alert/" + id + "/action";
		AlertAction alertAction = new AlertAction();
		alertAction.setAction("confirm");
		restTemplate.put(path, alertAction, null, Alert.class);
	}
}
