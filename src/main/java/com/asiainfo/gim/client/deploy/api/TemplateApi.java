package com.asiainfo.gim.client.deploy.api;

import java.util.List;

import com.asiainfo.gim.client.auth.api.AbstrackApi;
import com.asiainfo.gim.client.deploy.domain.TemplateConf;
import com.asiainfo.gim.client.deploy.domain.TemplateInfo;

public class TemplateApi extends AbstrackApi {

	public TemplateApi(String endpoint) {
		super(endpoint);
	}
	
	public TemplateConf createOrUpdateTemplate(TemplateConf templateConf){
		String path = "/templateres";
		return restTemplate.post(path, templateConf, null, TemplateConf.class);
	}
	
	public void deleteTemplate(String templateId){
		String path = "/templateres/" + templateId;
		restTemplate.delete(path, null);
	}
	
	public TemplateConf getTemplate(String templateId){
		String path = "/templateres/" + templateId;
		return restTemplate.get(path, null, null, TemplateConf.class);
	}
	
	public List<TemplateInfo> listTemplate(){
		String path = "/templateres";
		return restTemplate.getForList(path, null, null, TemplateInfo.class);
	}

}
