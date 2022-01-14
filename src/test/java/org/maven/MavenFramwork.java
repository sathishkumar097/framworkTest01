package org.maven;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
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

public class MavenFramwork extends BaseClass {

	public static void main(String[] args) throws IOException {
		
		browserLaunch();
		urlLaunch("https://www.facebook.com/");
		WebElement userId = driver.findElement(By.id("email"));
		sendValue(userId, excelOperaction(0, 0));
		
		WebElement pass = driver.findElement(By.id("pass"));
		sendValue(pass, excelOperaction(0, 1));
		
		System.out.println(excelOperaction(0, 0));
		
		System.out.println(excelOperaction(0, 1));
		
		
		
		
		driver.quit();
	}
}
