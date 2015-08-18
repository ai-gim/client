/**
 * @File: DatacenterApiTest.java 
 * @Package  com.asiainfo.gim.client.site.api
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 上午9:19:46 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.site.api;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.asiainfo.gim.client.Constants;
import com.asiainfo.gim.client.site.domain.Datacenter;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author luyang
 *
 */
public class DatacenterApiTest
{
	private static DatacenterApi datacenterApi;
	
	ObjectMapper om = new ObjectMapper();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		datacenterApi = new DatacenterApi(Constants.TEST_SITE_ENDPOINT);
	}
	
	@Test
	@Ignore
	public void testListDatacenters() throws JsonProcessingException
	{
		List<Datacenter> datacenters = datacenterApi.listDatacenters();
		System.out.println(om.writeValueAsString(datacenters));
	}
	
	@Test
	@Ignore
	public void testFindDatacenterById() throws JsonProcessingException
	{
		Datacenter datacenter = datacenterApi.findDatacenterById("17ff3800-b95b-4a7d-ab83-7e01a45a5d88");
		System.out.println(om.writeValueAsString(datacenter));
	}
	
	@Test
	@Ignore
	public void testAddDatacenter() throws JsonProcessingException
	{
		Datacenter datacenter = new Datacenter();
		datacenter.setName("site_test");
		datacenter.setDescription("中文");
		
		datacenter = datacenterApi.addDatacenter(datacenter);
		System.out.println(om.writeValueAsString(datacenter));
	}
	
	@Test
	@Ignore
	public void testUpdateDatacenter() throws JsonProcessingException
	{
		Datacenter datacenter = new Datacenter();
		datacenter.setId("e89ecf9e-4b8f-4f05-b4f2-dc487ef58344");
		datacenter.setName("site_test_update");
		datacenter.setDescription("中文123");
		
		datacenter = datacenterApi.updateDatacenter(datacenter);
		System.out.println(om.writeValueAsString(datacenter));
	}
	
	@Test
	@Ignore
	public void testDeleteDatacenter()
	{
		datacenterApi.deleteDatacenter("17ff3800-b95b-4a7d-ab83-7e01a45a5d88");
	}
}
