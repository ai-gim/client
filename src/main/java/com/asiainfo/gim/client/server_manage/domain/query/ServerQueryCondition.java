/**
 * @File: ServerQueryCondition.java 
 * @Package  com.asiainfo.gim.client.auth.domain.query
 * @Description: 
 * @author luyang
 * @date 2015年8月7日 上午9:53:41 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.server_manage.domain.query;

import com.asiainfo.gim.client.auth.domain.query.QueryCondition;

/**
 * @author luyang
 *
 */
public class ServerQueryCondition extends QueryCondition
{
	private String ip;

	public String getIp()
	{
		return ip;
	}

	public void setIp(String ip)
	{
		this.ip = ip;
	}
}
