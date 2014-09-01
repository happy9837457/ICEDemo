package com.palm.ice.server;

import java.util.Map;

import Ice.InitializationData;
import Ice.Properties;
import Ice.Util;

/**
 * ICE服务器端监听
 * 
 * @author weixiang.qin
 * 
 */
public class PrinterServer {
	private String name;
	private String protocol;
	private String host;
	private String port;
	private Map<String, String> configPropsMap;

	/**
	 * 启动server
	 */
	public void startServer() {
		InitializationData id = new InitializationData();
		id.properties = craeteProperties();
		Ice.Communicator ic = Ice.Util.initialize(id);
		Ice.ObjectAdapter adapter = ic.createObjectAdapterWithEndpoints(
				"adapter", protocol + " -h " + host + " -p " + port);
		Ice.Object servant = new PrinterServiceI();
		adapter.add(servant, ic.stringToIdentity(name));
		adapter.activate();
		ic.waitForShutdown();
		ic.destroy();
	}

	/**
	 * 启动参数
	 * 
	 * @return
	 */
	private Properties craeteProperties() {
		String[] keys = configPropsMap.keySet().toArray(new String[0]);
		Ice.Properties properties = Util.createProperties();
		for (String key : keys) {
			properties.setProperty(key, configPropsMap.get(key));
		}
		return properties;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setProtocol(String protocol) {
		this.protocol = protocol;
	}

	public void setHost(String host) {
		this.host = host;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public void setConfigPropsMap(Map<String, String> configPropsMap) {
		this.configPropsMap = configPropsMap;
	}

}
