package com.asiainfo.gim.client.deploy.api;

import java.util.List;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

import com.asiainfo.gim.client.Constants;
import com.asiainfo.gim.client.deploy.domain.Distro;
import com.asiainfo.gim.client.deploy.domain.Image;
import com.asiainfo.gim.client.deploy.domain.IsoFile;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class ImageApiTest
{
	private static ImageApi imageApi;
	
	ObjectMapper om = new ObjectMapper();
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
		imageApi = new ImageApi(Constants.TEST_DEPLOY_ENDPOINT);
	}

	@Test
	@Ignore
	public void createOsimage() {
		Image image = new Image();
		image.setIsoFile("CentOS-6.6-x86_64-bin-DVD1.iso");
		image.setOsarch("x86_64");
		image.setOsvers("centos6.6");
		imageApi.createOsImage(image);
	}

	@Test
	@Ignore
	public void listImages() throws JsonProcessingException {
		List<Image> imagelist = imageApi.listImages();
	}

	@Test
	@Ignore
	public void listDistros() throws JsonProcessingException {
		List<Distro> distrolist = imageApi.listDistros();
	}

	@Test
	@Ignore
	public void deleteDistro() {
		imageApi.deleteDistro("rhels6.5-x86_64");
	}
	
	@Test
	@Ignore
	public void listIsoFiles() throws JsonProcessingException {
		List<IsoFile> isoList = imageApi.listIsoFile("F:/迅雷下载/xcat/iso");
	}

}
