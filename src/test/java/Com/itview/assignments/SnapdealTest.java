package Com.itview.assignments;

import org.testng.annotations.Test;

import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class SnapdealTest 
{
	WebDriver w;
	SoftAssert sft;
	
	 @BeforeTest
	  public void beforeTest() 
	 {
		 w=new ChromeDriver();
	 }
  @Test(description="TestNG/WebDriver test for the Search for \"Snapdeal\" keyword on Google search engine")
  public void GoogleSearchTest() 
  {
	  sft=new SoftAssert();
	  //Verify page title is "Snapdeal - Google Search"
	  w.get("https://www.google.com/search?gs_ssp=eJzj4tLP1TfIyLM0syxXYDRgdGDw4ijOSyxISU3MAQBanwcx&q=snapdeal&rlz=1C1CHBF_enUS866US866&oq=snapdeal&aqs=chrome.1.0i355i433i512j46i199i433i465i512j0i512j0i433i512j0i512l3j0i131i433i512j0i512.6418j0j15&sourceid=chrome&ie=UTF-8");
	  String GoogleSearchPageTitle=w.getTitle();
	  sft.assertTrue(GoogleSearchPageTitle.contains("snapdeal - Google Search"), "Title doesn't contains 'snapdeal - Google Search'");
	  
	 /* //Verify on right panel "Snapdeal" name
	  WebElement RightPanelLable=w.findElement(By.xpath("//*[@id=\"mh_tsuid_54\"]/div/div/div[2]"));
	  String RightPanelLable_Text=RightPanelLable.getText();	
	  sft.assertEquals(RightPanelLable_Text,"Snapdeal");*/
	 
	  //Click on "Wikipedia" and verify Page title "Snapdeal - Wikipedia"
	  w.findElement(By.linkText("Wikipedia")).click();
	  String WikipediaPageTitle=w.getTitle();
	  sft.assertTrue(WikipediaPageTitle.contains("Snapdeal - Wikipedia"), "Title doesn't contains 'Snapdeal - Wikipedia'");
	 
	  sft.assertAll();
  }
 
  @AfterTest
  public void afterTest()
  {
	  w.quit();
  }

}
