package com.asiainfo.gim.client.auth.api;

import static org.junit.Assert.assertNotNull;

import java.util.List;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.asiainfo.gim.client.ClientTestUtils;
import com.asiainfo.gim.client.Constants;
import com.asiainfo.gim.client.auth.domain.Role;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class RoleApiTest
{

	private static RoleApi roleApi;

	ObjectMapper om = new ObjectMapper();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		roleApi = new RoleApi(Constants.TEST_AUTH_ENDPOINT);

		ClientTestUtils.fetchToken();
	}

	@Before
	public void prepare()
	{
		ClientTestUtils.injectToken();
	}

	@Test
	@Ignore
	public void testFindRoleById() throws JsonProcessingException
	{
		Role role = roleApi.findRoleById(1);
		System.out.println(om.writeValueAsString(role));
		assertNotNull(role);
	}

	@Test
	@Ignore
	public void testListRoles() throws JsonProcessingException
	{
		List<Role> roles = roleApi.listRoles();
		System.out.println(om.writeValueAsString(roles));
		assertNotNull(roles);
	}

	@Test
	@Ignore
	public void testAddRole() throws JsonProcessingException
	{
		Role role = new Role();
		role.setName("admin");
		role = roleApi.addRole(role);
		System.out.println(om.writeValueAsString(role));
	}

	@Test
	@Ignore
	public void testUpdateRole() throws JsonProcessingException
	{
		Role role = new Role();
		role.setName("ad");
		role.setId(3);
		role = roleApi.updateRole(role);
		System.out.println(om.writeValueAsString(role));
	}

	@Test
	@Ignore
	public void testDeleteRole()
	{
		roleApi.deleteRole(1);
	}

}
