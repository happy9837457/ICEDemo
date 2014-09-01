package com.palm.ice.client;

import java.util.Map;

import Ice.Communicator;
import Ice.InitializationData;
import Ice.Properties;
import Ice.Util;

import com.palm.ice.ice.PIceBean;
import com.palm.ice.ice.PrinterPrx;
import com.palm.ice.ice.PrinterPrxHelper;

/**
 * ICE客户端调用
 * 
 * @author weixiang.qin
 * 
 */
public class PrinterClient {
	private static Ice.Communicator ic;
	private String name;
	private String protocol;
	private String host;
	private String port;
	private Map<String, String> configPropsMap;

	/**
	 * 
	 * @return
	 */
	public boolean printPIceBean(String lottery, String name) {
		System.out.println("host:" + host + " port:" + port + configPropsMap);
		long start = System.currentTimeMillis();
		PrinterPrx printerPrx = getPrinterPrx();
		System.out.println("connection time:"
				+ (System.currentTimeMillis() - start));
		start = System.currentTimeMillis();
		if (printerPrx == null) {
			throw new Error("Invalid proxy");
		}
		PIceBean pIceBean = new PIceBean();
		pIceBean.lottery = lottery;
		pIceBean.name = name;
		boolean result = printerPrx.printPIceBean(pIceBean);
		System.out.println("use time:" + (System.currentTimeMillis() - start));
		return result;
	}

	private PrinterPrx getPrinterPrx() {
		ic = getCommunicator();
		Ice.ObjectPrx clientPrx = ic.stringToProxy(name + ":" + protocol
				+ " -h " + host + " -p " + port);
		return PrinterPrxHelper.checkedCast(clientPrx);
	}

	private synchronized Communicator getCommunicator() {
		if (ic == null) {
			InitializationData id = new InitializationData();
			id.properties = craeteProperties();
			ic = Ice.Util.initialize(id);
		}
		return ic;
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
