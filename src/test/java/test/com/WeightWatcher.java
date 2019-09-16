package test.com;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class WeightWatcher {
	public static WebDriver driver = new ChromeDriver();

	@Test
	public void verifyMainTitle1() {
		driver.get("https://www.weightwatchers.com/us/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		String expectedTitle = "WW (Weight Watchers): Weight Loss & Wellness Help";
		String ActualTitle = driver.getTitle();
		System.out.println(ActualTitle);
		Assert.assertEquals(ActualTitle, expectedTitle);
	}

	@Test
	public void verifyStudioTitle1() {

		driver.get("https://www.weightwatchers.com/us/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("find-a-meeting")).click();
		String expectedTitle = "Find WW Studios & Meetings Near You | WW USA";
		String ActualTitle = driver.getTitle();
		System.out.println("Expected title is " + expectedTitle);
		System.out.println("Acuatul title is " + ActualTitle);
		Assert.assertEquals(ActualTitle, expectedTitle);

	}

	@Test
	public void printresult() {

		driver.get("https://www.weightwatchers.com/us/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("find-a-meeting")).click();
		driver.findElement(By.id("meetingSearch")).sendKeys("10011");
		driver.findElement(By.xpath("//*[@id='content']/div/div/ui-view/ui-view/div/div[2]/form/div[1]/button")).click();
		List<WebElement> locations = driver.findElements(By.className("meeting-locations-list"));
		WebElement firstlocation = locations.get(0);
		String locationname = firstlocation.findElement(By.className("location__name")).getText();
		System.out.println("The first location name is is " + locationname);
		String distance = firstlocation.findElement(By.className("location__distance")).getText();
		System.out.println("The distance of first location is " + distance);
	}

	@Test
	public void verifyLocationname() {

		driver.get("https://www.weightwatchers.com/us/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("find-a-meeting")).click();
		driver.findElement(By.id("meetingSearch")).sendKeys("10011 ");
		driver.findElement(By.xpath("//*[@id='content']/div/div/ui-view/ui-view/div/div[2]/form/div[1]/button")).click();
		List<WebElement> locations = driver.findElements(By.className("meeting-locations-list__item"));
		WebElement firstlocation = locations.get(0);
		String Expectedlocationname = firstlocation.findElement(By.className("location__name")).getText();
		System.out.println("Expected location name" + Expectedlocationname);
		firstlocation.findElement(By.className("location__name")).click();
		String Actuallocationname = driver.findElement(By.className("location__name")).getText();
		System.out.println("Actual location name is" + Actuallocationname);
		Assert.assertEquals(Actuallocationname, Expectedlocationname);
		String todayhrs = driver.findElement(By.className("hours-list-item-hours")).getText();
		System.out.println("Totay's hrs are " + todayhrs);

	}

	public void printmeetings() {

		driver.get("https://www.weightwatchers.com/us/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.findElement(By.className("find-a-meeting")).click();
		driver.findElement(By.id("meetingSearch")).sendKeys("10011 ");
		driver.findElement(By.xpath("//*[@id='content']/div/div/ui-view/ui-view/div/div[2]/form/div[1]/button")).click();
		List<WebElement> locations = driver.findElements(By.className("meeting-locations-list__item"));
		WebElement firstlocation = locations.get(0);
		firstlocation.findElement(By.className("location__name")).click();
		List<WebElement> schedule = driver.findElements(By.className("schedule-detailed"));
		for (WebElement s : schedule) {
			String day = s.findElement(By.className("schedule-detailed-day-label")).getText();
			List<WebElement> Trainer = s.findElements(By.className("schedule-detailed-day-meetings-item-leader"));
			for (WebElement t : Trainer) {

				System.out.println("Trainers are" + t.getText() + "for day" + day);
			}

		}

	}

}
