package TestScript;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestChan {
	WebDriver driver;
	@BeforeMethod
	  public void setup() throws InterruptedException {
	      System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver.exe");
	      driver = new ChromeDriver();
	      driver.manage().window().maximize();
	      driver.get("https://spiderum.com");
	      
	      driver.findElement(By.xpath("(//i[contains(@class, 'fa-times-circle')])[1]")).click();
	      WebElement link = driver.findElement(By.linkText("Đăng nhập"));
	      link.click();

	      driver.findElement(By.id("name")).sendKeys("phanlengoctri");
	      Thread.sleep(1000);
	      driver.findElement(By.id("password")).sendKeys("ngoctri12");
	      Thread.sleep(1000);
	      driver.findElement(By.id("submit-btn")).click();
	      Thread.sleep(2000);
	      driver.findElement(By.xpath("//button[contains(@class,'button-secondary')]")).click();
	      Thread.sleep(1000);
	  }
  @Test(priority = 0)
  public void Testcase01() throws InterruptedException, AWTException {
	  	Robot robot = new Robot(); 

	    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	    Thread.sleep(1500);

	    robot.keyPress(KeyEvent.VK_PAGE_DOWN);
	    robot.keyRelease(KeyEvent.VK_PAGE_DOWN);
	    Thread.sleep(1500);
	    
	    List<WebElement> imageElements = driver.findElements(By.xpath("//img[contains(@alt,'thumbnail')]"));
	    List<WebElement> titleElements = driver.findElements(By.xpath("//a[contains(@class,'text mt-2')]"));
	    
	    List<WebElement> clickableElements = new ArrayList<>();
	    clickableElements.addAll(imageElements);
	    clickableElements.addAll(titleElements);

	    WebElement randomElement = clickableElements.get(new Random().nextInt(clickableElements.size()));

	    randomElement.click();  
	    Thread.sleep(5000);
	    
	    WebDriverWait wait = new WebDriverWait(driver, 5);	    
	    WebElement moreIcon = driver.findElement(By.xpath("//app-more-options//div[contains(@class, 'more-icon cursor-pointer')]"));
	    moreIcon.click();
	    Thread.sleep(1000);
	    
	    WebElement blockUser = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[contains(@class, 'dropdown')]//li[contains(text(), 'Chặn người dùng')]")));
        blockUser.click();
        Thread.sleep(1000);
        
        WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Xác Nhận') and contains(@class, 'bg-blue-500')]")));
        confirmButton.click();
        Thread.sleep(1000);
        
        WebElement completeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(text(), 'Hoàn tất') and contains(@class, 'bg-blue-500')]")));
        completeButton.click();
        Thread.sleep(5000);
  }
  @Test(priority = 1)
  public void Testcase02() throws InterruptedException, AWTException {
	  	
	  	WebElement avatar = driver.findElement(By.xpath("//div[contains(@class, 'navbar-toggle') and contains(@class, 'cursor-pointer')]"));
	  	avatar.click();
	  	Thread.sleep(1000);
	  
	  	WebElement accountSettings = driver.findElement(By.xpath("//span[text()='Tùy chỉnh tài khoản']"));
	  	accountSettings.click();
	  	Thread.sleep(1000);
	  
	  	WebElement blockedTab = driver.findElement(By.xpath("//li[contains(@class, 'cursor-pointer') and .//a[contains(text(), 'Đã chặn')]]"));
	  	blockedTab.click();
	  	Thread.sleep(1000);
	  
	  	List<WebElement> unblockButtons = driver.findElements(By.xpath("//button[contains(text(), 'Gỡ chặn')]"));
	  	unblockButtons.get(new Random().nextInt(unblockButtons.size())).click();
	  	Thread.sleep(1000);
      
	  	WebDriverWait wait = new WebDriverWait(driver, 5);
	  	WebElement confirmButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[text()='Xác nhận']")));
	  	confirmButton.click();
	  	Thread.sleep(3000);
  }
  
  @AfterMethod
  public void teardown() {
      if (driver != null) {
          driver.quit();
      }
  }
}
