package com.practicing.musicstore.endtoend;

import static org.fest.assertions.Assertions.assertThat;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.practicing.musicstore.endtoend.pagemodel.CreateAlbumPage;
import com.practicing.musicstore.endtoend.pagemodel.MainPage;
import com.practicing.musicstore.model.Album;
import com.practicing.musicstore.provider.AlbumProvider;

public class EndToEndTest {

	private WebDriver driver;
	private MainPage mainPage;
	private CreateAlbumPage createAlbumPage;
	private Album album = AlbumProvider.timeStampedAlbum();

	@Before
	public void initDriver() {
		driver = new FirefoxDriver();
		driver.get("http://localhost:8080/musicstore");
		mainPage = new MainPage(driver);
		createAlbumPage = new CreateAlbumPage(driver);
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
