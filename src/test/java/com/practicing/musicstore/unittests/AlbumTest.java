package com.practicing.musicstore.unittests;

import static com.practicing.musicstore.unittests.matcher.AlbumAssert.assertThat;

import org.junit.Test;

import com.practicing.musicstore.model.Album;

public class AlbumTest {
	private static String ANY_NAME = "any Name";
	private static String ANY_AUTHOR = "any author";
	private static int ANY_YEAR = 1985;

	@Test
	public void testConstructor() {
		Album album = new Album(ANY_NAME, ANY_AUTHOR, ANY_YEAR);

		assertThat(album).hasName(ANY_NAME).hasAuthor(ANY_AUTHOR).releasedIn(ANY_YEAR);
	}

}
