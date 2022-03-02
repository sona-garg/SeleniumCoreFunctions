package temp;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.NoSuchElementException;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebtablesAndScreenshot {
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
	}

	public static void main(String[] args) {
		//waits();
		
				try {
					//TakeScreenshot();
					getTablevalues();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
	}
	private static void waits() {
		
		//System.setProperty("Webdriver.chrome.driver", "/usr/local/bin/chromedriver.exe");
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://google.com/ncr");
		driver.findElement(By.name("q")).sendKeys("Selenium" + Keys.ENTER);
		
		// Initialize and wait till element(link) became clickable - timeout in 10 seconds
		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
		// Print the first result
		System.out.println(firstResult.getText());
		firstResult.click();
		
		
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(1))
				  .ignoring(NoSuchElementException.class);
		
		// the below code is just a sample for fluent wait
		WebElement demo = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("demo")));
		
		
	}
	public static void getTablevalues () {
		
		//System.setProperty("Webdriver.chrome.driver", "/usr/local/bin/chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		int rows = driver.findElements(By.xpath("//table[@summary='Sample Table']/tbody/tr")).size();
		int cols = driver.findElements(By.xpath("//table[@summary='Sample Table']/thead/tr/th")).size();
		
		for(int row = 1; row<=rows; row++) {
			
			for (int col = 1; col<cols ; col++) {
				
				String value = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody/tr["+row+"]/td["+col+"]")).getText();
				System.out.println(value);
				
			}	
		}
		
	}
	public static void TakeScreenshot() throws IOException {
		
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
		
		TakesScreenshot scrShot =((TakesScreenshot)driver);
		
		File SrcFile=scrShot.getScreenshotAs(OutputType.FILE);

	    File DestFile=new File("C:/Users/manoj/Desktop/screenshot1.jpeg");

	    FileUtils.copyFile(SrcFile, DestFile);
		
		

	}


}
