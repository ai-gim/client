package com.asiainfo.gim.client.deploy.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.asiainfo.gim.client.auth.api.AbstrackApi;
import com.asiainfo.gim.client.deploy.domain.Node;

public class NodeApi extends AbstrackApi {

	public NodeApi(String endpoint) {
		super(endpoint);
	}
	
	public Node addNode(Node node){
		String path = "/noderes";
		return restTemplate.post(path, node, null, Node.class);
	}

	public void installos(Node node) {
		String path = "/noderes/installos";
		restTemplate.post(path, node, null, String.class);
	}

	public String getNodeStat(String nodeName) {
		String path = "/noderes/stat/" + nodeName;
		Map<String, String> statMap = restTemplate.get(path, null, null,
				HashMap.class);
		for (String key : statMap.keySet()) {
			return statMap.get(key);
		}
		return null;
	}
	
	public List<Node> listNodes(String nodeRange){
		String path = "/noderes/" + nodeRange;
		return restTemplate.getForList(path, null, null, Node.class);
	}
	
	public void remodeNode(String nodeRange){
		String path = "/noderes/" + nodeRange;
		restTemplate.delete(path, null);
	}

}
