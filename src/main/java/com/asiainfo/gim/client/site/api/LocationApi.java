/**
 * @File: LocationApi.java 
 * @Package  com.asiainfo.gim.client.site.api
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 下午3:29:22 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.site.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang.StringUtils;

import com.asiainfo.gim.client.auth.api.AbstrackApi;
import com.asiainfo.gim.client.site.domain.Location;
import com.asiainfo.gim.client.site.domain.query.LocationQueryCondition;

/**
 * @author luyang
 *
 */
public class LocationApi extends AbstrackApi
{
	public LocationApi(String endpoint)
	{
		super(endpoint);
	}
	
	public List<Location> listLocations(LocationQueryCondition locationQueryCondition)
	{
		String path = "/locations";
		Map<String, String> queryParamters = new HashMap<String, String>();
		if (!StringUtils.isEmpty(locationQueryCondition.getDatacenterId()))
		{
			queryParamters.put("datacenterId", locationQueryCondition.getDatacenterId());
		}
		return restTemplate.getForList(path, queryParamters, null, Location.class);
	}
	
	public Location findLocationById(String id)
	{
		String path = "/location/" + id;
		return restTemplate.get(path, null, null, Location.class);
	}
	
	public Location addLocation(Location location)
	{
		String path = "/location";
		return restTemplate.post(path, location, null, Location.class);
	}
	
	public Location updateLocation(Location location)
	{
		String path = "/location/" + location.getId();
		return restTemplate.put(path, location, null, Location.class);
	}
	
	public void deleteLocation(String id)
	{
		String path = "/location/" + id;
		restTemplate.delete(path, null);
	}
}
