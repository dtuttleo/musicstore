package com.practicing.musicstore.endtoend;

import static org.fest.assertions.Assertions.assertThat;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.practicing.musicstore.endtoend.pagemodel.CreateAlbumPage;
import com.practicing.musicstore.endtoend.pagemodel.MainPage;
import com.practicing.musicstore.model.Album;

public class EndToEndTest {

	private WebDriver driver;
	private MainPage mainPage;
	private CreateAlbumPage createAlbumPage;

	@Before
	public void initDriver() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/musicstore");
		mainPage = new MainPage(driver);
		createAlbumPage = new CreateAlbumPage(driver);
	}

	@Test
	public void appShouldDisplayWelcomeMessage() {

		assertThat(mainPage.getHeader().getText()).isEqualTo("Hello world!");
	}

	@Test
	public void newAlbumShouldBeCreated() {
		Album album = new Album(RandomStringUtils.randomAlphanumeric(30), RandomStringUtils.randomAlphabetic(20),
				RandomUtils.nextInt(0, 10000));

		mainPage.getCreateAlbumLink().click();

		createAlbumPage.createAlbum(album);

		assertThat(mainPage.getSuccessLabel().getText()).isEqualTo("Album Succesfully Created");

	}

	@After
	public void closeDriver() {
		driver.close();
	}

}
