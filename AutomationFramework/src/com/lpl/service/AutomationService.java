package com.lpl.service;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.lpl.browser.BrowserType;
import com.lpl.config.ConfigProperties;
import com.lpl.device.DeviceType;
import com.lpl.driver.WebDriverType;
import com.lpl.ostype.OsType;
import com.lpl.testdata.TestData;
import com.lpl.testframeworktype.TestFrameworkType;

import cucumber.api.cli.Main;


public class AutomationService {
	TestFrameworkType type = new TestFrameworkType();
	BrowserType browswerType;
	DeviceType deviceType;
	WebDriverType webdriverType;
	OsType ostype;
	TestData testDataType = new TestData();
	WebDriver driver;
	public AutomationService() {

	}

	public WebDriver initialize() {
		
		ConfigProperties properties = new ConfigProperties();
		System.out.println("properties.getTestFrameworkType()"+properties.getTestFrameworkType());
		type.setTestType(properties.getTestFrameworkType());

		if (properties.getBrowserType().equalsIgnoreCase("Chrome")) {
			browswerType = BrowserType.Chrome;
			webdriverType = WebDriverType.ChromeDriver;
		} else if (properties.getBrowserType().equalsIgnoreCase("Firefox")) {
			browswerType = BrowserType.Firefox;
			webdriverType = WebDriverType.FirefoxDriver;
		} else if (properties.getBrowserType().equalsIgnoreCase("InternetExplorer")) {
			browswerType = BrowserType.InternetExplorer;
			webdriverType = WebDriverType.InternetExplorerDriver;
		}

		if (properties.getDevice().equalsIgnoreCase("desktop")) {
			deviceType = DeviceType.Desktop;
		} else if (properties.getDevice().equalsIgnoreCase("Mobile")) {
			deviceType = DeviceType.Mobile;
		} else if (properties.getDevice().equalsIgnoreCase("tabs")) {
			deviceType = DeviceType.Tabs;
		}

		if (properties.getOS().equalsIgnoreCase("mac")) {
			ostype = OsType.Mac;
		} else if (properties.getOS().equalsIgnoreCase("Android")) {
			ostype = OsType.Android;
		} else if (properties.getOS().equalsIgnoreCase("Ios")) {
			ostype = OsType.Ios;
		} else if (properties.getOS().equalsIgnoreCase("Linux")) {
			ostype = OsType.Linux;
		} else if (properties.getOS().equalsIgnoreCase("Win")) {
			ostype = OsType.Win;
		}
		
		if (ostype == OsType.Win && type.getTestType().equalsIgnoreCase("uitest") ) {
			System.setProperty("webdriver.chrome.driver", "C:\\Softwares\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		return driver;
		
		
	}

	public WebDriver execute() {
		
		System.out.println("ostype"+ostype+"type.getTestType()"+type.getTestType());
		if (ostype == OsType.Win && type.getTestType().equalsIgnoreCase("restapi") ) {
			//invoke a test script 
			String [] argv = new String[]{ "-g","","./Feature/Feature.feature"};
			ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
			try {
				byte exitstatus = Main.run(argv, contextClassLoader);
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		
		} else if (ostype == OsType.Win && type.getTestType().equalsIgnoreCase("uitest") ) {
			System.setProperty("webdriver.chrome.driver", "BrowserServers\\chromedriver.exe");
			driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().pageLoadTimeout(25, TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		}
		return driver;
	}

	

}
