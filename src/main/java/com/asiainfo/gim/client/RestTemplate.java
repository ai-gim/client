package com.asiainfo.gim.client;

import java.util.List;
import java.util.Map;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.MultiPartFeature;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.jaxrs.json.JacksonJsonProvider;

public class RestTemplate
{
	public String endpoint;

	public RestTemplate(String endpoint)
	{
		super();
		this.endpoint = endpoint;
	}
	
	private Client createClient()
	{
		Client client = ClientBuilder.newClient();
		client.register(JacksonJsonProvider.class);
		client.register(TokenInjectFilter.class);
		client.register(ResponseFilter.class);
		client.register(MultiPartFeature.class);
		return client;
	}
	
	public <T> T get(String path, Map<String, String> queryParamters, MultivaluedMap<String, Object> headers, Class<T> clazz)
	{
		Client client = createClient();
		
		if (queryParamters != null && queryParamters.size() > 0)
		{
			StringBuilder pathWithQueryParameters = new StringBuilder(path).append("?");
			for (Map.Entry<String, String> parameterEntry : queryParamters.entrySet())
			{
				if (!StringUtils.isEmpty(parameterEntry.getValue()) && !StringUtils.equals(parameterEntry.getValue(), "null"))
				{
					pathWithQueryParameters.append(parameterEntry.getKey()).append("=")
					.append(parameterEntry.getValue()).append("&");
				}
			}
			
			path = pathWithQueryParameters.substring(0, pathWithQueryParameters.length() - 1);
		}

		WebTarget target = client.target(endpoint + path);
		
		Response response = target.request().headers(headers).get();

		T responseObj = response.readEntity(clazz);

		response.close();
		return responseObj;
	}
	
	public <T> T post(String path, Object object, MultivaluedMap<String, Object> headers, Class<T> clazz)
	{
		Client client = createClient();
		
		WebTarget target = client.target(endpoint + path);
		
		Response response = target.request().headers(headers).post(Entity.entity(object, MediaType.APPLICATION_JSON));

		T responseObj = response.readEntity(clazz);

		response.close();
		return responseObj;
	}
	
	public <T> T put(String path, Object object, MultivaluedMap<String, Object> headers, Class<T> clazz)
	{
		Client client = createClient();
		
		WebTarget target = client.target(endpoint + path);
		
		Response response = target.request().headers(headers).put(Entity.entity(object, MediaType.APPLICATION_JSON));

		T responseObj = response.readEntity(clazz);

		response.close();
		return responseObj;
	}
	
	public void delete(String path, MultivaluedMap<String, Object> headers)
	{
		Client client = createClient();
		
		WebTarget target = client.target(endpoint + path);
		
		Response response = target.request().headers(headers).delete();
		
		response.close();
	}
	
	public <T> List<T> getForList(String path, Map<String, String> queryParamters, MultivaluedMap<String, Object> headers, Class<T> clazz)
	{
		Client client = createClient();

		if (queryParamters != null && queryParamters.size() > 0)
		{
			StringBuilder pathWithQueryParameters = new StringBuilder(path).append("?");
			for (Map.Entry<String, String> parameterEntry : queryParamters.entrySet())
			{
				if (!StringUtils.isEmpty(parameterEntry.getValue()) && !StringUtils.equals(parameterEntry.getValue(), "null"))
				{
					pathWithQueryParameters.append(parameterEntry.getKey()).append("=")
					.append(parameterEntry.getValue()).append("&");
				}
			}
			
			path = pathWithQueryParameters.substring(0, pathWithQueryParameters.length() - 1);
		}

		WebTarget target = client.target(endpoint + path);
		Response response = target.request().headers(headers).get();

		String content = response.readEntity(String.class);
		
		ObjectMapper om = new ObjectMapper();
		JavaType javaType = om.getTypeFactory().constructCollectionType(List.class, clazz);
		
		List<T> responseList = null;
		try
		{
			responseList = (List<T>)om.readValue(content, javaType);
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

		response.close();
		return responseList;
	}
	
	public <T> T postForFile(String path, FormDataMultiPart formDataMultiPart, MultivaluedMap<String, Object> headers, Class<T> clazz)
	{
		Client client = createClient();
		
		WebTarget target = client.target(endpoint + path);
		
		Response response = target.request().headers(headers).post(Entity.entity(formDataMultiPart, formDataMultiPart.getMediaType()));

		T responseObj = response.readEntity(clazz);

		response.close();
		return responseObj;
	}
}
