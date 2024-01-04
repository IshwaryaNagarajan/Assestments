package sample;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class winjittechnologies {


	@Test
	public  void sample() throws InterruptedException, IOException   {
		
		ChromeDriver driver = new ChromeDriver();
		driver.navigate().to("https://www.globalsqa.com/demo-site/draganddrop/");
		driver.manage().window().maximize();
		
		// DRAG and DROP
		WebElement iframe= driver.findElement(By.xpath("//*[@class='demo-frame lazyloaded']"));		
		driver.switchTo().frame(iframe);
		WebElement image1 = driver.findElement(By.xpath("(//*[@class='ui-widget-content ui-corner-tr ui-draggable ui-draggable-handle'])[1]"));
		WebElement image2= driver.findElement(By.xpath("//*[@alt='The chalet at the Green mountain lake']"));
		WebElement image3= driver.findElement(By.xpath("//*[@alt='Planning the ascent']"));		
		WebElement image4= driver.findElement(By.xpath("//*[@alt='On top of Kozi kopka']"));
		Actions builder = new Actions(driver);
		WebElement trash= driver.findElement(By.xpath("//*[@id='trash']"));
		Action dragAndDrop1 = builder.clickAndHold(image1)
				.moveToElement(trash)
				.release(trash)
				.build();
		dragAndDrop1.perform();		
		Action dragAndDrop2 = builder.clickAndHold(image2)
				.moveToElement(trash)
				.release(trash)
				.build();
		dragAndDrop2.perform();
		Action dragAndDrop3 = builder.clickAndHold(image3)
				.moveToElement(trash)
				.release(trash)
				.build();
		dragAndDrop3.perform();
		Action dragAndDrop4 = builder.clickAndHold(image4)
				.moveToElement(trash)
				.release(trash)
				.build();
		dragAndDrop4.perform();		
		File filesrc = driver.getScreenshotAs(OutputType.FILE);
		File filedes= new File("./snaps/img.png");
		FileHandler.copy(filesrc, filedes);		
		driver.switchTo().parentFrame();
		
		//DROP DOWN
		driver.findElement(By.xpath("(//span[contains(text(),'DropDown Menu')])[2]")).click();
		WebElement select = driver.findElement(By.xpath("//select"));
		Select dropdown = new Select(select);
		dropdown.selectByVisibleText("India");		
		File filesrc1 = driver.getScreenshotAs(OutputType.FILE);
		File filedes1= new File("./snaps/img1.png");
		FileHandler.copy(filesrc1, filedes1);
		
		// FORM		
		driver.navigate().to("https://www.globalsqa.com/samplepagetest/");
		driver.manage().window().maximize();
		WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(3));
		WebElement  name_textbox= driver.findElement(By.xpath("//*[@id='g2599-name']"));
		name_textbox.click();	
		name_textbox.sendKeys("Name");
		name_textbox.sendKeys(Keys.TAB);
		
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("Email@gmail.com");
		driver.findElement(By.xpath("//input[@type='url']")).sendKeys("https://www.google.com");
		WebElement selectyears = driver.findElement(By.xpath("//*[@name='g2599-experienceinyears']"));
		Select dropdownyears = new Select(selectyears);
		dropdownyears.selectByVisibleText("5-7");
		WebElement  education = driver.findElement(By.xpath("//*[contains(text(),'Expertise')]"));
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].scrollIntoView(true);", education);
		driver.findElement(By.xpath("//*[@value='Automation Testing']")).click();
		driver.findElement(By.xpath("//*[@value='Post Graduate']")).click();
		WebElement commentbox = driver.findElement(By.xpath("//*[@id='contact-form-comment-g2599-comment']"));
		commentbox.sendKeys("Comment");
		WebElement submit =driver.findElement(By.xpath("//*[@type='submit']"));
		executor.executeScript("arguments[0].scrollIntoView(true);", commentbox);
		driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();
		driver.findElement(By.xpath("//*[contains(text(),'go back')]")).isDisplayed();
		
		File filesrc2 = driver.getScreenshotAs(OutputType.FILE);
		File filedes2= new File("./snaps/img2.png");
		FileHandler.copy(filesrc2, filedes2);
	
		
	}}
		
					
			
			
			
			
			
		
			
			
	