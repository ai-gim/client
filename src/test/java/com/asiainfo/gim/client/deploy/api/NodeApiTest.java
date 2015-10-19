package com.asiainfo.gim.client.deploy.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.asiainfo.gim.client.Constants;
import com.asiainfo.gim.client.deploy.domain.Node;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class NodeApiTest
{
	private static NodeApi NodeApi;
	
	ObjectMapper om = new ObjectMapper();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		NodeApi = new NodeApi(Constants.TEST_DEPLOY_ENDPOINT);
	}

	@Test
	@Ignore
	public void addNode(){
		Node node = new Node();
		node.setGroups("compute");
		node.setName("testnode01");
		node.setIp("172.16.102.10");
		node.setMac("E8:61:1F:11:6B:3A");
		node.setIntf("eth0");
		node.setNetboot("pxe");
		node.setXcatmaster("172.16.102.141");
		node.setInstallnic("mac");
		node.setPrimarynic("mac");
		node.setNfsserver("172.16.102.141");
		node.setPower("ipmi");
		node.setMgt("ipmi");
		node.setBmc("172.16.102.3");
		node.setBmcusername("admin");
		node.setBmcpassword("admin");
		List<Integer> bootScriptIds = new ArrayList<Integer>();
		bootScriptIds.add(1);
		node.setBootScriptIds(bootScriptIds );
		NodeApi.addNode(node);
	}
	
	@Test
	@Ignore
	public void installos(){
	}
	
	@Test
	@Ignore
	public void getNodeStat(){
		String stat = NodeApi.getNodeStat("testnode02");
//		System.out.println(stat);
	}
	
	@Test
	@Ignore
	public void listNodes() throws JsonProcessingException{
		List<Node> nodeList = NodeApi.listNodes(null);
//		System.out.println(om.writeValueAsString(nodeList));
	}
	
	@Test
	@Ignore
	public void remodeNode(){
		NodeApi.remodeNode("testnode02");
	}

}
