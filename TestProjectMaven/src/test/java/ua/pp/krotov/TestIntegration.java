package ua.pp.krotov;

import static org.testng.AssertJUnit.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestIntegration {
	private WebDriver driver;
	@BeforeClass 
	public void setUp() throws MalformedURLException{
		driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://www.walletone.com/wallet/client/");
	}
	@Test 
	public void gotoSeleniumPage() {
		//действия
		WebElement element1 = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div[1]/div[2]/input"));
		element1.clear();
		element1.sendKeys("79787818923");
		WebElement element2 = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/div[2]/div/div[1]/div/div[1]/div[2]/div[2]/div[2]/input"));
		element2.clear();
		element2.sendKeys("didiaj2009");	
		WebElement element3 = driver.findElement(By.xpath("html/body/div[2]/div[2]/div/div[1]/div[2]/div/div[1]/div/div[4]/span"));
		element3.click();
		//проверки
		assertEquals("Wallet One", driver.getTitle());
		//Проверить частичное совподание тектста
		assertTrue(driver.findElement(By.className("j95twrd13c1wgy41__title")).getText().contains("Единый"));
		//Проверить полное совподание текста
		assertTrue(driver.findElement(By.xpath("html/body/div[2]/div/div[2]/div[2]")).getText().equals("для вашего бизнеса"));
		WebElement element4 = driver.findElement(By.className("x11taroo4xucjkew__button_caption"));
		element4.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		// проверяем наличие элемента https://img.w1.ru/eutxg7
		if(driver.findElement(By.cssSelector(".tqoa4tr7h0mokreo__logo"))!= null){
			System.out.println("Element is Present");
			}else{
			System.out.println("Element is Absent");
			}
	}
	@AfterClass 
	public void tearDown() {
		driver.quit();
	}

}

