package UITestCases.admin;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import UITestCases.BaseTestCase;
import exception.AssertErrorException;
import exception.UnExpectedException;
import framework.global.Configuration;

import framework.sharedFunctions.HomePage;

import framework.sharedFunctions.Initialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
* Date :2018.07.19
* Owner :  Betty.wang
* @author : Betty.wang
*/


public class DeleteApplication extends BaseTestCase{

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		Configuration.init();
		logger.info("use wercker to create application:"); 			  
		Thread.sleep(5000);
	}
	
	@Before
	public void prepare() throws IOException {

		Configuration.prepare(this.getClass().getName());
		
		 
		setTestName(this.getClass().getName());
		
	}
	
	@Test
	public void test() throws IOException, InterruptedException, AssertErrorException {
		 
		try {
			
			File currentDir = new File("");
			String curDir = currentDir.getAbsolutePath();
			
			String sysSeq = System.getProperty("file.separator");
			
			boolean verify = true;
			
			logger.info("read file:");
			Properties p = new Properties();
				InputStream ips = new FileInputStream(curDir + sysSeq + "config" + sysSeq + "config.properties");
				p.load(ips);
			logger.info("open wercher:"); 		
			HomePage wap_homepage=new HomePage();
			wap_homepage.openHomePage();
			
			String fpath = p.getProperty("OCI_PRIVATE_KEY_PATH");
			File file=new File(fpath); 
            Long filelength = file.length();
            byte[] filecontent = new byte[filelength.intValue()];
            try {
                FileInputStream in = new FileInputStream(file);
                in.read(filecontent);
                in.close();
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            String api_key = new String(filecontent);
            

			logger.info("input the wercher username from file:");
			driver.findElement(By.id("username")).clear();
		    driver.findElement(By.id("username")).sendKeys(new String[] { p.getProperty("WERCKER_USERNAME") });
		    logger.info("input the wercher password from file:");
		    driver.findElement(By.id("password")).clear();
		    driver.findElement(By.id("password")).sendKeys(new String[] { p.getProperty("WERCKER_PASSWORD") });
		    logger.info("click the login wercher button:");
		    driver.findElement(By.id("login")).click();

		   
		    Thread.sleep(8000);
		    logger.info("if the authorize button display click it:");
	
		    if (driver.findElements( By.id("js-oauth-authorize-btn")).size() != 0) { 
		    	driver.findElement(By.id("js-oauth-authorize-btn")).click();
		    }
		   
		    //find application
		    
		    Thread.sleep(5000);
		    logger.info("click wercher img:");
		    driver.findElement(By.xpath(".//*[@id='root']/div/div[1]/div/div/div/div[1]/a/img")).click();
		    Thread.sleep(5000);
		    if (driver.findElements(By.xpath(".//*[@id='toaster-container']/div[1]/div[1]/div[1]/a")).size() != 0) { 
		    	driver.findElement(By.xpath(".//*[@id='toaster-container']/div[1]/div[1]/div[1]/a")).click();
		    }
		    logger.info("click the exist omstk application:");
		    driver.findElement(By.xpath("//article/div[2]/div/div/div/div/a[.='demo']")).click();
		    Thread.sleep(5000);
		    if (driver.findElements(By.xpath(".//*[@id='toaster-container']/div[1]/div[1]/div[1]/a")).size() != 0) { 
		    	driver.findElement(By.xpath(".//*[@id='toaster-container']/div[1]/div[1]/div[1]/a")).click();
		    }
		    Thread.sleep(3000);
		    logger.info("click the Options tab:");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='environment'])[1]/following::span[2]")).click();
		    Thread.sleep(5000);
		    logger.info("click the Delete application button:");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete'])[1]/following::button[1]")).click();  
		    Thread.sleep(5000);
		    logger.info("click delete button:");
		    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Transfer'])[1]/following::button[2]")).click();
		    Thread.sleep(5000);
		    logger.info("go to step store:");
		    driver.findElement(By.linkText("Steps store")).click();
		    Thread.sleep(5000);
		    logger.info("delete deploy-to-oke step:");
		    
		    if (driver.findElements(By.linkText("deploy-to-oke")).size() != 0) { 
		    	driver.findElement(By.linkText("deploy-to-oke")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Details'])[1]/following::a[1]")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete'])[1]/following::button[1]")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
			    Thread.sleep(5000);
		    }
		    
		    logger.info("delete provision-oke:");
		    if (driver.findElements(By.linkText("provision-oke")).size() != 0) { 
		    	driver.findElement(By.linkText("provision-oke")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Details'])[1]/following::a[1]")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete'])[1]/following::button[1]")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
			    Thread.sleep(5000);
		    }
		   
		    logger.info("delete destroy-oke:");
		    if (driver.findElements(By.linkText("destroy-oke")).size() != 0) { 
		    	driver.findElement(By.linkText("destroy-oke")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Details'])[1]/following::a[1]")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Delete'])[1]/following::button[1]")).click();
			    Thread.sleep(5000);
			    driver.findElement(By.xpath("(.//*[normalize-space(text()) and normalize-space(.)='Cancel'])[1]/following::button[1]")).click();
			    Thread.sleep(5000);
		    }
		    
		   
		    logger.info("assert: " + verify); 	
			assertVerify.verifyTrue(verify);
			success();
		}catch (Exception e) {
	    	new UnExpectedException(driver, logger, e);
	    	fail();
	    }
		finally{
			driver.quit();

		}
	}

}

	