package com.practicing.musicstore.endtoend;



import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.fest.assertions.Assertions.*;

public class EndToEndTest {
	
	WebDriver driver;
	
	@Before
	public void initDriver()
	{
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/musicstore");
	}
	
	@Test
	public void appShouldDisplayWelcomeMessage()
	{
		
		String welcomeText = driver.findElement(By.tagName("h1")).getText();
		
		assertThat(welcomeText).isEqualTo("Hello world!");
	}
	
	@After
	public void closeDriver()
	{
		driver.close();
	}
	
}
