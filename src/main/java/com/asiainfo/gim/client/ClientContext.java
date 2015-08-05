/**   
* @Title: ClientContext.java 
* @Package com.asiainfo.gim.auth.client 
* @Description: TODO(用一句话描述该文件做什么) 
* @author zhangli
* @date 2015年7月28日 上午9:35:12 
* @version V1.0   
*/
package com.asiainfo.gim.client;

/**
 * @author zhangli
 *
 */
public class ClientContext
{
	private static ThreadLocal<String> tokenTl = new ThreadLocal<String>();
	
	public static void setToken(String token)
	{
		tokenTl.set(token);
	}
	
	public static String getToken()
	{
		return tokenTl.get();
	}
}
