package Com.itview.hardassert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;

public class LoginSoftAsserts
{
	  WebDriver w;
	  SoftAssert sft;
	  	
	@BeforeTest
	  public void preCondition_MutualFund() 
	{
		w=new ChromeDriver();
	}

	@Test(priority=0,description="Test case to verify Login page using 'Admin' user", groups="LoginModule")
	public void loginAdminTest() 
	{
		sft=new SoftAssert();
		w.get("http://altoromutual.com:8080/login.jsp");
		String LoginPageTitle=w.getTitle();
		String LoginPageURL=w.getCurrentUrl();
		WebElement LoginPageLable=w.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/div/h1"));
		String LoginPageLable_Text=LoginPageLable.getText();
		
		sft.assertEquals(LoginPageTitle,"Altoro Mutual");
		sft.assertTrue(LoginPageURL.contains("/login.jsp"),"URL doesn't contains '/login.jsp'");
		sft.assertTrue(LoginPageLable_Text.contains("Login"),"Lable doesn't contains 'Login'");
		
		w.findElement(By.id("uid")).sendKeys("admin");
		w.findElement(By.id("passw")).sendKeys("admin");
		w.findElement(By.name("btnSubmit")).click();
		sft.assertAll();
	}
	
	
@Test(priority=1,description="Test case to verify Logout page using 'Admin' user", groups="LoginModule", dependsOnMethods="loginAdminTest")
public void logoutAdminTest() throws Exception
{
	sft=new SoftAssert();
	Thread.sleep(2000);
	String homePageTitle=w.getTitle();
	WebElement homePageLable=w.findElement(By.xpath("/html/body/table[2]/tbody/tr/td[2]/div/h1"));
	String homePageLable_Text=homePageLable.getText();
	
	sft.assertEquals(homePageTitle,"Altoro Mutual");
	sft.assertTrue(homePageLable_Text.contains("Admin"), "Label doesn't contains 'Admin'");
	w.findElement(By.linkText("Sign Off")).click();
	sft.assertAll();
}

  @AfterTest
  public void postCondition_MutualFund()
  {
	  w.quit();
  }

}
