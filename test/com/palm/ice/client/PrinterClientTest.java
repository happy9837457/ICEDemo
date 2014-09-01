package com.palm.ice.client;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.palm.ice.util.SpringHelper;

public class PrinterClientTest {
	private PrinterClient printerClient;

	@Before
	public void setUp() throws Exception {
		printerClient = SpringHelper.getBean("printerClient");
	}

	@Test
	public void testPrintPIceBean() {
		printerClient.printPIceBean("SSQ", "双色球");
	}

	@After
	public void tearDown() throws Exception {
		
	}
}
