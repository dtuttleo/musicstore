package com.practicing.musicstore.endtoend.pagemodel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MainPage {

	@FindBy(css = "a[data-testid='createAlbumLink']")
	private WebElement createAlbumLink;

	@FindBy(tagName = "h1")
	private WebElement header;

	@FindBy(css = "label[data-testid='success']")
	private WebElement successLabel;

	public MainPage(WebDriver driver) {
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

}
