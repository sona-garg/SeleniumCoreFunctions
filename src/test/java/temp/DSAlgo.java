package temp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DSAlgo {
	static {
		System.setProperty("webdriver.chrome.driver", "C:\\SeleniumDriver\\chromedriver.exe");
	   // final WebDriver driver = new ChromeDriver();
		//driver.get("https://cosmocode.io/automation-practice/");
		
		}//end of static
	static WebDriver driver = new ChromeDriver();
	
	public static void main(String[] args) {
			
			getstarted();
			//loginPage();
			}
	public static void getstarted() {
		driver.get("https://dsportalapp.herokuapp.com/");
		System.out.println("Current title of the page:"+driver.getTitle());
		System.out.println("Current url of the page:"+driver.getCurrentUrl());
		 driver.findElement(By.className("btn")).click();
		 System.out.println("Navigated to Home Page ");
		 System.out.println("Current title of the page:"+driver.getTitle());
		 System.out.println("Current url of the page:"+driver.getCurrentUrl());
		 driver.findElement(By.linkText("Data Structures")).click();
		 String[] options = driver.findElement(By.className("dropdown-menu")).getText().split("\n");
		 System.out.println(options.length);
		 
		 
	}

}
