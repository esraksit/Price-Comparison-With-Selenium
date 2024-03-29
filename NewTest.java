package day1;

import org.testng.annotations.Test;

import org.testng.annotations.BeforeSuite;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class NewTest {
	
	WebDriver driver;
	 WebDriver firefoxDriver;
 
  @BeforeSuite
  public void beforeSuite() {
	  System.out.print("Test initialize\n");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.print("\nTest finished");
  }
  
  
  @Test
  public void LoginWithChrome() throws InterruptedException {

      driver= new ChromeDriver();
      driver.get("https://webmailstudent.cankaya.edu.tr/");
      Thread.sleep(1000);

      driver.findElement(By.id("rcmloginuser")).sendKeys("c1928011");

      Thread.sleep(1000);

     driver.findElement(By.id("rcmloginpwd")).sendKeys("123");
      Thread.sleep(1000);

      driver.findElement(By.id("rcmloginsubmit")).click();
      Thread.sleep(1000);

      String message = driver.findElement(By.id("messagestack")).getText();
      driver.quit();

      assertEquals(message , "Oturum a��lamad�.");

      

  }
	
	@Test
  public void LoginWithFirefox() throws InterruptedException {

      firefoxDriver = new FirefoxDriver();
      firefoxDriver.get("https://webmailstudent.cankaya.edu.tr/");
      Thread.sleep(1000);

      firefoxDriver.findElement(By.id("rcmloginuser")).sendKeys("c1928011");

      Thread.sleep(1000);

      firefoxDriver.findElement(By.id("rcmloginpwd")).sendKeys("123asdf789");
            
      Thread.sleep(1000);

      firefoxDriver.findElement(By.id("rcmloginsubmit")).click();
      Thread.sleep(1000);

      String message = firefoxDriver.findElement(By.id("messagestack")).getText();
     
      firefoxDriver.quit();

      assertEquals(message , "Oturum a��lamad�.");

      

  }

}
