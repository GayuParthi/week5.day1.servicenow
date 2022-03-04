package week5.day1;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClassServiceNow {
	public static RemoteWebDriver driver;
	@BeforeMethod
	public void beforeMethod() throws InterruptedException {
	WebDriverManager.chromedriver().setup();
	driver = new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("https://dev79001.service-now.com");
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
	driver.switchTo().frame("gsft_main");
	driver.findElement(By.xpath("//input[@id ='user_name']")).sendKeys("admin");
	driver.findElement(By.xpath("//input[@id ='user_password']")).sendKeys("Moun!shParth!1");
	driver.findElement(By.xpath("//button[@id ='sysverb_login']")).click();
	driver.findElement(By.xpath("//input[@id= 'filter']")).sendKeys("incident");
	Thread.sleep(2000);
	driver.findElement(By.xpath("//input[@id='filter']")).sendKeys("");
	driver.findElement(By.xpath("//input[@id='filter']")).sendKeys(Keys.ENTER);//To enter into incident
	}
	

}
