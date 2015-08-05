package testCases;

import java.util.concurrent.TimeUnit;

import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

/**
 * @author Stefan Schmidt
 * @version 0.1
 * 
 * Diese Testklasse beinhaltet die allerersten Test-Testfaelle.
 */

public class FirstTestClass {
	private static HtmlUnitDriver unitDriver;
	WebElement element;

	@BeforeClass
	public static void openHtmlUnitDriver() {
		unitDriver = new HtmlUnitDriver();
		unitDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	/**
	 * Dieser Test ruft die Website "https://www.google.de/" auf,
	 * gibt in das Suchfeld "Cheese!" ein und klickt auf "Suchen".
	 * Anschliessend wird geprueft, ob der title richtig angezeigt wird.
	 */
	@Test
	public void googleTest() {
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
//		Arrange
		unitDriver.get("https://www.google.de/");
		
//		Act
		element = unitDriver.findElement(By.name("q"));
		element.sendKeys("Cheese!");
		element.submit();
		
//		Assert
		Assert.assertEquals("Cheese! - Google-Suche", unitDriver.getTitle());
		Assert.assertNotEquals("Ein falscher Text", unitDriver.getTitle());
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	/**
	 * Dieser Test ruft die Website "http://www.ppi.de" auf
	 * und klickt auf "Karriere".
	 * Anschliessend wird geprueft, ob der title richtig angezeigt wird.
	 */
	@Test
	public void ppiTest() {
		System.out.println("Starting test " + new Object(){}.getClass().getEnclosingMethod().getName());
		
//		Arrange
		unitDriver.get("http://www.ppi.de");
		
//		Act
		unitDriver.findElement(By.linkText("Karriere"));
		
//		Assert
		Assert.assertEquals("PPI Aktiengesellschaft: PPI Aktiengesellschaft: Startseite", unitDriver.getTitle());
		Assert.assertNotEquals("Ein falscher Text", unitDriver.getTitle());
		
		System.out.println("Ending test " + new Object(){}.getClass().getEnclosingMethod().getName());
	}

	@AfterClass
	public static void closeBrowser() {
		unitDriver.quit();
	}
}
