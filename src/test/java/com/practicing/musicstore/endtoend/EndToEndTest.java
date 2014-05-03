package com.practicing.musicstore.endtoend;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class EndToEndTest {

	WebDriver driver;

	@Before
	public void initDriver() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/musicstore");
	}

	@Test
	public void appShouldDisplayWelcomeMessage() {
		String welcomeText = driver.findElement(By.tagName("h1")).getText();

		assertThat(welcomeText).isEqualTo("Hello world!");
	}

	@Test
	public void newAlbumShouldBeCreated() {
		driver.findElement(By.cssSelector("a[data-testid='createAlbumLink']")).click();
		driver.findElement(By.cssSelector("input[name='name']")).sendKeys("AlbumName");
		;
		driver.findElement(By.cssSelector("input[name='author']")).sendKeys("band Name");
		;
		driver.findElement(By.cssSelector("input[name='yearOfRelease']")).sendKeys("Year");
		driver.findElement(By.cssSelector("input[type='submit']")).click();

		String text = driver.findElement(By.cssSelector("label[data-testid='success']")).getText();
		assertThat(text).isEqualTo("Album Succesfully Created");

	}

	@After
	public void closeDriver() {
		driver.close();
	}

}
