package Com.itview.testcases.selenium_testing_test;
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

									
public class LoginTestCase 
{

	public static void main(String[] args)
	{
		
		WebDriver w=new ChromeDriver();
		w.get("http://altoromutual.com:8080/login.jsp");
		thread sleep(3000);
		
		w.findElement(By.xpath("//*[@id=\"uid\"]")).sendKeys("admin");
		w.findElement(By.xpath("<input type=\"password\" id=\"passw\" name=\"passw\" style=\"width: 150px;\">")).sendkeys(admin123);
		w.findElement(By.xpath())
		w.quit();
		System.out.println("Admin Test case pass...");
		
	}

}
