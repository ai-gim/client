package com.asiainfo.gim.client.deploy.api;

import java.util.ArrayList;
import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.asiainfo.gim.client.Constants;
import com.asiainfo.gim.client.deploy.domain.TemplateConf;
import com.asiainfo.gim.client.deploy.domain.TemplateBasicConf;
import com.asiainfo.gim.client.deploy.domain.TemplateInfo;
import com.asiainfo.gim.client.deploy.domain.TemplateLogVolConf;
import com.asiainfo.gim.client.deploy.domain.TemplatePartConf;
import com.asiainfo.gim.client.deploy.domain.TemplateUserConf;
import com.asiainfo.gim.client.deploy.domain.TemplateVolGroupConf;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TemplateApiTest
{
	private static TemplateApi tempApi;
	
	ObjectMapper om = new ObjectMapper();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		tempApi = new TemplateApi(Constants.TEST_DEPLOY_ENDPOINT);
	}

	@Test
	@Ignore
	public void createOrUpdateTemplate() {
		TemplateConf ksConf = new TemplateConf();
		TemplateInfo tempInfo = new TemplateInfo();
		tempInfo.setTemplateId("2837f2c7-069b-433c-a325-216c2049fed1");
		tempInfo.setName("test_template06");
		tempInfo.setDesc("test_template_desc");
		ksConf.setTempInfo(tempInfo );
		List<TemplateBasicConf> tempBaicList = new ArrayList<TemplateBasicConf>();
		TemplateBasicConf basicConf1 = new TemplateBasicConf();
		basicConf1.setAttr("lang");
		basicConf1.setValue("en_US");
		TemplateBasicConf basicConf2 = new TemplateBasicConf();
		basicConf2.setAttr("timezone");
		basicConf2.setValue("US/Eastern");
		TemplateBasicConf basicConf3 = new TemplateBasicConf();
		basicConf3.setAttr("rootpw");
		basicConf3.setValue("12678");
		TemplateBasicConf basicConf4 = new TemplateBasicConf();
		basicConf4.setAttr("selinux");
		basicConf4.setValue("disabled");
		TemplateBasicConf basicConf5 = new TemplateBasicConf();
		basicConf5.setAttr("firewall");
		basicConf5.setValue("disabled");
		tempBaicList.add(basicConf1 );
		tempBaicList.add(basicConf2 );
		tempBaicList.add(basicConf3 );
		tempBaicList.add(basicConf4 );
		tempBaicList.add(basicConf5 );
		ksConf.setTempBaicList(tempBaicList );
		List<TemplatePartConf> tempPartList = new ArrayList<TemplatePartConf>();
		TemplatePartConf part = new TemplatePartConf();
		part.setMntPoint("pv.10");
		part.setSize(1000000);
		tempPartList.add(part );
		ksConf.setTempPartList(tempPartList );
		List<TemplateVolGroupConf> tempVGList = new ArrayList<TemplateVolGroupConf>();
		TemplateVolGroupConf vg = new TemplateVolGroupConf();
		vg.setName("myvg");
		vg.setPartition("pv.10");
		tempVGList.add(vg );
		ksConf.setTempVGList(tempVGList );
		List<TemplateLogVolConf> tempLVList = new ArrayList<TemplateLogVolConf>();
		TemplateLogVolConf logvol = new TemplateLogVolConf();
		logvol.setMntPoint("/");
		logvol.setName("lv");
		logvol.setVgName("myvg");
		logvol.setSize(3000);
		tempLVList.add(logvol );
		ksConf.setTempLVList(tempLVList );
		List<TemplateUserConf> tempUserList = new ArrayList<TemplateUserConf>();
		TemplateUserConf user = new TemplateUserConf();
		user.setName("admin");
		user.setPassword("1234560");
		tempUserList.add(user );
		ksConf.setTempUserList(tempUserList);
		
		tempApi.createOrUpdateTemplate(ksConf );
		
	}

	@Test
	@Ignore
	public void getTemplate() throws JsonProcessingException {
		String templateId = "51a5a341-a914-484d-8b0e-304ae7a36575";
		TemplateConf kickStartConf = tempApi.getTemplate(templateId);
		
	}

	@Test
	@Ignore
	public void deleteTemplate() throws JsonProcessingException {
		String templateId = "f09916d5-9451-49fc-a766-adcaafd6eb7c";
		tempApi.deleteTemplate(templateId);
	}
	
	@Test
	@Ignore
	public void listTemplate() throws JsonProcessingException {
		List<TemplateInfo> tempList = tempApi.listTemplate();
	}

}
