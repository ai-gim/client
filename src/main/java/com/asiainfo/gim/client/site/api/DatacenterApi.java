/**
 * @File: DatacenterApi.java 
 * @Package  com.asiainfo.gim.client.site.api
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 上午9:09:36 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.site.api;

import java.util.List;

import com.asiainfo.gim.client.auth.api.AbstrackApi;
import com.asiainfo.gim.client.site.domain.Datacenter;

/**
 * @author luyang
 *
 */
public class DatacenterApi extends AbstrackApi
{
	public DatacenterApi(String endpoint)
	{
		super(endpoint);
	}

	public List<Datacenter> listDatacenters()
	{
		String path = "/datacenters";
		return restTemplate.getForList(path, null, null, Datacenter.class);
	}
	
	public Datacenter findDatacenterById(Integer id)
	{
		String path = "/datacenter/" + id;
		return restTemplate.get(path, null, null, Datacenter.class);
	}
	
	public Datacenter addDatacenter(Datacenter datacenter)
	{
		String path = "/datacenter";
		return restTemplate.post(path, datacenter, null, Datacenter.class);
	}
	
	public Datacenter updateDatacenter(Datacenter datacenter)
	{
		String path = "/datacenter/" + datacenter.getId();
		return restTemplate.put(path, datacenter, null, Datacenter.class);
	}
	
	public void deleteDatacenter(Integer id)
	{
		String path = "/datacenter/" + id;
		restTemplate.delete(path, null);
	}
}
