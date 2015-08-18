/**
 * @File: LocationApiTest.java 
 * @Package  com.asiainfo.gim.client.site.api
 * @Description: 
 * @author luyang
 * @date 2015年8月14日 下午3:31:02 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.site.api;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.asiainfo.gim.client.Constants;
import com.asiainfo.gim.client.site.domain.Location;
import com.asiainfo.gim.client.site.domain.query.LocationQueryCondition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author luyang
 *
 */
public class LocationApiTest
{
	private static LocationApi locationApi;
	
	ObjectMapper om = new ObjectMapper();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		locationApi = new LocationApi(Constants.TEST_SITE_ENDPOINT);
	}
	
	@Test
	@Ignore
	public void testListLocations() throws JsonProcessingException
	{
		LocationQueryCondition locationQueryCondition = new LocationQueryCondition();
		locationQueryCondition.setDatacenterId("1");
		List<Location> locations = locationApi.listLocations(locationQueryCondition);
		System.out.println(om.writeValueAsString(locations));
	}
	
	@Test
	@Ignore
	public void testGetLocation() throws JsonProcessingException
	{
		Location location = locationApi.findLocationById("1");
		System.out.println(om.writeValueAsString(location));
	}
	
	@Test
	@Ignore
	public void testAddLocation() throws JsonProcessingException
	{
		Location location = new Location();
		location.setDatacenterId("1");
		location.setName("test_add");
		location.setSite("1");
		location.setFloor("2");
		location.setRoom("3");
		location.setDescription("4");
		
		location = locationApi.addLocation(location);
		System.out.println(om.writeValueAsString(location));
	}
	
	@Test
	@Ignore
	public void testUpdateLocation() throws JsonProcessingException
	{
		Location location = new Location();
		location.setId("faf11cbf-3d2e-44fc-af5f-c490c448ecc2");
		location.setDatacenterId("2");
		location.setName("test_add1");
		location.setSite("01");
		location.setFloor("02");
		location.setRoom("03");
		location.setDescription("04");
		
		location = locationApi.updateLocation(location);
		System.out.println(om.writeValueAsString(location));
	}
	
	@Test
	@Ignore
	public void testDeleteLocation() throws JsonProcessingException
	{
		locationApi.deleteLocation("1");
	}
}
