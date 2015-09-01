package com.asiainfo.gim.client.deploy.api;

import com.asiainfo.gim.client.auth.api.AbstrackApi;
import com.asiainfo.gim.client.deploy.domain.KickStartConf;

public class TemplateApi extends AbstrackApi {

	public TemplateApi(String endpoint) {
		super(endpoint);
	}
	
	public KickStartConf createOrUpdateTemplate(KickStartConf ksConf){
		String path = "/templateres";
		return restTemplate.post(path, ksConf, null, KickStartConf.class);
	}
	
	public void deleteTemplate(String templateId){
		String path = "/templateres/" + templateId;
		restTemplate.delete(path, null);
	}
	
	public KickStartConf getTemplate(String templateId){
		String path = "/templateres/" + templateId;
		return restTemplate.get(path, null, null, KickStartConf.class);
	}

}
