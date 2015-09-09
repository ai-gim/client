package com.asiainfo.gim.client.deploy.api;

import java.io.File;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.glassfish.jersey.media.multipart.BodyPart;
import org.glassfish.jersey.media.multipart.FormDataMultiPart;
import org.glassfish.jersey.media.multipart.file.FileDataBodyPart;

import com.asiainfo.gim.client.auth.api.AbstrackApi;
import com.asiainfo.gim.client.deploy.domain.PostScripts;

public class PostScriptsApi extends AbstrackApi {

	public PostScriptsApi(String endpoint) {
		super(endpoint);
	}
	
	public List<PostScripts> listPostScripts(){
		String path = "/postscripts";
		return restTemplate.getForList(path, null, null, PostScripts.class);
	}
	
	public PostScripts findPostScripts(int id){
		String path = "/postscripts/" + id;
		return restTemplate.get(path, null, null, PostScripts.class);
	}
	
	public void deletePostScripts(int id){
		String path = "/postscripts/" + id;
		restTemplate.delete(path, null);
	}
	
	public void updatePostScripts(PostScripts postScripts){
		String path = "/postscripts/" + postScripts.getId();
		restTemplate.put(path, postScripts, null, PostScripts.class);
	}
	
	public PostScripts createPostScripts(PostScripts postScripts){
		String path = "/postscripts";
		return restTemplate.post(path, postScripts, null, PostScripts.class);
	}
	
	public String uploadPostScripts(File scriptsFile, String fileName){
		String path = "/postscripts/fileupload";
		FormDataMultiPart formDataMultiPart = new FormDataMultiPart();
		BodyPart bodyPart = new FileDataBodyPart("file", scriptsFile);
		if(StringUtils.isNotEmpty(fileName)){
			formDataMultiPart.field("fileName", fileName);
		}
		formDataMultiPart.bodyPart(bodyPart);
		return restTemplate.postForFile(path, formDataMultiPart, null, String.class);
	}
	
	public File downPostScripts(String fileName){
		String path = "/postscripts/filedown/" + fileName;
		return restTemplate.get(path, null, null, File.class);
	}

}
