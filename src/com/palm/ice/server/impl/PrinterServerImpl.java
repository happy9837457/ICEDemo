package com.palm.ice.server.impl;

import java.util.Map;

import Ice.Current;

import com.palm.ice.ice.PIceBean;
import com.palm.ice.ice._PrinterDisp;

/**
 * ICE接口实现
 * 
 * @author weixiang.qin
 * 
 */
public class PrinterServerImpl extends _PrinterDisp {
	private static final long serialVersionUID = -3029701987943534795L;

	@Override
	public boolean printPIceBean(PIceBean bean, Current __current) {
		System.out.println(bean.lottery + " " + bean.name);
		try {
			Thread.sleep(9000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean printPIceBeanArray(PIceBean[] array, Current __current) {
		return false;
	}

	@Override
	public boolean printPIceMap(Map<String, String> map, Current __current) {
		return false;
	}

}
