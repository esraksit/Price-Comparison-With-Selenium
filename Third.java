package day1;
import org.testng.annotations.Test;
import org.testng.annotations.Factory;
import org.testng.annotations.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.assertEquals;



public class Third {
	
	
	@Factory
	public Object[] factoryMethod() {
		 Object[] factory =new Object[2];
		 factory[0]= new TestFactory("c1928011","123asdf789");
		 factory[1]= new TestFactory("c1928011","ýwhdýa");
		 
		 	return factory;
	}

}
