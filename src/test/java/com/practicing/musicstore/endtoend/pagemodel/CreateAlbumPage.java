package com.practicing.musicstore.endtoend.pagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.practicing.musicstore.model.Album;

public class CreateAlbumPage {

	@FindBy(name = "name")
	private WebElement albumNameTexbox;

	@FindBy(name = "author")
	private WebElement authorTextbox;

	@FindBy(name = "yearOfRelease")
	private WebElement yearOfReleaseTextBox;

	@FindBy(css = "input[type='submit']")
	private WebElement submitButton;

	public CreateAlbumPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	public WebElement getAlbumNameTextbox() {
		return albumNameTexbox;
	}

	public WebElement getAuthorTextbox() {
		return authorTextbox;
	}

	public WebElement getYearOfReleaseTextbox() {
		return yearOfReleaseTextBox;
	}

	public WebElement getSubmitButton() {
		return submitButton;
	}

	public void createAlbum(Album album) {
		getAlbumNameTextbox().sendKeys(album.getName());
		getAuthorTextbox().sendKeys(album.getAuthor());
		getYearOfReleaseTextbox().sendKeys(String.valueOf(album.getYearOfRelease()));
		getSubmitButton().click();
	}

}
