package com.practicing.musicstore.endtoend.pagemodel;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practicing.musicstore.model.Album;

public class MainPage {

	private WebDriver driver;

	@FindBy(css = "a[data-testid='createAlbumLink']")
	private WebElement createAlbumLink;

	@FindBy(tagName = "h1")
	private WebElement header;

	@FindBy(css = "label[data-testid='success']")
	private WebElement successLabel;

	public MainPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public WebElement getCreateAlbumLink() {
		return createAlbumLink;
	}

	public WebElement getHeader() {
		return header;
	}

	public WebElement getSuccessLabel() {
		return successLabel;
	}

	public boolean isAlbumListed(Album album) {
		return getRowContainingText(album);

	}

	private boolean getRowContainingText(Album album) {

		WebElement row = driver.findElement(By.xpath(String.format("//tr[contains(.,'%s')]", album.getName())));

		List<WebElement> columns = row.findElements(By.tagName("td"));

		return columns.get(0).getText().equals(album.getName()) && columns.get(1).getText().equals(album.getAuthor())
				&& columns.get(2).getText().equals(String.valueOf(album.getYearOfRelease()));
	}

}
