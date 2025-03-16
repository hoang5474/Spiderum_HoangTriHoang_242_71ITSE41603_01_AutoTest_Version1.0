package TestScript;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TestDangNhap {
    WebDriver driver;

    @BeforeMethod
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "F:\\chromedriver-win64\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://spiderum.com");
    }
    @Test(priority = 0)
    public void TestCase1() throws InterruptedException {
        driver.findElement(By.xpath("(//i[contains(@class, 'fa-times-circle')])[1]")).click();
        WebElement link = driver.findElement(By.linkText("Đăng nhập"));
        link.click();

        driver.findElement(By.id("name")).sendKeys("phanlengoctri");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("ngoctri12");
        Thread.sleep(1000);
        driver.findElement(By.id("submit-btn")).click();
        Thread.sleep(2000);
    }
    
    @Test(priority = 1)
    public void TestCase2() throws InterruptedException {
        driver.findElement(By.xpath("(//i[contains(@class, 'fa-times-circle')])[1]")).click();
        WebElement link = driver.findElement(By.linkText("Đăng nhập"));
        link.click();

        driver.findElement(By.id("name")).sendKeys("wincool1212@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("ngoctri12");
        Thread.sleep(1000);
        driver.findElement(By.id("submit-btn")).click();
        Thread.sleep(2000);
    }
    @Test(priority = 2)
    public void TestCase3() throws InterruptedException {
        driver.findElement(By.xpath("(//i[contains(@class, 'fa-times-circle')])[1]")).click();
        WebElement link = driver.findElement(By.linkText("Đăng nhập"));
        link.click();

        driver.findElement(By.id("name")).sendKeys("wincool1212@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("password")).sendKeys("saimatkhau");
        Thread.sleep(1000);
        driver.findElement(By.id("submit-btn")).click();
        Thread.sleep(2000);
        
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement messageFail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"alert\"]/div")));
        String actualMessageFail = messageFail.getText();
        String expectedMessageFail = "Sai tên đăng nhập hoặc mật khẩu";
        Assert.assertEquals(actualMessageFail, expectedMessageFail, "Thông báo lỗi không đúng!");
    }
    @Test(priority = 3)
    public void TestCase4() throws InterruptedException {
        driver.findElement(By.xpath("(//i[contains(@class, 'fa-times-circle')])[1]")).click();
        WebElement link = driver.findElement(By.linkText("Đăng nhập"));
        link.click();
        
        driver.findElement(By.xpath("//a[@href='/quen-mat-khau' and contains(text(), 'Quên mật khẩu')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("wincool1212@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("submit-btn")).click();
        Thread.sleep(2000);
        
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement messageSuccess = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'alert-success')]")));
        String actualMessageSuccess = messageSuccess.getText();
        String expectedMessageSuccess = "Email đã được gửi đến hòm thư wincool1212@gmail.com của bạn";
        Assert.assertEquals(actualMessageSuccess, expectedMessageSuccess, "Thông báo thành công không đúng!");
    }
        @Test(priority = 4)
        public void TestCase5() throws InterruptedException {
        driver.findElement(By.xpath("(//i[contains(@class, 'fa-times-circle')])[1]")).click();
        WebElement link = driver.findElement(By.linkText("Đăng nhập"));
        link.click();
        
        driver.findElement(By.xpath("//a[@href='/quen-mat-khau' and contains(text(), 'Quên mật khẩu')]")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("name")).sendKeys("wincool1234@gmail.com");
        Thread.sleep(1000);
        driver.findElement(By.id("submit-btn")).click();
        Thread.sleep(2000);
        
        WebDriverWait wait = new WebDriverWait(driver, 5);
        WebElement messageFail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'alert-danger')]")));
        String actualMessageFail = messageFail.getText();
        String expectedMessageFail = "Email không tồn tại.";
        Assert.assertEquals(actualMessageFail, expectedMessageFail, "Thông báo lỗi không đúng!");
    }
        @Test(priority = 5)
        public void TestCase6() throws InterruptedException {
            driver.findElement(By.xpath("(//i[contains(@class, 'fa-times-circle')])[1]")).click();
            WebElement link = driver.findElement(By.linkText("Đăng nhập"));
            link.click();

            driver.findElement(By.id("name")).sendKeys("wincool1212@gmail.com");
            Thread.sleep(1000);
            driver.findElement(By.id("password")).sendKeys("ngoctri12");
            Thread.sleep(1000);
            driver.findElement(By.id("submit-btn")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[contains(@class, 'button-secondary')]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("/html/body/app-root/app-homepage-redesign/header/nav/div[1]/div/div[2]/div/div[4]")).click();
            Thread.sleep(1000);
            driver.findElement(By.xpath("//button[@aria-label='Sign out']")).click();
            Thread.sleep(2000);
        }
    @AfterMethod
    public void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
