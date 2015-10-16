package com.asiainfo.gim.client.deploy.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asiainfo.gim.client.auth.api.AbstrackApi;
import com.asiainfo.gim.client.deploy.domain.Image;
import com.asiainfo.gim.client.deploy.domain.ImageDefaultConf;
import com.asiainfo.gim.client.deploy.domain.IsoFile;

public class ImageApi extends AbstrackApi {

	public ImageApi(String endpoint) {
		super(endpoint);
	}
	
	public void createImage(Image image){
		String path = "/imageres";
		restTemplate.post(path, image, null, Image.class);
	}
	
	public void updateImageTemplate(Image image){
		String path = "/imageres/images/" + image.getImagename();
		restTemplate.put(path, image, null, String.class);
	}
	
	public List<Image> listImages(){
		String path = "/imageres/images";
		return restTemplate.getForList(path, null, null, Image.class);
	}
	
	public void deleteImage(int imageId){
		String path = "/imageres/images/" + imageId;
		restTemplate.delete(path, null);
	}
	
	public Image getImage(int imageId){
		String path = "/imageres/images/" + imageId;
		return restTemplate.get(path, null, null, Image.class);
	}
	
	public List<ImageDefaultConf> listImageDefaultConf(){
		String path = "/imageres/imagetypes";
		return restTemplate.getForList(path, null, null, ImageDefaultConf.class);
	}
	
	public List<IsoFile> listIsoFile(String isoDir){
		String path = "/imageres/isofiles";
		Map<String, String> queryParamters = new HashMap<String, String>();
		queryParamters.put("isodir", isoDir);
		return restTemplate.getForList(path, queryParamters , null, IsoFile.class);
	}

}
