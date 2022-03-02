package temp;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import java.util.Set;

import javax.imageio.ImageIO;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.File;
import java.awt.Toolkit;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class HandlingWindows {
	static WebDriver driver = null;    
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		//driver.get("https://cosmocode.io/automation-practice/");
		//driver.get("http://demo.guru99.com/test/guru99home/");
		//driver.get("https://www.selenium.dev/documentation/webdriver/browser/alerts/");
		driver.get("https://dsportalapp.herokuapp.com/");
		}
	 
	

	public static void main(String[] args) {
		try {
			
			//switchWindows();
			//switchFrames();
			//switchAlerts();
			//getTablevalues();
			numpy();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	

	}
	public static void numpy() {
		WebElement getbtn = driver.findElement(By.className("btn"));
		getbtn.click();
	}
	public static void switchWindows() throws InterruptedException {
		
		
		String currentWIndowID = driver.getWindowHandle();
		System.out.println("First Window ID : "+ currentWIndowID);
		
		WebElement linkToOpenWindow = driver.findElement(By.linkText("Click Me to open New Window"));
		linkToOpenWindow.click();
		
		
		//Getting Number of Windows
		Set<String> windows = driver.getWindowHandles();
		
		System.out.println("Number of Windows opened currently : "+ driver.getWindowHandles().size());
		
		
		//Printing the title of the current Window
		System.out.println("Title of the current window : " + driver.getTitle());
		
		
		
		//Getting the name of the current Window
		String oldWindowName = driver.getWindowHandle();
		System.out.println("Name of the current window : " + driver.getWindowHandle());
		
				
		String newWindow=null;
		

		for (String win : windows) {
			
			System.out.println(win);
			if (!win.equalsIgnoreCase(oldWindowName)) {
				newWindow = win;
				break;
			}			
		} 
		
		
		//switching to new window
		driver.switchTo().window(newWindow);
		System.out.println("========= Switching Windows ========= ");
		
		
		//Printing the title of the new Window
		System.out.println("Title of the New window : " + driver.getTitle());
			
		//Getting the name of the new Window
		System.out.println("Name of the New window : " + newWindow);
		

		//clicking link to open another window
		WebElement linkToOpenThirdWindow = driver.findElement(By.linkText("Click Me To Open Third Window"));
		linkToOpenThirdWindow.click();
		
		windows = driver.getWindowHandles();
		
		for (String win : windows) {
			driver.switchTo().window(win);
			if(driver.getTitle().contains("3rd Window")) {
			break;
			}			
		}
		
		//Printing the title of the last Window
		System.out.println("Title of the last window : " + driver.getTitle());	
		
		
	}
	public static void switchFrames() {
		
		
		//driver.switchTo().frame("a077aa5e");
		
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@id='a077aa5e']"));
		driver.switchTo().frame(frame1);
		
		driver.findElement(By.xpath("html/body/a/img")).click();
		
		driver.switchTo().parentFrame();
		driver.switchTo().defaultContent();


		
	}
	public static void switchAlerts() throws Exception {
		
		
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		//Click the link to activate the alert
		driver.findElement(By.linkText("See an example alert")).click();

		//Wait for the alert to be displayed and store it in a variable
		 Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		//alert = driver.switchTo().alert();

		//Print the Alert text value
		System.out.println("The text in sample alert is : "+ alert.getText());
		
		Thread.sleep(2000);
		
		BufferedImage image = new Robot().createScreenCapture(new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()));
	    ImageIO.write(image, "png", new File("C:/Users/manoj/Desktop/screenshot2.jpeg"));

		//Press the OK button
		alert.accept();
		
		
		//Click the link to activate the alert
		driver.findElement(By.linkText("See a sample confirm")).click();

		//Wait for the alert to be displayed
		wait.until(ExpectedConditions.alertIsPresent());

		//Store the alert in a variable
		alert = driver.switchTo().alert();
		
		Thread.sleep(2000);
		//Print the Alert text value
		System.out.println("The text in confirm alert is : "+ alert.getText());

		//Press the Cancel button
		alert.dismiss();
		
		
		//Click the link to activate the alert
		driver.findElement(By.linkText("See a sample prompt")).click();

		//Wait for the alert to be displayed and store it in a variable
		alert = wait.until(ExpectedConditions.alertIsPresent());
		
		//Type your message
		alert.sendKeys("selenium");
		Thread.sleep(2000);
		
		//Press the OK button
		alert.accept(); 
		

		
	}
	public static void getTablevalues () {
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		int rows = driver.findElements(By.xpath("//table[@summary='Sample Table']/tbody/tr")).size();
		int cols = driver.findElements(By.xpath("//table[@summary='Sample Table']/thead/tr/th")).size();
		
		for(int row = 1; row<=rows; row++) {
			
			for (int col = 1; col<=cols ; col++) {
				
				String value = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody/tr["+row+"]/td["+col+"]")).getText();
				System.out.println(value);
				
			}
		}
	}


}
