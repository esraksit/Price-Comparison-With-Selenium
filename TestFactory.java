package day1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeTest;

public class TestFactory {
	
	private WebDriver driver;
	private String id,password;
	
	public TestFactory( String id,String password) {
		this.id=id;
		this.password=password;
	}
	@BeforeTest                                              
	  public void before_test()  
	  {  
	      System.out.println("It will be executed first");  
	  }  
	@Test
    public void LoginWithChrome2() throws InterruptedException {
		
        driver= new ChromeDriver();
        driver.get("https://webmailstudent.cankaya.edu.tr/");
        Thread.sleep(1000);

        driver.findElement(By.id("rcmloginuser")).sendKeys(id);

        Thread.sleep(1000);

       driver.findElement(By.id("rcmloginpwd")).sendKeys(password);
        Thread.sleep(1000);

        driver.findElement(By.id("rcmloginsubmit")).click();
        Thread.sleep(1000);

        String message = driver.findElement(By.id("messagestack")).getText();
        driver.quit();

        assertEquals(message , "Oturum açýlamadý.");

        

    }
	
}

