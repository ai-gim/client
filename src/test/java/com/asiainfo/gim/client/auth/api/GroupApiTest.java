package com.asiainfo.gim.client.auth.api;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.asiainfo.gim.client.ClientTestUtils;
import com.asiainfo.gim.client.Constants;
import com.asiainfo.gim.client.auth.domain.Group;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class GroupApiTest
{

	private static GroupApi groupApi;

	ObjectMapper om = new ObjectMapper();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		groupApi = new GroupApi(Constants.TEST_AUTH_ENDPOINT);

		ClientTestUtils.fetchToken();
	}

	@Before
	public void prepare()
	{
		ClientTestUtils.injectToken();
	}

	@Test
	@Ignore
	public void testFindGroupById() throws JsonProcessingException
	{
		Group group = groupApi.findGroupById(1);
		System.out.println(om.writeValueAsString(group));
		assertNotNull(group);
	}

	@Test
	@Ignore
	public void testListGroups() throws JsonProcessingException
	{
		List<Group> groups = groupApi.listGroups();
		System.out.println(om.writeValueAsString(groups));
		assertNotNull(groups);
	}

	@Test
	@Ignore
	public void testAddGroup() throws JsonProcessingException
	{
		Group group = new Group();
		group.setName("a2");
		group = groupApi.addGroup(group);
		System.out.println(om.writeValueAsString(group));
	}

	@Test
	@Ignore
	public void testUpdateGroup() throws JsonProcessingException
	{
		Group group = new Group();
		group.setName("ad");
		group.setId(4);
		group = groupApi.updateGroup(group);
		System.out.println(om.writeValueAsString(group));
	}

	@Test
	@Ignore
	public void testDeleteGroup()
	{
		groupApi.deleteGroup(8);
	}

}
