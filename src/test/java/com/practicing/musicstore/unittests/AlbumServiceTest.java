package com.practicing.musicstore.unittests;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import org.junit.Test;

import com.practicing.musicstore.model.Album;
import com.practicing.musicstore.provider.AlbumProvider;
import com.practicing.musicstore.repository.AlbumDao;
import com.practicing.musicstore.service.AlbumService;
import com.practicing.musicstore.service.DefaultAlbumService;

public class AlbumServiceTest {

	@Test
	public void shouldCreateAlbum() {

		AlbumDao dao = mock(AlbumDao.class);
		AlbumService service = new DefaultAlbumService(dao);
		Album album = AlbumProvider.timeStampedAlbum();

		service.createAlbum(album);

		verify(dao).add(album);
	}

	@Test
	public void shouldReturnAllAlbums() {
		AlbumDao dao = mock(AlbumDao.class);
		AlbumService service = new DefaultAlbumService(dao);
		List<Album> albums = AlbumProvider.getAlbums(15);
		when(dao.getAllAlbums()).thenReturn(albums);

		List<Album> returnedAlbums = service.getAlbumList();

		assertThat(returnedAlbums).isEqualTo(albums);
	}

}
