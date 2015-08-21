/**
 * @File: ServerApiTest.java 
 * @Package  com.asiainfo.gim.client.server_manege.api
 * @Description: 
 * @author luyang
 * @date 2015年8月6日 下午12:07:00 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.server_manege.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.asiainfo.gim.client.ClientTestUtils;
import com.asiainfo.gim.client.Constants;
import com.asiainfo.gim.client.server_manage.api.ServerApi;
import com.asiainfo.gim.client.server_manage.domain.Asset;
import com.asiainfo.gim.client.server_manage.domain.Ipmi;
import com.asiainfo.gim.client.server_manage.domain.Server;
import com.asiainfo.gim.client.server_manage.domain.Ssh;
import com.asiainfo.gim.client.server_manage.domain.query.ServerQueryCondition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author luyang
 *
 */
public class ServerApiTest
{	
	public static ServerApi serverApi;

	ObjectMapper om = new ObjectMapper();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		serverApi = new ServerApi(Constants.TEST_SERVER_MANAGE_ENDPOINT);
//		serverApi = new ServerApi(Constants.TEST_AUTH_ENDPOINT);
//		ClientTestUtils.fetchToken();
	}

	@Before
	public void prepare()
	{
//		ClientTestUtils.injectToken();
	}
	
	@Test
	@Ignore
	public void testListServers() throws JsonProcessingException
	{
		List<Server> servers = serverApi.listServers();
		System.out.println(om.writeValueAsString(servers));
		
		ServerQueryCondition serverQueryCondition = new ServerQueryCondition();
		serverQueryCondition.setIp("127.0.0.2");
		servers = serverApi.listServers(serverQueryCondition);
		System.out.println(om.writeValueAsString(servers));
	}
	
	@Test
	@Ignore
	public void testFindServerById() throws JsonProcessingException
	{
		Server server = serverApi.findServerById("4f5dda3e-d391-4b1a-ac28-8ac2eb51d34f");
		System.out.println(om.writeValueAsString(server));
	}
	
	@Test
	@Ignore
	public void testAddServer() throws JsonProcessingException
	{
		Server server = new Server();
		server.setIp("192.11.0.200");
		Map<String, String> map = new HashMap<String, String>();
		map.put("name", "1");
		map.put("word", "2");
		server.setProperties(map);
		
		server = serverApi.addServer(server);
		System.out.println(om.writeValueAsString(server));
	}
	
	@Test
	@Ignore
	public void testUpdateServer() throws JsonProcessingException
	{
		Server server = new Server();
		server.setId("4f5dda3e-d391-4b1a-ac28-8ac2eb51d34f");
		server.setIp("127.0.0.2");
		server.setMac("1.1.1.1.1.1");
		server.setNetmask("255.255.255.255");
		server = serverApi.updateServer(server);
		System.out.println(om.writeValueAsString(server));
	}
	
	@Test
	@Ignore
	public void testUpdateSsh() throws JsonProcessingException
	{
		Ssh ssh = new Ssh();
		ssh.setHost("127.0.0.10");
		ssh.setPort(8080);
		ssh.setUsername("administrator");
		ssh.setPassword("administrator");
		
		Server server = serverApi.updateSsh("1424bf6c-2443-4e3b-83f7-c972e0a6472a", ssh);
		System.out.println(om.writeValueAsString(server));
	}
	
	@Test
	@Ignore
	public void testUpdateIpmi() throws JsonProcessingException
	{
		Ipmi ipmi = new Ipmi();
		ipmi.setHost("10.20.1.1");
		ipmi.setUsername("administrator");
		ipmi.setPassword("administrator");
		
		Server server = serverApi.updateIpmi("1424bf6c-2443-4e3b-83f7-c972e0a6472a", ipmi);
		System.out.println(om.writeValueAsString(server));
	}
	
	@Test
	@Ignore
	public void testUpdateAsset() throws JsonProcessingException
	{
		Asset asset = new Asset();
		asset.setCode("0");
		asset.setManufacturer("ibm");
		asset.setModal("active");
		asset.setSerialsNo("001");
		asset.setContacter("open");
		asset.setTelephone("101");
		asset.setNote("administrator");
		
		Server server = serverApi.updateAsset("1424bf6c-2443-4e3b-83f7-c972e0a6472a", asset);
		System.out.println(om.writeValueAsString(server));
	}
	
	@Test
	@Ignore
	public void testDeleteServer()
	{
		serverApi.deleteServer("f21a87a4-153a-460b-9878-e45c8249da69");
	}
}
