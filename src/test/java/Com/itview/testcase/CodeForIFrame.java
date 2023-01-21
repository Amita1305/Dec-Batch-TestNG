package Com.itview.testcase;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class CodeForIFrame 
{
	WebDriver w;
	
	
	 @BeforeTest
	  public void beforeTest()
	 {
		 w=new ChromeDriver();
	  }

  @Test
  public void Code_Fro_IFrame_Test() throws Exception
  {
	  w.get("https://demo.automationtesting.in/Frames.html");	
	  w.switchTo().frame("singleframe");
	  w.findElement(By.xpath("/html/body/section/div/div/div/input")).clear();
	  w.findElement(By.xpath("/html/body/section/div/div/div/input")).sendKeys("Selenium");
		
		Thread.sleep(3000);
		
		
  }
  
 
  @AfterTest
  public void afterTest() 
  {
	  w.quit();
  }

}
