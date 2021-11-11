package launch;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	WebDriver driver;

	public void browserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		 driver  = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(url);
	}
	public WebElement locators(String locatorsType, String Valve) {
		if(locatorsType.equals("id")) {
		WebElement findElement = driver.findElement(By.id(Valve));
		return findElement;
	}	
		else if(locatorsType.equals("name")){
			WebElement findElement = driver.findElement(By.name(Valve));
			return findElement;
	}
		else {
			WebElement findElement = driver.findElement(By.xpath(Valve));
			return findElement;
			
		}
	}
		
		public void enterText(WebElement element , String text) {
			element.sendKeys(text);

		}
			

	public String excelRead(String path, String SheetName ,  int Rowindex, int cellindex ) throws IOException {
		
		File f = new File(path);
		
		FileInputStream s = new FileInputStream(f);
		
		Workbook w = new XSSFWorkbook(s);
		
		Sheet sheet = w.getSheet(SheetName);
		Row row = sheet.getRow(Rowindex);
		Cell cell = row.getCell(cellindex);
		
		int cellType = cell.getCellType();
		if (cellType == 1) {
			String stringcellvalve = cell.getStringCellValue();
			return stringcellvalve;
		}
		else if (DateUtil.isCellDateFormatted(cell)) {
			Date datecellValve = cell.getDateCellValue();
			SimpleDateFormat s1 = new SimpleDateFormat();
			String format = s1.format(datecellValve);
			return format;
		}
		else {
			double numericcellvalve = cell.getNumericCellValue();
			long l = (long)numericcellvalve;
			String valveof = String.valueOf(l);
			return valveof;
		
	}
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
