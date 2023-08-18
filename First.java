package day1;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;

public class First {

    private WebDriver driver;
    private Map<String, Object> vars;
    private Map<String, Integer> prices;


    JavascriptExecutor js;

    @Before
    public void setUp() {
        driver = new ChromeDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
        prices = new HashMap<String, Integer>();
    }
    @After
    public void Compare() {

        int sum;

        if(prices.get("vatan") < prices.get("apple") && prices.get("vatan") < prices.get("elmavm")){
            System.out.println("Minimum price is in Vatan and price is " + prices.get("vatan"));
            if(prices.get("apple") < prices.get("elmavm"))
                System.out.println("Maximum price is in Elmavm and price is " + prices.get("elmavm"));
            else
                System.out.println("Maximum price is in Apple and price is " + prices.get("apple"));
        }

        else if(prices.get("apple") < prices.get("vatan") && prices.get("apple") < prices.get("elmavm")){
            System.out.println("Minimum price is in Apple and price is " + prices.get("apple"));
            if(prices.get("vatan") < prices.get("elmavm"))
                System.out.println("Maximum price is in Elmavm and price is " + prices.get("elmavm"));
            else
                System.out.println("Maximum price is in Vatan and price is " + prices.get("vatan"));

        }

        else if(prices.get("elmavm") < prices.get("apple") && prices.get("elmavm") < prices.get("vatan")){
            System.out.println("Minimum price is in Elmavm and price is " + prices.get("elmavm"));
            if(prices.get("apple") < prices.get("vatan"))
                System.out.println("Maximum price is in Vatan and price is " + prices.get("vatan"));
            else
                System.out.println("Maximum price is in Apple and price is " + prices.get("apple"));
        }

        sum = prices.get("elmavm") + prices.get("apple") + prices.get("vatan");
        sum/=3;
        System.out.println("Average price is: " + sum);





        driver.quit();

    }



    @Test
    public void TakePrices() {
        driver.get("https://www.vatanbilgisayar.com/");
        driver.manage().window().setSize(new Dimension(1051, 806));
        driver.findElement(By.id("navbar-search-input")).click();
        driver.findElement(By.id("navbar-search-input")).sendKeys("iphone 14");
        driver.findElement(By.id("navbar-search-input")).sendKeys(Keys.ENTER);
        driver.findElement(By.cssSelector(".product-list:nth-child(2) .lazyimg")).click();
        js.executeScript("window.scrollTo(0,589.5999755859375)");
        js.executeScript("window.scrollTo(0,1132)");
        driver.findElement(By.cssSelector(".product-list__price:nth-child(2)")).click();
        driver.findElement(By.cssSelector(".product-list__price:nth-child(2)")).click();
        vars.put("vatanPrice", driver.findElement(By.cssSelector(".product-list__price:nth-child(2)")).getText());
        String vatanPrice = vars.get("vatanPrice").toString();
        vatanPrice = vatanPrice.replaceAll("\\.","");
        prices.put("vatan",Integer.parseInt(vatanPrice));

        driver.get("https://www.apple.com/tr/");
        driver.manage().window().setSize(new Dimension(1051, 798));
        driver.findElement(By.cssSelector(".homepage-section:nth-child(1) > div:nth-child(1) .unit-link")).click();
        driver.findElement(By.cssSelector(".ac-ln-button")).click();
        driver.findElement(By.cssSelector(".rf-bfe-header .price-point > span")).click();
        vars.put("applePrice", driver.findElement(By.cssSelector(".rf-bfe-header .price-point > span")).getText());
        String applePrice = vars.get("applePrice").toString();
        applePrice = applePrice.replaceAll("\\.","");
        applePrice = applePrice.replaceAll(" TL","");
        prices.put("apple",Integer.parseInt(applePrice));


        driver.get("https://www.elmavm.com/");
        driver.manage().window().setSize(new Dimension(1053, 807));
        driver.findElement(By.id("s")).click();
        driver.findElement(By.id("s")).sendKeys("iphone 14");
        driver.findElement(By.cssSelector(".searchform-popup:nth-child(2) > .searchform .fa")).click();
        driver.findElement(By.cssSelector(".product-col:nth-child(1) .hover-image")).click();
        driver.findElement(By.cssSelector(".summary bdi")).click();
        driver.findElement(By.cssSelector(".summary bdi")).click();
        vars.put("elmavmPrice", driver.findElement(By.cssSelector(".summary bdi")).getText());
        String elmavmPrice = vars.get("elmavmPrice").toString();
        elmavmPrice = elmavmPrice.replaceAll("\\.","");
        elmavmPrice = elmavmPrice.replaceAll(",00 ₺","");
        prices.put("elmavm",Integer.parseInt(elmavmPrice));
    }


   
}