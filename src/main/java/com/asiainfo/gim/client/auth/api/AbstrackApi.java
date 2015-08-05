/**   
 * @Title: AbstrackApi.java 
 * @Package com.asiainfo.gim.auth.client.api 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年7月28日 上午10:10:40 
 * @version V1.0   
 */
package com.asiainfo.gim.client.auth.api;

import com.asiainfo.gim.client.RestTemplate;

/**
 * @author zhangli
 *
 */
public abstract class AbstrackApi
{
	protected RestTemplate restTemplate;

	public AbstrackApi(String endpoint)
	{
		this.restTemplate = new RestTemplate(endpoint);
	}
}
