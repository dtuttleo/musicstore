package com.practicing.musicstore.unittests;

import static org.mockito.Mockito.*;

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

}
