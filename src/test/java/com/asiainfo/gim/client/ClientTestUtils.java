/**   
* @Title: ClientTestUtils.java 
* @Package com.asiainfo.gim.auth.client.api 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhangli
* @date 2015年7月28日 上午10:45:14 
* @version V1.0   
*/
package com.asiainfo.gim.client;

import com.asiainfo.gim.client.auth.api.TokenApi;
import com.asiainfo.gim.client.auth.domain.Token;

/**
 * @author zhangli
 *
 */
public class ClientTestUtils
{
	private static Token token;
	
	public static void fetchToken()
	{
		TokenApi tokenApi = new TokenApi(Constants.TEST_AUTH_ENDPOINT);
		token = tokenApi.getToken(Constants.TEST_USERNAME, Constants.TEST_PASSWORD);
	}
	
	public static void injectToken()
	{
		ClientContext.setToken(token.getId());
	}
}
