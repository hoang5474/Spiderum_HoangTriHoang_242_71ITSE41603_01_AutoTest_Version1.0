package TestScript;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNhaps {
	public class TestDangNhap {
	    WebDriver driver;

	    @BeforeMethod
	    public void setup() {
	        System.setProperty("webdriver.chrome.driver","F:\\chromedriver-win64\\chromedriver.exe");
	        driver = new ChromeDriver();
	        driver.manage().window().maximize();
	        driver.get("https://spiderum.com");
	    }

	    @Test 
	    public void TestCase1() throws InterruptedException {
	        driver.findElement(By.xpath("(//i[contains(@class,'fa-times-circle')])[1]")).click();
	        WebElement link = driver.findElement(By.linkText("Đăng nhập"));
	        link.click();
	        
	        driver.findElement(By.id("name")).sendKeys("phanlengoctri");
	        Thread.sleep(1000);
	        driver.findElement(By.id("password")).sendKeys("ngoctri12");
	        Thread.sleep(1000);
	        driver.findElement(By.id("submit-btn")).click();
	        Thread.sleep(1000);
	        driver.findElement(By.xpath("//button[contains(@class,'button-secondary')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//a[contains(@class,'button-round')and contains(@href,'/bai-dang/viet-bai')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[contains(text(), 'Bỏ qua hướng dẫn')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[contains(@class, 'title mb-4 cursor-text')]")).sendKeys("Kiểm thử phần mềm");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//div[@class='ce-paragraph cdx-block undefined' and @contenteditable='true']\n")).sendKeys("Test");
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[contains(@class, 'button-draft')]"));
            Thread.sleep(4000);
	    }
	    
		@AfterMethod
	    public void teardown() {
	        if (driver != null) {
	            driver.quit();
	        }
	    }
	}
}
