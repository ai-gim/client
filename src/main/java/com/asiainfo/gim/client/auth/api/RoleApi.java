/**
 * @File: RoleApi.java 
 * @Package  com.asiainfo.gim.auth.client.api
 * @Description: 
 * @author luyang
 * @date 2015年7月29日 上午10:19:33 
 * @version V1.0
 * 
 */
package com.asiainfo.gim.client.auth.api;

import java.util.List;

import com.asiainfo.gim.client.auth.domain.Role;

/**
 * @author luyang
 *
 */
public class RoleApi extends AbstrackApi
{
	public RoleApi(String endpoint)
	{
		super(endpoint);
	}

	public Role findRoleById(int id)
	{
		String path = "/role/" + id;
		return restTemplate.get(path, null, null, Role.class);
	}

	public List<Role> listRoles()
	{
		String path = "/roles";
		return restTemplate.getForList(path, null, null, Role.class);
	}

	public Role addRole(Role role)
	{
		String path = "/role";
		return restTemplate.post(path, role, null, Role.class);
	}

	public Role updateRole(Role role)
	{
		String path = "/role/" + role.getId();
		return restTemplate.put(path, role, null, Role.class);
	}

	public void deleteRole(int id)
	{
		String path = "/role/" + id;
		restTemplate.delete(path, null);
	}
}
