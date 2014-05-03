package com.practicing.musicstore.unittests.matcher;

import org.fest.assertions.Assertions;
import org.fest.assertions.GenericAssert;

import com.practicing.musicstore.model.Album;

public class AlbumAssert extends GenericAssert<AlbumAssert, Album> {

	public AlbumAssert(Album actual) {

		super(AlbumAssert.class, actual);
	}

	public static AlbumAssert assertThat(Album actual) {

		return new AlbumAssert(actual);
	}

	public AlbumAssert hasName(String name) {

		isNotNull();
		String errorMessage = String.format("Expected album's name: <%s> but was: <%s>", name, actual.getName());

		Assertions.assertThat(actual.getName()).overridingErrorMessage(errorMessage).isEqualTo(name);

		return this;
	}

	public AlbumAssert hasAuthor(String author) {

		isNotNull();
		String errorMessage = String.format("Expected album's author: <%s> but was: <%s>", author, actual.getAuthor());

		Assertions.assertThat(actual.getAuthor()).overridingErrorMessage(errorMessage).isEqualTo(author);

		return this;
	}

	public AlbumAssert releasedIn(int year) {
		String errorMessage = String.format("Expected album's release year: <%s> but was: <%s>", year,
				actual.getYearOfRelease());

		Assertions.assertThat(actual.getYearOfRelease()).overridingErrorMessage(errorMessage).isEqualTo(year);

		return this;
	}

}
