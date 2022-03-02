package temp;
import java.io.File;
import java.sql.Driver;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
public class CoreFunctions {
	
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
	   // final WebDriver driver = new ChromeDriver();
		//driver.get("https://cosmocode.io/automation-practice/");
		
		}//end of static
	static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
			
			//browserCapabilities();
			elementActions();
			//waits();
			
			
		}
	/**
	 * 
	 */
	public static void browserCapabilities() {
		ChromeOptions chromeOptions = new ChromeOptions();
		
		// This will make Selenium WebDriver to wait for the entire page is loaded.
		chromeOptions.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		
		//This capability checks whether an expired (or) invalid TLS Certificate is used while navigating during a session
		chromeOptions.setAcceptInsecureCerts(true);
		
		//Specifies when to interrupt an executing script in a current browsing context. The default timeout 30,000 ms
		chromeOptions.setScriptTimeout(Duration.ofSeconds(20));
		
		//Specifies the time interval in which web page needs to be loaded in a current browsing context. The default timeout 300,000 ms
		chromeOptions.setPageLoadTimeout(Duration.ofSeconds(20));
		
		//This specifies the time to wait for the implicit element location strategy when locating elements. The default timeout 0 ms
		//This will take the priority if other waits are also present in the code
		chromeOptions.setImplicitWaitTimeout(Duration.ofSeconds(10));
		
		//Adding chrome extensions with webdriver
		//chromeOptions.addExtensions(new File("/path/to/extension.crx"));
		
		chromeOptions.addArguments("start-maximized");
		//more capabilities at https://sites.google.com/a/chromium.org/chromedriver/capabilities
		
		//System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
		//WebDriver driver = new ChromeDriver();
		driver.get("https://cosmocode.io/automation-practice/");
		
		
		System.out.println("Current title of the page:"+driver.getTitle());
		System.out.println("Current url of the page:"+driver.getCurrentUrl());
		
		
		driver.navigate().to("https://selenium.dev");
	
		
		driver.navigate().back();
		driver.navigate().forward();
		driver.navigate().refresh();
		
		System.out.println("Current page source:"+driver.getPageSource());
		System.out.println("Current title of the page:"+driver.getTitle());
		System.out.println("Current url of the page:"+driver.getCurrentUrl());
		
		driver.manage().deleteAllCookies();
		
		}
	
	public static void elementActions() {
		driver.get("https://cosmocode.io/automation-practice/");
		
		//findElements will not throw any exceptions if element is not present on the page
		List <WebElement> links = driver.findElements(By.linkText("vijayabharathi"));
		
		if (links.size()>=1) {
			WebElement link = driver.findElement(By.linkText("vijayabharathi"));
			link.click();
		}
		System.out.println("proceeding with next steps");
		
		
		//findElement will throw exception if element is not present
		WebElement link = driver.findElement(By.linkText("Click here to reload this page"));
		link.click();
		
		WebElement firstname = driver.findElement(By.id("firstname"));
		firstname.sendKeys("Sonali");
		
		WebElement lastname = driver.findElement(By.className("lastname"));
		lastname.sendKeys("Garg");
		
		
		String gender = "donotknow";
		WebElement genderElement = driver.findElement(By.xpath("//input[@value='"+gender+"']"));
		genderElement.click();
		
	/*	switch(gender) {
		case "Female":
			WebElement female = driver.findElement(By.xpath("//input[@value='"+gender+"']"));
			female.click();
			break;
		case "Male":
			WebElement male = driver.findElement(By.xpath("//input[@value='"+gender+"']"));
			male.click();
			break;
		case "Still Exploring":
			WebElement stillexploring = driver.findElement(By.xpath("//input[@value='donotknow']"));
			stillexploring.click();
		default:
			break;
			}*/
		String languages = "Java #Python #Vbscript";
		String[] language = languages.split("#");
		for(String l:language) {
			System.out.println(l.trim());
			if(l.trim().equalsIgnoreCase("Java")) {
				WebElement java = driver.findElement(By.xpath("//input[@value='java']"));
				java.click();
				}//end of if
			else if (l.trim().equalsIgnoreCase("python")) {
				WebElement python = driver.findElement(By.xpath("//input[@value='python ']"));
				python.click();
				}//end of elseif
			else if (l.trim().equalsIgnoreCase("Vbscript")) {
				WebElement vbscript = driver.findElement(By.xpath("//input[@value='vbscript']"));
				vbscript.click();
				}//end of elseif
			else if (l.trim().equalsIgnoreCase("c")) {
				WebElement c = driver.findElement(By.xpath("//input[@value='c']"));
				c.click();
				}//end of elseif
			else  {
				WebElement csharp = driver.findElement(By.xpath("//input[@value='c#']"));
				csharp.click();
				}//end of elseif
		}
			WebElement age = driver.findElement(By.name("age"));
			Select ageSelect = new Select(age);
			ageSelect.selectByIndex(1);
			System.out.println("the number of elements in the dropdown are:");
			
			
			
			
			WebElement submit = driver.findElement(By.id("submit_htmlform"));
			submit.click();	
			
	}//end of elementAction method
	public static void waits() {
		driver.get("https://google.com/ncr");
		driver.findElement(By.name("q")).sendKeys("Selenium"+ Keys.ENTER );
		WebElement first = driver.findElement(By.xpath("//a/h3"));
		System.out.println(first.getText());
		
		// Initialize and wait till element(link) became clickable - timeout in 10 seconds
		WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
		        .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));
		// Print the first result
		System.out.println(firstResult.getText());
		firstResult.click();
		
		
		/*Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
				  .withTimeout(Duration.ofSeconds(30))
				  .pollingEvery(Duration.ofSeconds(5))
				  .ignoring(NoSuchElementException.class);

		WebElement test = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test")));
		WebElement test2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("test2")));*/
		
		
			
		}//end of wait method
	

}//end of class
