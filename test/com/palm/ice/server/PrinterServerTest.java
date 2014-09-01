package com.palm.ice.server;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.ice.util.SpringHelper;

public class PrinterServerTest {
	private PrinterServer printerServer;

	@Before
	public void setUp() throws Exception {
		printerServer = SpringHelper.getBean("printerServer");
	}

	@Test
	public void testStartServer() {
		printerServer.startServer();
	}

	@After
	public void tearDown() throws Exception {
		
	}

}
