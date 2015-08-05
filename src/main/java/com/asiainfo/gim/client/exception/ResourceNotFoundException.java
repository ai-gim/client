/**
 * @File: ResourceNotFoundException.java 
 * @Package  com.asiainfo.gim.client.exception
 * @Description: 
 * @author luyang
 * @date 2015年7月31日 下午3:49:00 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.exception;

/**
 * @author luyang
 *
 */
public class ResourceNotFoundException extends ClientException
{
	private static final long serialVersionUID = 7282325259586088640L;

	public ResourceNotFoundException()
	{
		super();
	}

	public ResourceNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ResourceNotFoundException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ResourceNotFoundException(String message)
	{
		super(message);
	}

	public ResourceNotFoundException(Throwable cause)
	{
		super(cause);
	}
}
