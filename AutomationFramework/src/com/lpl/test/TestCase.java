package com.lpl.test;

import static org.junit.Assert.assertEquals;

import org.junit.*;

import com.lpl.browser.BrowserType;
import com.lpl.device.DeviceType;
import com.lpl.ostype.OsType;
import com.lpl.testframeworktype.TestFrameworkType;
import com.lpl.driver.WebDriverType;

public class TestCase {

	@Test
	public void TestBrowserType() {

		BrowserType browser = BrowserType.Chrome;
		assertEquals(browser, BrowserType.Chrome);

		browser = BrowserType.Firefox;
		assertEquals(browser, BrowserType.Firefox);

		browser = BrowserType.InternetExplorer;
		assertEquals(browser, BrowserType.InternetExplorer);
	}

	@Test
	public void TestOSType() {

		OsType ostype = OsType.Linux;
		assertEquals(ostype, OsType.Linux);

		ostype = OsType.Mac;
		assertEquals(ostype, OsType.Mac);

		ostype = OsType.Win;
		assertEquals(ostype, OsType.Win);

		ostype = OsType.Android;
		assertEquals(ostype, OsType.Android);

		ostype = OsType.Ios;
		assertEquals(ostype, OsType.Ios);
	}

	@Test
	public void TestDeviceType() {

		DeviceType deviceType = DeviceType.Desktop;
		assertEquals(deviceType, DeviceType.Desktop);

		deviceType = DeviceType.Mobile;
		assertEquals(deviceType, DeviceType.Mobile);

		deviceType = DeviceType.Tabs;
		assertEquals(deviceType, DeviceType.Tabs);

	}

	@Test
	public void TestType() {
		TestFrameworkType testType = new TestFrameworkType();
		testType.setTestType("BDD");
		assertEquals(testType.getTestType(), "BDD");

	}

	@Test
	public void DriverType() {
		WebDriverType webDriverType = WebDriverType.ChromeDriver;
		assertEquals(webDriverType, WebDriverType.ChromeDriver);
		webDriverType = webDriverType.FirefoxDriver;
		assertEquals(webDriverType, WebDriverType.FirefoxDriver);
		webDriverType = webDriverType.InternetExplorerDriver;
		assertEquals(webDriverType, WebDriverType.InternetExplorerDriver);

	}
	
	@Test
	public void ConfigProperties() {
		com.lpl.config.ConfigProperties prop = new com.lpl.config.ConfigProperties();
		System.out.println("prop"+prop.getApplication());
		System.out.println("Firm id "+prop.getFirmId());
		System.out.println("Device "+prop.getDevice());
	}
	
	@Test
	public void AutomationService() {
		com.lpl.service.AutomationService service = new com.lpl.service.AutomationService();
		service.initialize();
	}

}
