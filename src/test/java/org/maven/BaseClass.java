package org.maven;

import java.awt.Desktop.Action;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	static WebDriver driver;
	static Actions a;

	public static void browserLaunch() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}

	public static void urlLaunch(String url) {
		driver.get(url);
		driver.manage().window().maximize();
	}

	public static void textGet(WebElement element,String value) {
		String text = element.getText();
		System.out.println(text);
	}

	public static void titleGet() {
		String title = driver.getTitle();
		System.out.println(title);
	}

	public static void currentUrl() {
		String currentUrl = driver.getCurrentUrl();
		System.out.println(currentUrl);
	}

	public static void sendValue(WebElement element, String value) {
		element.sendKeys(value);
	}

	public static void btnClick(WebElement element) {
		element.click();

	}

	public static void screenShot() throws IOException {

		Date currentDate = new Date();
		String modifidDate = currentDate.toString().replace(" ", "_").replace(":", "_");

		TakesScreenshot scrnsht = (TakesScreenshot) driver;

		File screenshotAs = scrnsht.getScreenshotAs(OutputType.FILE);

		File f = new File("D:\\New folder\\MavenProject\\ScreenShot" + modifidDate + ".png");
		FileUtils.copyFile(screenshotAs, f);

	}

	public static String excelOperaction(int rowNum, int cellNum) throws IOException {

		File f = new File("D:\\New folder\\MavenProject\\excel\\PBI-1_Test cases_v1.0.xlsx");

		FileInputStream fin = new FileInputStream(f);
		Workbook book = new XSSFWorkbook(fin);

		Sheet sheet = book.getSheet("check");
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);

		int cellType = cell.getCellType();
		String name = "";
		if (cellType == 1) {

			name = cell.getStringCellValue();
		}

		else if (DateUtil.isCellDateFormatted(cell)) {

			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat form = new SimpleDateFormat("dd-mm-yyyy");
			name = form.format(dateCellValue);

		}

		else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			name = String.valueOf(l);
		}
		return name;

	}

}