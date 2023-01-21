package Com.itview.assignments;

import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginTestPolicy 
{
	WebDriver w;
	SoftAssert sft;
	 
	
	 @BeforeTest
	  public void beforeTest() 
	 {
		 w=new ChromeDriver();
	  }

  @Test(priority=0,description="Test case to verify Policyx website")
  public void LoginAdminTest()
  {
	  sft=new SoftAssert();
	  w.get("https://www.policyx.com/");
	  String HomePageTitle=w.getTitle();
	  
	  //Verify Label on page is equal to "India's Most Trusted Insurance Portal"
	  WebElement HomePageLable=w.findElement(By.xpath("//*[@id=\"page1\"]/section[1]/div/div/div[2]/div[1]/h1"));
	  String HomePageLable_Text=HomePageLable.getText();	
	  sft.assertEquals(HomePageLable_Text,"India's Most Trusted Insurance Portal");
	 
	  //Verify page title contains "Insurance" text
	  sft.assertTrue(HomePageTitle.contains("Insurance"), "Title doesn't contains 'Insurance'");
	 
	  //On-clicking "Claim", and verify Page label is “CLAIM ASSISTANCE”
	  w.findElement(By.linkText("Claim")).click();
	  WebElement HomePageLableNext=w.findElement(By.xpath("//*[@id=\"page1\"]/div[2]/div/div/div[1]/h1"));
	  String HomePageLableNext_Text=HomePageLableNext.getText();	
	  sft.assertEquals(HomePageLableNext_Text,"CLAIM ASSISTANCE");
	  
	  //Verify page title contains "Claim Process"
	  String HomePageNextTitle=w.getTitle();
	  sft.assertTrue(HomePageNextTitle.contains("Claim Process"), "Title doesn't contains 'Claim Process'");
	  
	  sft.assertAll();
  }	
	
  @AfterTest
  public void afterTest()
  {
	  w.quit();
  }

}
