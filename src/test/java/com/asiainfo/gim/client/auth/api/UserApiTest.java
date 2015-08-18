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
import com.asiainfo.gim.client.auth.domain.Role;
import com.asiainfo.gim.client.auth.domain.User;
import com.asiainfo.gim.client.auth.domain.query.UserQueryCondition;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserApiTest
{
	public static UserApi userApi;

	ObjectMapper om = new ObjectMapper();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		userApi = new UserApi(Constants.TEST_AUTH_ENDPOINT);

//		ClientTestUtils.fetchToken();
	}

//	@Before
//	public void prepare()
//	{
//		ClientTestUtils.injectToken();
//	}

	@Test
	@Ignore
	public void testFindUserById() throws JsonProcessingException
	{
		User user = userApi.findUserById(1);
		System.out.println(om.writeValueAsString(user));
		assertNotNull(user);
	}

	@Test
	@Ignore
	public void testListUsers() throws JsonProcessingException
	{
		UserQueryCondition userQueryCondition = new UserQueryCondition();
		userQueryCondition.setRoleId(1);
		userQueryCondition.setGroupId(1);
		List<User> users = userApi.listUsers(userQueryCondition);
		System.out.println(om.writeValueAsString(users));
		assertNotNull(users);
	}

	@Test
	@Ignore
	public void testAddUser() throws JsonProcessingException
	{
		User user = new User();
		user.setAccount("admin12");
		user.setPassword("admin");
		user.setState(1);

		Role role = new Role();
		role.setId(1);
		user.setRole(role);

		Group group = new Group();
		group.setId(1);
		user.setGroup(group);

		user = userApi.addUser(user);
		System.out.println(om.writeValueAsString(user));
	}

	@Test
	@Ignore
	public void testUpdateUser() throws JsonProcessingException
	{
		User user = new User();
		user.setName("ad");
		user.setId(2);
//		user.setPassword("admin123");
		user.setState(1);

		Role role = new Role();
		role.setId(1);
		user.setRole(role);

		Group group = new Group();
		group.setId(1);
		user.setGroup(group);

		user = userApi.updateUser(user);
		System.out.println(om.writeValueAsString(user));
	}

	@Test
	@Ignore
	public void testDeleteUser()
	{
		userApi.deleteUser(7);
	}

}
