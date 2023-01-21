package Com.itview.testcase;
import java.util.List;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;

public class Code_For_CountElements
{
	WebDriver w;

	@BeforeTest
	public void beforeTest()
	{

		   w=new ChromeDriver();

	}

	@Test(priority = 0, description = "Test case to Count WebElements ")
	public void CountWebElement() throws Exception 
	{

		w.get("http://demo.automationtesting.in/Register.html");
		Thread.sleep(2000);
		List <WebElement> radioButton= w.findElements(By.name("radiooptions"));
		System.out.println("Count Of Radio Buttons: " +radioButton.size());
		
		List <WebElement> checkBox = w.findElements(By.cssSelector("input[type='checkbox']"));
		System.out.println("Count of checkBox : "+checkBox.size());
		
		List<WebElement> dropDown=w.findElements(By.tagName("select"));
		System.out.println("Count of Drop-Down : "+dropDown.size());
		
		List<WebElement> links=w.findElements(By.tagName("a"));
		System.out.println("Count of links : "+links.size());
		
		WebElement MonthDropDown=w.findElement(By.xpath("//*[@id=\"basicBootstrapForm\"]/div[11]/div[2]/select"));
		
		Select sel=new Select(MonthDropDown);
			
		System.out.println("\n Value inside Month DropDown : \n");
		List<WebElement> MonthDropDown_Values = sel.getOptions(); 		
		for(int i=1;i<MonthDropDown_Values.size();i++) 
		{
		
			System.out.println(MonthDropDown_Values.get(i).getText());
		}

		
	}
    
  @AfterTest
  public void afterTest() 
  {
	  w.quit();
  }

}
