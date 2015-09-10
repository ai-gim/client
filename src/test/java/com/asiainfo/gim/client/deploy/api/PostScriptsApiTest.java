package com.asiainfo.gim.client.deploy.api;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.asiainfo.gim.client.Constants;
import com.asiainfo.gim.client.deploy.domain.PostScripts;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class PostScriptsApiTest
{
	private static PostScriptsApi postScriptsApi;
	
	ObjectMapper om = new ObjectMapper();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		postScriptsApi = new PostScriptsApi(Constants.TEST_DEPLOY_ENDPOINT);
	}

	@Test
	@Ignore
	public void createPostScripts() {
		PostScripts postScripts = new PostScripts();
		postScripts.setName("scripts01");
		postScripts.setDesc("postscripts01");
		postScripts.setFileName("testSctipts");
		postScriptsApi.createPostScripts(postScripts);
	}
	
	@Test
	@Ignore
	public void findPostScripts() throws JsonProcessingException{
		PostScripts scripts = postScriptsApi.findPostScripts(2);
//		System.out.println(om.writeValueAsString(scripts));
	}
	
	@Test
	@Ignore
	public void listPostScripts() throws JsonProcessingException{
		List<PostScripts> list = postScriptsApi.listPostScripts();
//		System.out.println(om.writeValueAsString(list));
	}
	
	@Test
	@Ignore
	public void deletePostScripts(){
		postScriptsApi.deletePostScripts(1);
	}
	
	@Test
	@Ignore
	public void updatePostScripts() {
		PostScripts postScripts = new PostScripts();
		postScripts.setId(3);
		postScripts.setName("scripts01");
		postScripts.setDesc("postscripts01");
		postScriptsApi.updatePostScripts(postScripts);
	}
	
	@Test
	@Ignore
	public void uploadPostScripts(){
		File file = new File("E:/bak/config");
		String fileName = postScriptsApi.uploadPostScripts(file, "");
//		System.out.println(fileName);
	}
	
	@Test
	@Ignore
	public void downPostScripts() throws IOException{
		File file = postScriptsApi.downPostScripts("custom_b9e656ae-5610-47dc-bebf-3ffc856c2283");
		StringBuffer sb = new StringBuffer();
		byte[] bb = new byte[256];
		InputStream in = new FileInputStream(file);
		int len = 0;
		while((len = in.read(bb)) != -1){
			sb.append(new String(bb, 0, len));
		}
//		System.out.println(sb.toString());
	}


}
