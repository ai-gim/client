/**
 * @File: UserApi.java 
 * @Package  com.asiainfo.gim.auth.client.api
 * @Description: 
 * @author luyang
 * @date 2015年7月29日 下午3:02:04 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.auth.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asiainfo.gim.client.auth.domain.User;
import com.asiainfo.gim.client.auth.domain.query.UserQueryCondition;

/**
 * @author luyang
 *
 */
public class UserApi extends AbstrackApi
{
	public UserApi(String endpoint)
	{
		super(endpoint);
	}

	public User findUserById(int id)
	{
		String path = "/user/" + id;
		return restTemplate.get(path, null, null, User.class);
	}

	public List<User> listUsers()
	{
		String path = "/users";
		return restTemplate.getForList(path, null, null, User.class);
	}
	
	public List<User> listUsers(UserQueryCondition userQueryCondition)
	{
		String path = "/users";
		
		Map<String, String> queryParamters = new HashMap<String, String>();
		queryParamters.put("roleId", String.valueOf(userQueryCondition.getRoleId()));
		queryParamters.put("groupId", String.valueOf(userQueryCondition.getGroupId()));
		
		return restTemplate.getForList(path, queryParamters, null, User.class);
	}

	public User addUser(User user)
	{
		String path = "/user";
		return restTemplate.post(path, user, null, User.class);
	}

	/**
	 * password not null,only update password,
	 * password is null,update others。
	 * user不传密码，说明修改一般属性；传密码，说明只是修改密码
	 * @param user
	 * @return
	 */
	public User updateUser(User user)
	{
		String path = "/user/" + user.getId();
		return restTemplate.put(path, user, null, User.class);
	}

	public void deleteUser(int id)
	{
		String path = "/user/" + id;
		restTemplate.delete(path, null);
	}
}
