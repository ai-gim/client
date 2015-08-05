/**
 * @File: ValidationException.java 
 * @Package  com.asiainfo.gim.client.exception
 * @Description: 
 * @author luyang
 * @date 2015年7月31日 下午3:46:41 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.exception;

/**
 * @author luyang
 *
 */
public class ValidationException extends ClientException
{
	private static final long serialVersionUID = 1285395436169249758L;

	public ValidationException()
	{
		super();
	}

	public ValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace)
	{
		super(message, cause, enableSuppression, writableStackTrace);
	}

	public ValidationException(String message, Throwable cause)
	{
		super(message, cause);
	}

	public ValidationException(String message)
	{
		super(message);
	}

	public ValidationException(Throwable cause)
	{
		super(cause);
	}
}
