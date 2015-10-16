/**
 * @File: ResponseFilter.java 
 * @Package  com.asiainfo.gim.client
 * @Description: 
 * @author luyang
 * @date 2015年7月30日 下午3:53:23 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client;

import java.io.IOException;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientResponseContext;
import javax.ws.rs.client.ClientResponseFilter;

import com.asiainfo.gim.client.exception.ResourceNotFoundException;
import com.asiainfo.gim.client.exception.ServerErrorException;
import com.asiainfo.gim.client.exception.UnAuthorizedException;
import com.asiainfo.gim.client.exception.UnknownException;
import com.asiainfo.gim.client.exception.ValidationException;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * @author luyang
 *
 */
public class ResponseFilter implements ClientResponseFilter
{
	private static ObjectMapper om = new ObjectMapper();
	
	@Override
	public void filter(final ClientRequestContext reqCtx, final ClientResponseContext resCtx) throws IOException
	{
		if (resCtx.getStatus() == 400)
		{
			Error error = om.readValue(resCtx.getEntityStream(), Error.class);
			String message = error.getMessage();
			throw new ValidationException(message);
		}
		else if (resCtx.getStatus() == 401)
		{
			throw new UnAuthorizedException();
		}
		else if (resCtx.getStatus() == 404)
		{
			throw new ResourceNotFoundException();
		}
		else if (resCtx.getStatus() == 500)
		{
			throw new ServerErrorException();
		}
		else if (resCtx.getStatus() > 400)
		{
			throw new UnknownException();
		}
	}
}
