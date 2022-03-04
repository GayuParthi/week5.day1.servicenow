package week5.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.Keys;
//import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class AssignIncident extends BaseClassServiceNow{
	@Test
	public void assignIncident() throws InterruptedException {
		driver.findElement(By.xpath("//div[text()='Open']")).click();
		Thread.sleep(2000);
		driver.switchTo().frame("gsft_main");
		driver.findElement(By.linkText("INC0000002")).click();
		Thread.sleep(2000);
		//WebElement group = driver.findElement(By.id("sys_display.incident.assignment_group"));
		
		//String text = group.getAttribute("value");
		//System.out.println(text);
       // group.clear();
       // group.sendKeys("Software");
        //group.click();
		driver.findElement(By.xpath("//button[@id='lookup.incident.assignment_group']//span[1]")).click();
		Set<String> windowHandles = driver.getWindowHandles();
		System.out.println(windowHandles);
		List<String>list=new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1)); 
		WebElement searchGroup = driver.findElement(By.xpath("//input[@class='form-control']"));
		System.out.println(searchGroup.getText());
		searchGroup.sendKeys("Software"+"\n");
		
		
		driver.findElement(By.linkText("Software")).click();
		driver.switchTo().window(list.get(0));
		Thread.sleep(5000);
		driver.switchTo().frame("gsft_main");
        driver.findElement(By.id("activity-stream-textarea")).sendKeys("Work Notes are  used to communicate information about state transitions");
        
        driver.findElement(By.xpath("//button[text()='Update']")).click();
		Thread.sleep(2000);
		driver.findElement(By.linkText("INC0000002")).click();
		Thread.sleep(2000);
		WebElement group1 = driver.findElement(By.id("sys_display.incident.assignment_group"));
		
		String text1 = group1.getAttribute("value");
		if(text1.equals("Software")) {
			System.out.println("The Group is Updated successfully... ");
		}
		
		

}
}