/**   
 * @Title: TokenInjectFilter.java 
 * @Package com.asiainfo.gim.auth.client 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年7月28日 上午9:42:58 
 * @version V1.0   
 */
package com.asiainfo.gim.client;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;

/**
 * @author zhangli
 *
 */
public class TokenInjectFilter implements ClientRequestFilter
{

	@Override
	public void filter(ClientRequestContext context) throws IOException
	{
		String token = ClientContext.getToken();
		if (token != null)
		{
			context.getHeaders().putSingle("X-AUTH-TOKEN", token);
		}
	}

}
