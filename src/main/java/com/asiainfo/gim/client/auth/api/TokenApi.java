/**   
 * @Title: TokenApi.java 
 * @Package com.asiainfo.gim.auth.client.api 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年7月28日 上午10:10:03 
 * @version V1.0   
 */
package com.asiainfo.gim.client.auth.api;

import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;

import org.glassfish.jersey.internal.util.Base64;

import com.asiainfo.gim.client.auth.domain.Token;

/**
 * @author zhangli
 *
 */
public class TokenApi extends AbstrackApi
{
	public TokenApi(String endpoint)
	{
		super(endpoint);
	}

	public Token getToken(String username, String password)
	{
		MultivaluedMap<String, Object> headers = new MultivaluedHashMap<String, Object>();
		headers.putSingle("Authorization", "Basic " + Base64.encodeAsString(username + ":" + password));

		return restTemplate.get("/token", null, headers, Token.class);
	}

	public Token getToken()
	{
		return restTemplate.get("/token", null, null, Token.class);
	}
}
