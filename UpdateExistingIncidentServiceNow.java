package week5.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class UpdateExistingIncidentServiceNow extends BaseClassServiceNow {
	@Test
	public void updateExistingIncident() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		WebElement searchIncident = driver.findElement(By.xpath("(//label[text()='Search'])[2]/following::input"));
		searchIncident.sendKeys("INC0000002", Keys.ENTER);

		Thread.sleep(2000);
		driver.findElement(By.linkText("INC0000002")).click();
		WebElement incState = driver.findElement(By.id("incident.state"));
		Select obj1 = new Select(incState);
		obj1.selectByVisibleText("In Progress");
		//System.out.println(incState.getText());

		WebElement incUrgency = driver.findElement(By.xpath("//select[@id='incident.urgency']"));
		Thread.sleep(2000);
		Select obj = new Select(incUrgency);
		obj.selectByVisibleText("1 - High");
		System.out.println(obj);
		WebElement selectedUrgency = obj.getFirstSelectedOption();
		if(selectedUrgency.getText().equals("1 - High"))
		{
			System.out.println("Urgency High is selected...");
		}
		
		WebElement selectedState = obj1.getFirstSelectedOption();
		if(selectedState.getText().equals("In Progress"))
		{
			System.out.println("In Progress is selected...");
		}
	}

}
