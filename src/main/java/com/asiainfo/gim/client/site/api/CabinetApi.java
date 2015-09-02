/**
 * @File: CabinetApi.java 
 * @Package  com.asiainfo.gim.client.site.api
 * @Description: 
 * @author luyang
 * @date 2015年8月17日 上午9:49:53 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.site.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asiainfo.gim.client.auth.api.AbstrackApi;
import com.asiainfo.gim.client.site.domain.Cabinet;
import com.asiainfo.gim.client.site.domain.query.CabinetQueryCondition;

/**
 * @author luyang
 *
 */
public class CabinetApi extends AbstrackApi
{
	public CabinetApi(String endpoint)
	{
		super(endpoint);
	}
	
	public List<Cabinet> listCabinets(CabinetQueryCondition cabinetQueryCondition)
	{
		String path = "/cabinets";
		Map<String, String> queryParamters = new HashMap<String, String>();
		if (cabinetQueryCondition.getLocationId() != null)
		{
			queryParamters.put("locationId", String.valueOf(cabinetQueryCondition.getLocationId()));
		}
		return restTemplate.getForList(path, queryParamters, null, Cabinet.class);
	}
	
	public Cabinet findCabinetById(Integer id)
	{
		String path = "/cabinet/" + id;
		return restTemplate.get(path, null, null, Cabinet.class);
	}
	
	public Cabinet addCabinet(Cabinet cabinet)
	{
		String path = "/cabinet";
		return restTemplate.post(path, cabinet, null, Cabinet.class);
	}
	
	public Cabinet updateCabinet(Cabinet cabinet)
	{
		String path = "/cabinet/" + cabinet.getId();
		return restTemplate.put(path, cabinet, null, Cabinet.class);
	}
	
	public void deleteCabinet(Integer id)
	{
		String path = "/cabinet/" + id;
		restTemplate.delete(path, null);
	}
}
