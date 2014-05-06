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
	private Album album = new Album(RandomStringUtils.randomAlphanumeric(30), RandomStringUtils.randomAlphabetic(20),
			RandomUtils.nextInt(0, 10000));

	@Before
	public void initDriver() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/musicstore");
		mainPage = new MainPage(driver);
		createAlbumPage = new CreateAlbumPage(driver);
	}

	@Test
	public void appShouldDisplayWelcomeMessage() {

		assertThat(mainPage.getHeader().getText()).isEqualTo("Music Store");
	}

	@Test
	public void newAlbumShouldBeCreated() {

		mainPage.getCreateAlbumLink().click();

		createAlbumPage.createAlbum(album);

		assertThat(createAlbumPage.getSuccessLabel().getText()).isEqualTo("Album Succesfully Created");

	}

	@Test
	public void recentlyCreatedAlbumShouldBelisted() {
		mainPage.getCreateAlbumLink().click();

		createAlbumPage.createAlbum(album);
		mainPage.getHomeLink().click();

		assertThat(mainPage.isAlbumListed(album)).isTrue();
	}

	@After
	public void closeDriver() {
		driver.close();
	}

}
