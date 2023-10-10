package selenium;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class NewTest {
	WebDriver driver;
	 
	@Test(priority=0)
	public void signup() throws Exception {
		
		driver.get("http://10.82.180.36/Common/Login.aspx");
		Thread.sleep(2000);
		driver.findElement(By.id("body_lbtSignUp")).click();
		Thread.sleep(2000);
		 File scrnsht=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(scrnsht, new File("C:\\Users\\deepshikha13\\Documents\\Accelerate_Work\\Scrnsht\\Signup\\scr.jpeg"));
	}
	@Test(priority=1)
	public void pass() throws Exception {
		driver.get("http://10.82.180.36/Common/Login.aspx");
		Thread.sleep(2000);
		driver.findElement(By.id("body_lbtForgotPassword")).click();
		Thread.sleep(2000);
		File scrnsht1=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(scrnsht1, new File("C:\\Users\\deepshikha13\\Documents\\Accelerate_Work\\Scrnsht\\ForgetPassword\\scr1.jpeg"));
	}
	int i;
  @Test(priority=2 , dataProvider="provider")
  public void login(String username ,String password) throws Exception {
	  driver.get("http://10.82.180.36/Common/Login.aspx");
	  Thread.sleep(2000);
	  driver.findElement(By.id("body_txtUserID")).sendKeys(username);
	  Thread.sleep(2000);
	  driver.findElement(By.id("body_txtPassword")).sendKeys(password);
	  Thread.sleep(2000);
	  driver.findElement(By.id("body_btnLogin")).click();
	  Thread.sleep(2000);
	  File scrnsht2=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrnsht2, new File("C:\\Users\\deepshikha13\\Documents\\Accelerate_Work\\Scrnsht\\Login\\scrn"+i+".jpeg"));
	  i++;
  }
  @Test(priority=3)
  public void logout() throws Exception {
	  driver.get("http://10.82.180.36/Common/Login.aspx");
	  Thread.sleep(2000);
	  driver.findElement(By.id("body_txtUserID")).sendKeys("donhere");
	  Thread.sleep(2000);
	  driver.findElement(By.id("body_txtPassword")).sendKeys("don@123");
	  Thread.sleep(2000);
	  driver.findElement(By.id("body_btnLogin")).click();
	  Thread.sleep(2000);
	  File scrnsht3=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrnsht3, new File("C:\\Users\\deepshikha13\\Documents\\Accelerate_Work\\Scrnsht\\Logout\\scrn1.jpeg"));
	  driver.findElement(By.id("lbLoginOut")).click();
	  Thread.sleep(2000);
	  File scrnsht4=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrnsht4, new File("C:\\Users\\deepshikha13\\Documents\\Accelerate_Work\\Scrnsht\\Logout\\scrn2.jpeg"));
	  driver.navigate().back();
	  Thread.sleep(2000);
	  File scrnsht5=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	  FileUtils.copyFile(scrnsht5, new File("C:\\Users\\deepshikha13\\Documents\\Accelerate_Work\\Scrnsht\\Logout\\scrn3.jpeg"));
 }
  @BeforeClass
  public void beforeClass() throws Exception {
	  System.setProperty("webdriver.chrome.driver", "C:\\Users\\deepshikha13\\Desktop\\Chrome-Driver Path\\chromedriver-win64\\chromedriver.exe");
	  driver=new ChromeDriver();
	  Thread.sleep(2000);
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
  }
  @AfterClass
  public void afterClass() throws Exception {
	  //driver.close();
	  driver.quit();
  }
  @DataProvider(name = "provider")
  public Object[][] data(){
	  Object[][] arr=new Object[6][2];
	  arr[0][0]="";
	  arr[0][1]="don@123";
	  
	  arr[1][0]="donhere";
	  arr[1][1]="";
	  
	  arr[2][0]="konhere";
	  arr[2][1]="kon@123";
	  
	  arr[3][0]="";
	  arr[3][1]="";
	  
	  arr[4][0]="donhere";
	  arr[4][1]="don@123";
	  
	  arr[5][0]="DONHERE";
	  arr[5][1]="don@123";
	  return arr;
}

}
