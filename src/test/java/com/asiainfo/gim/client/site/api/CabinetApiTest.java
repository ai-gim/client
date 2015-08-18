/**
 * @File: CabinetApiTest.java 
 * @Package  com.asiainfo.gim.client.site.api
 * @Description: 
 * @author luyang
 * @date 2015年8月17日 上午9:51:53 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.site.api;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.asiainfo.gim.client.Constants;
import com.asiainfo.gim.client.site.domain.Cabinet;
import com.asiainfo.gim.client.site.domain.query.CabinetQueryCondition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author luyang
 *
 */
public class CabinetApiTest
{
	private static CabinetApi cabinetApi;
	
	ObjectMapper om = new ObjectMapper();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		cabinetApi = new CabinetApi(Constants.TEST_SITE_ENDPOINT);
	}
	
	@Test
	@Ignore
	public void testListCabinets() throws JsonProcessingException
	{
		CabinetQueryCondition cabinetQueryCondition = new CabinetQueryCondition();
//		cabinetQueryCondition.setLocationId("12");
		
		List<Cabinet> cabinets = cabinetApi.listCabinets(cabinetQueryCondition);
		System.out.println(om.writeValueAsString(cabinets));
	}
	
	@Test
	@Ignore
	public void testGetCabinet() throws JsonProcessingException
	{
		Cabinet cabinet = cabinetApi.findCabinetById("1");
		System.out.println(om.writeValueAsString(cabinet));
	}
	
	@Test
	@Ignore
	public void testAddCabinet() throws JsonProcessingException
	{
		Cabinet cabinet = new Cabinet();
		cabinet.setLocationId("1");
		cabinet.setName("test");
		
		cabinet = cabinetApi.addCabinet(cabinet);
		
		System.out.println(om.writeValueAsString(cabinet));
	}
	
	@Test
	@Ignore
	public void testUpdataCabinet() throws JsonProcessingException
	{
		Cabinet cabinet = new Cabinet();
		cabinet.setId("8ac568de-5fa8-48ea-b9ff-e819c257ac04");
		cabinet.setName("new_test");
		cabinet.setLocationId("21");
		
		cabinet = cabinetApi.updateCabinet(cabinet);
		
		System.out.println(om.writeValueAsString(cabinet));
	}
	
	@Test
	@Ignore
	public void testDeleteCabinet()
	{
		cabinetApi.deleteCabinet("8ac568de-5fa8-48ea-b9ff-e819c257ac04");
	}
}
