package week5.day1;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class DeleteIncident extends BaseClassServiceNow {
	@Test
	public void deleteIncident() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		WebElement searchIncident = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		searchIncident.sendKeys("INC0000017", Keys.ENTER);

		Thread.sleep(2000);
		WebElement incNumber = driver.findElement(By.linkText("INC0000017"));
		incNumber.click();
		
		driver.findElement(By.xpath("//button[text() = 'Delete']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@id='ok_button']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input")).sendKeys("INC0000017", Keys.ENTER);
		String delrecord = driver.findElement(By.xpath("//td[text()='No records to display']")).getText();
		if(delrecord.equals("No records to display")) {
			System.out.println("The Record is deleted");
		} else {
				System.out.println("The record is not Deleted");
			}

	}

}