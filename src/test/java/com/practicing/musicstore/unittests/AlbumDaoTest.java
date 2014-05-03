package com.practicing.musicstore.unittests;

import static org.mockito.Mockito.*;

import javax.persistence.EntityManager;

import org.junit.Test;

import com.practicing.musicstore.model.Album;
import com.practicing.musicstore.repository.AlbumDao;
import com.practicing.musicstore.repository.JpaAlbumDao;

public class AlbumDaoTest {

	@Test
	public void shouldPersistAlbum() {
		EntityManager manager = mock(EntityManager.class);
		AlbumDao dao = new JpaAlbumDao(manager);
		Album album = new Album("AN", "BN",2008);
		
		dao.add(album);
		
		verify(manager).persist(album);
	}

}
