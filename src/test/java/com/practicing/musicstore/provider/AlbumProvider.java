package com.practicing.musicstore.provider;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

import com.practicing.musicstore.model.Album;

public class AlbumProvider {

	// private constructor to prevent instantiation
	private AlbumProvider() {

	}

	public static List<Album> getAlbums(int numberOfAlbums) {
		List<Album> albums = new ArrayList<>();
		IntStream.range(0, numberOfAlbums).forEach(index -> albums.add(timeStampedAlbum()));

		return albums;
	}

	public static Album timeStampedAlbum() {
		String name = "name " + RandomStringUtils.randomAlphanumeric(10);
		String author = "author " + RandomStringUtils.randomAlphanumeric(10);
		int year = RandomUtils.nextInt(0, 10000);

		return new Album(name, author, year);
	}

}
