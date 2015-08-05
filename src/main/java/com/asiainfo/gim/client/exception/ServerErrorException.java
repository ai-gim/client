/**
 * @File: ServerErrorException.java 
 * @Package  com.asiainfo.gim.client.exception
 * @Description: 
 * @author luyang
 * @date 2015年7月31日 下午3:52:32 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.exception;

/**
 * @author luyang
 *
 */
public class ServerErrorException extends ClientException
{
	private static final long serialVersionUID = 1972217198201162445L;
	
	public ServerErrorException()
	{
		super();
	}

	public ServerErrorException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ServerErrorException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ServerErrorException(String message)
	{
		super(message);
	}

	public ServerErrorException(Throwable cause)
	{
		super(cause);
	}
}
