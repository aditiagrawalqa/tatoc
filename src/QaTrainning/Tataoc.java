package QaTrainning;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;


public class Tataoc {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\aditiagrawal\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver();
		driver.get("http://10.0.1.86/tatoc");


		driver.findElement(By.linkText("Basic Course")).click();


		driver.findElement(By.className("greenbox")).click();


		driver.switchTo().frame(driver.findElement(By.id("main")));


		String Box1 = driver.findElement(By.id("answer")).getAttribute("class");
		String Box2 = null;
		do
		{
			driver.switchTo().frame(driver.findElement(By.cssSelector("iframe#child")));
			Box2=driver.findElement(By.id("answer")).getAttribute("class");
			driver.switchTo().parentFrame();
			if(Box1.equals(Box2)) {

				driver.findElement(By.linkText("Proceed")).click();

				break;
			}
			else

				driver.findElement(By.linkText("Repaint Box 2")).click();
		}

		while(!(Box1.equals(Box2)));
		
		
		
		

	}
}
