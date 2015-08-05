/**
 * @File: ClientException.java 
 * @Package  com.asiainfo.gim.client.exception
 * @Description: 
 * @author luyang
 * @date 2015年7月31日 下午3:44:00 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.exception;

/**
 * @author luyang
 *
 */
public class ClientException extends RuntimeException
{
	private static final long serialVersionUID = 3253287054977440217L;

	public ClientException()
	{
		super();
	}

	public ClientException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ClientException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ClientException(String message)
	{
		super(message);
	}

	public ClientException(Throwable cause)
	{
		super(cause);
	}
}
