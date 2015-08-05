/**
 * @File: UnknownException.java 
 * @Package  com.asiainfo.gim.client.exception
 * @Description: 
 * @author luyang
 * @date 2015年7月31日 下午3:53:55 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.exception;

/**
 * @author luyang
 *
 */
public class UnknownException extends ClientException
{
	private static final long serialVersionUID = 1113284843437185859L;
	
	public UnknownException()
	{
		super();
	}

	public UnknownException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public UnknownException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public UnknownException(String message)
	{
		super(message);
	}

	public UnknownException(Throwable cause)
	{
		super(cause);
	}
}
