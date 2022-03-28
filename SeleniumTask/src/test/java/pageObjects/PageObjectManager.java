package pageObjects;

import org.openqa.selenium.WebDriver;

public class PageObjectManager {
	
	public AssignmentTask1Page rahulShettyPage;

	public WebDriver driver;
	
	public PageObjectManager(WebDriver driver)
	{
		this.driver = driver;
	}

	
	
	public AssignmentTask1Page getRahulShettyPage()
	{

		rahulShettyPage= new AssignmentTask1Page(driver);
		 return rahulShettyPage;
	}
	

}
