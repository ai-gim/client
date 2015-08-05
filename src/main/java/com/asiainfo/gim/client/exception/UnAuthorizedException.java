/**
 * @File: UnAuthorizedException.java 
 * @Package  com.asiainfo.gim.client.exception
 * @Description: 
 * @author luyang
 * @date 2015年7月31日 下午3:48:04 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.exception;

/**
 * @author luyang
 *
 */
public class UnAuthorizedException extends ClientException
{
	private static final long serialVersionUID = 1797566324620876930L;

	public UnAuthorizedException()
	{
		super();
	}

	public UnAuthorizedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnAuthorizedException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public UnAuthorizedException(String message)
	{
		super(message);
	}

	public UnAuthorizedException(Throwable cause)
	{
		super(cause);
	}
}
