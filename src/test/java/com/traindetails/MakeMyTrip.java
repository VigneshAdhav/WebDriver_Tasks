package com.traindetails;


import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MakeMyTrip {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", "C:\\Users\\Gokul raj\\Desktop\\epam\\MakeMyTrip-Automation\\target\\chromedriver.exe");
		ChromeOptions chromeOptions= new ChromeOptions();
		chromeOptions.addArguments("--remote-allow-origins=*");
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("https://www.makemytrip.com/");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		
		
		WebElement frameEle = driver.findElement(By.xpath("//iframe[@id='webklipper-publisher-widget-container-notification-frame']"));
		driver.switchTo().frame(frameEle);
		boolean displayed = driver.findElement(By.xpath("//*[@class=\"close\"]")).isDisplayed();
		if (displayed) {
			driver.findElement(By.xpath("//*[@class=\"close\"]")).click();
			driver.switchTo().defaultContent();
		}
		
//		WebElement header = driver.findElement(By.xpath("//div[@class='headerOuter']"));
//		JavascriptExecutor executor = (JavascriptExecutor) driver;
//		executor.executeScript("argument[0].click()", header);
		
		Thread.sleep(10000);
		WebElement trains  = driver.findElement(By.xpath("//*[contains(@class,'makeFlex')]//following::li//div//a//*[text()='Trains']"));
		trains.click();
		
		
		WebElement fromEleLabel = driver.findElement(By.xpath("//*[@for='fromCity']"));
		fromEleLabel.click();
		WebElement fromEle = driver.findElement(By.id("fromCity"));
		fromEle.sendKeys("hyderabad");
		List<WebElement> startingList = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		for(WebElement eachStart:startingList){
			String source = eachStart.getAttribute("textContent").toLowerCase();
			if(source.contains("hyderabad")) {
				eachStart.click();
				break;
			}
		}
		
		
		
//		 driver.findElement(By.xpath("//*[@for='toCity']")).click();;
		Thread.sleep(10000);
//		toEleLabel.click();
		WebElement toEle = driver.findElement(By.id("toCity"));
		toEle.sendKeys("delhi");
		List<WebElement> destinationList = driver.findElements(By.xpath("//ul[@role='listbox']//li"));
		for(WebElement eachdesti: destinationList) {
			String destination = eachdesti.getAttribute("textContent").toLowerCase();
			if(destination.contains("delhi")) {
				eachdesti.click();
				break;
			}
		}
		
		String TravelBookingDate="21";
		WebElement travelDateEleLab = driver.findElement(By.xpath("//*[@for='travelDate']"));
		travelDateEleLab.click();
		List<WebElement> travelDateEle = driver.findElements(By.xpath("//*[@class=\"DayPicker-Body\"]//div[@class=\"DayPicker-Week\"]//div[@aria-disabled=\"false\"]"));
		for (WebElement travelDate : travelDateEle) {
			if(travelDate.getAttribute("textContent").contains(TravelBookingDate)) {
				travelDate.click();
				break;}
		}
		
		WebElement seachEle = driver.findElement(By.xpath("//*[contains(@class,'widgetSearchBtn')]"));
		seachEle.click();
		
		List<WebElement> trainDetails = driver.findElements(By.xpath("//div[@class=\"train-list\"]//div[@class=\"flex train-info\"]//..//..//..//following::div[@class=\"train-name\" or @class=\"depart-time\" or @class=\"arrival-time\"]"));
		
		for (WebElement train : trainDetails) {
			String TrainIformation = train.getAttribute("class");
			switch (TrainIformation) {
			case "train-name":
				String TrainName = train.getAttribute("textContent");
				System.out.println("train-name"+TrainName);
				break;
			case "depart-time":
				String DepartTime = train.getAttribute("textContent");
				System.out.println("depart-time"+DepartTime);
				break;
				
			case "arrival-time":
				String arrivlTime = train.getAttribute("textContent");
				System.out.println( "arrival-time"+arrivlTime);
				break;
			default:
				break;
			}
			System.out.println("\n\n");
		}
	}

}