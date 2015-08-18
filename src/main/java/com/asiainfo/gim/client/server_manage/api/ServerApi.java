/**
 * @File: ServerApi.java 
 * @Package  com.asiainfo.gim.client.server_manage.api
 * @Description: 
 * @author luyang
 * @date 2015年8月6日 下午12:00:53 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.server_manage.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asiainfo.gim.client.auth.api.AbstrackApi;
import com.asiainfo.gim.client.server_manage.domain.Asset;
import com.asiainfo.gim.client.server_manage.domain.Ipmi;
import com.asiainfo.gim.client.server_manage.domain.Server;
import com.asiainfo.gim.client.server_manage.domain.Ssh;
import com.asiainfo.gim.client.server_manage.domain.query.ServerQueryCondition;

/**
 * @author luyang
 *
 */
public class ServerApi extends AbstrackApi
{
	public ServerApi(String endpoint)
	{
		super(endpoint);
	}
	
	public List<Server> listServers()
	{
		String path = "/servers";
		return restTemplate.getForList(path, null, null, Server.class);
	}
	
	public List<Server> listServers(ServerQueryCondition serverQueryCondition)
	{
		String path = "/servers";
		Map<String, String> queryParamters = new HashMap<String, String>();
		queryParamters.put("ip", serverQueryCondition.getIp());
		
		return restTemplate.getForList(path, queryParamters, null, Server.class);
	}
	
	public Server findServerById(String id)
	{
		String path = "/server/" + id;
		return restTemplate.get(path, null, null, Server.class);
	}
	
	public Server addServer(Server server)
	{
		String path = "/server";
		return restTemplate.post(path, server, null, Server.class);
	}
	
	public Server updateServer(Server server)
	{
		String path = "/server/" + server.getId();
		return restTemplate.put(path, server, null, Server.class);
	}
	
	public Server updateSsh(String serverId, Ssh ssh)
	{
		String path = "/server/" + serverId + "/ssh";
		return restTemplate.put(path, ssh, null, Server.class);
	}
	
	public Server updateIpmi(String serverId, Ipmi ipmi)
	{
		String path = "/server/" + serverId + "/ipmi";
		return restTemplate.put(path, ipmi, null, Server.class);
	}
	
	public Server updateAsset(String serverId, Asset asset)
	{
		String path = "/server/" + serverId + "/asset";
		return restTemplate.put(path, asset, null, Server.class);
	}
	
	public void deleteServer(String serverId)
	{
		String path = "/server/" + serverId;
		restTemplate.delete(path, null);
	}
}
