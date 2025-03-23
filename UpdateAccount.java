package updateAccount; 

 

import org.testng.annotations.*; 

import org.testng.Assert; 

import org.openqa.selenium.*; 

import org.openqa.selenium.chrome.ChromeDriver; 

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration; 

 

public class NewTest { 

private WebDriver driver; 

private WebDriverWait wait; 

private final String baseUrl = "https://spiderum.com/?sort=hot&page_idx=1"; 

 

@BeforeMethod 

public void setup() { 

driver = new ChromeDriver(); 

wait = new WebDriverWait(driver, Duration.ofSeconds(10)); 

driver.get(baseUrl); 

driver.manage().window().maximize(); 

} 

 

private void login() throws InterruptedException { 

try { 

WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"dialog\"]/div/i"))); 

closeButton.click(); 

} catch (Exception e) { 

System.out.println("Không có popup xuất hiện."); 

} 

 

WebElement dangnhap = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a/span[text()='Đăng nhập']"))); 

dangnhap.click(); 

 

WebElement name = wait.until(ExpectedConditions.elementToBeClickable(By.id("name"))); 

name.sendKeys("daominhkhaihoangpq2003@gmail.com"); 

 

WebElement password = wait.until(ExpectedConditions.elementToBeClickable(By.id("password"))); 

password.sendKeys("Huucaoco@123", Keys.ENTER); 

 

// Chờ trang load 

Thread.sleep(2000); 

 

try { 

WebElement boqua = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//walkthrough//button[contains(text(), 'Bỏ qua')]"))); 

boqua.click(); 

} catch (Exception e) { 

System.out.println("Không có hộp thoại hướng dẫn."); 

} 

} 

 

@Test(priority = 0) 

public void UpdateAccount() throws AWTException, InterruptedException { 

login(); 

Thread.sleep(5000); 

// 🔹 Click trang cá nhân

WebElement firstPost = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-homepage-redesign/header/nav/div[1]/div/div[2]/div/div[4]/div"))); 
firstPost.click(); 

Thread.sleep(2000); 

 

// 🔹 Click axem trang cá nhân

WebElement authorAvatar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/app-homepage-redesign/header/nav/div[1]/div/div[2]/div/div[4]/div[2]/div/div/div[1]/div[2]/div/a"))); 

authorAvatar.click(); 

Thread.sleep(2000); 

 

// 🔹 ClicK Chỉnh sửa cá nhân

WebElement followButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"basic\"]/div/div/button"))); 

followButton.click(); 
//🔹 ClicK thêm avatar

WebElement avatar = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"account-setting\"]/div/div[1]/form/label"))); 

avatar.click(); 
String avartarPath = "C:\\avartar.jpg"; // Đường dẫn ảnh

// Sao chép đường dẫn vào clipboard
StringSelection selection = new StringSelection(avartarPath);
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

// Dán đường dẫn vào hộp thoại tải ảnh và nhấn Enter
Robot robot = new Robot();
Thread.sleep(2000); // Chờ hộp thoại mở lên

robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_V);
robot.keyRelease(KeyEvent.VK_V);
robot.keyRelease(KeyEvent.VK_CONTROL);

robot.keyPress(KeyEvent.VK_ENTER);
robot.keyRelease(KeyEvent.VK_ENTER);
//🔹 ClicK thêm background

WebElement background = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/profile-edit/div/div/account-section/form/div[1]/form/label"))); 

background.click(); 
String backgroundPath = "C:\\background.jpg"; // Đường dẫn ảnh

//Sao chép đường dẫn vào clipboard
StringSelection selection1 = new StringSelection(backgroundPath);
Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);

//Dán đường dẫn vào hộp thoại tải ảnh và nhấn Enter
Robot robot1 = new Robot();
Thread.sleep(2000); // Chờ hộp thoại mở lên

robot.keyPress(KeyEvent.VK_CONTROL);
robot.keyPress(KeyEvent.VK_V);
robot.keyRelease(KeyEvent.VK_V);
robot.keyRelease(KeyEvent.VK_CONTROL);

robot.keyPress(KeyEvent.VK_ENTER);
robot.keyRelease(KeyEvent.VK_ENTER);
//🔹 ClicK chọn ngày tháng năm sinh
//chọn ngày
WebElement dayDropdown = driver.findElement(By.xpath("//*[@id=\"date\"]")); // Thay ID phù hợp


Select date = new Select(dayDropdown);
date.selectByVisibleText("5");
//chọn tháng
WebElement monthDropdown = driver.findElement(By.xpath("//*[@id=\"month\"]")); // Thay ID phù hợp


Select month = new Select(monthDropdown);
month.selectByVisibleText("8");
//chọn năm
WebElement yearDropdown = driver.findElement(By.xpath("//*[@id=\"year\"]")); // Thay ID phù hợp


Select year = new Select(yearDropdown);
year.selectByVisibleText("2003");
// cuộn trang
JavascriptExecutor js = (JavascriptExecutor) driver;
js.executeScript("window.scrollBy(0, 500);"); // Cuộn xuống 500px
Thread.sleep(1000); // Đợi trang cuộn xong
//🔹 ClicK nhập số chưngs minh

WebElement ID = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"personalId\"]"))); 

ID.click();
ID.clear();
ID.sendKeys("091203016650");
//🔹 ClicK nhập số điện thoại

WebElement phoneNumber = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"phone\"]"))); 

phoneNumber.click();
phoneNumber.clear();
phoneNumber.sendKeys("0767220485");
//🔹 ClicK nhập địa chỉ

WebElement Address = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"address\"]"))); 

Address.click();
Address.clear();
Address.sendKeys("765/54 cách mạng tháng 8 P12 Quận 10 TP Hồ Chí Minh");
Thread.sleep(5000);
// CLICK SAVE
WebElement Save = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/app-root/profile-edit/div/div/account-section/form/div[3]/div/button[1]/span"))); 

Save.click();

// 🔹 Lấy thông báo xác nhận 

WebElement successMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"toast-container\"]/div"))); 

String actualMessage = successMessage.getText(); 

Assert.assertEquals(actualMessage, "Cập nhật tài khoản thành công"); 

} 


 

@AfterMethod 

public void teardown() { 

if (driver != null) { 

driver.quit(); 

} 

} 

} 