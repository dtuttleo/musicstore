package com.practicing.musicstore.unittests;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.practicing.musicstore.model.Album;
import com.practicing.musicstore.repository.AlbumDao;
import com.practicing.musicstore.service.AlbumService;
import com.practicing.musicstore.service.DefaultAlbumService;

public class AlbumServiceTest {

	@Test
	public void shouldCreateAlbum() {

		AlbumDao dao = mock(AlbumDao.class);
		AlbumService service = new DefaultAlbumService(dao);
		Album album = new Album("albumname", "bandname", 1524);

		service.createAlbum(album);

		verify(dao).add(album);
	}

	@Test
	public void shouldReturnAllAlbums() {
		AlbumDao dao = mock(AlbumDao.class);
		AlbumService service = new DefaultAlbumService(dao);
		List<Album> albums = Arrays
				.asList(new Album("album1", "artist1", 1687), new Album("album 2", "artist 2", 1358));
		when(dao.getAllAlbums()).thenReturn(albums);

		List<Album> returnedAlbums = service.getAlbumList();

		assertThat(returnedAlbums).isEqualTo(albums);
	}

}
