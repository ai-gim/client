/**   
 * @Title: GroupApi.java 
 * @Package com.asiainfo.gim.auth.client.api 
 * @Description: TODO(用一句话描述该文件做什么) 
 * @author zhangli
 * @date 2015年7月27日 下午2:13:56 
 * @version V1.0   
 */
package com.asiainfo.gim.client.auth.api;

import java.util.List;

import com.asiainfo.gim.client.auth.domain.Group;

/**
 * @author zhangli
 *
 */
public class GroupApi extends AbstrackApi
{
	public GroupApi(String endpoint)
	{
		super(endpoint);
	}

	public Group findGroupById(int id)
	{
		String path = "/group/" + id;
		return restTemplate.get(path, null, null, Group.class);
	}

	public List<Group> listGroups()
	{
		String path = "/groups";
		return restTemplate.getForList(path, null, null, Group.class);
	}

	public Group addGroup(Group group)
	{
		String path = "/group";
		return restTemplate.post(path, group, null, Group.class);
	}

	public Group updateGroup(Group group)
	{
		String path = "/group/" + group.getId();
		return restTemplate.put(path, group, null, Group.class);
	}

	public void deleteGroup(int id)
	{
		String path = "/group/" + id;
		restTemplate.delete(path, null);
	}
}
