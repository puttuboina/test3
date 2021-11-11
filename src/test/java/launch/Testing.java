package launch;

import java.io.IOException;

import org.openqa.selenium.WebElement;

 public class Testing extends BaseClass {
	
	public static void main(String [] args) throws IOException {
		
		Testing t = new Testing();
		t.browserLaunch("https://www.facebook.com/");
		String Username = t.excelRead("C:\\Java\\Book1.xlsx", "Test2", 1,0);
		WebElement textusername = t.locators("id","email");
		t.enterText(textusername , Username);
		String password = t.excelRead("C:\\Java\\Book1.xlsx", "Test2", 1,1);
		WebElement textpassword = t.locators("id", "pass");
		t.enterText(textpassword, password);
		
		
		
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
}
