package com.practicing.musicstore.unittests;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import com.practicing.musicstore.model.Album;
import com.practicing.musicstore.repository.AlbumDao;
import com.practicing.musicstore.repository.JpaAlbumDao;

public class AlbumDaoTest {

	@Test
	public void shouldPersistAlbum() {
		EntityManager manager = mock(EntityManager.class);
		AlbumDao dao = new JpaAlbumDao(manager);
		Album album = new Album("AN", "BN", 2008);

		dao.add(album);

		verify(manager).persist(album);
	}

	@Test
	public void shouldReturnAllAlbums() {
		EntityManager manager = mock(EntityManager.class);
		Query query = mock(Query.class);
		AlbumDao dao = new JpaAlbumDao(manager);
		List<Album> albums = Arrays
				.asList(new Album("album1", "artist1", 1687), new Album("album 2", "artist 2", 1358));

		when(manager.createQuery("from Album")).thenReturn(query);
		when(query.getResultList()).thenReturn(albums);

		List<Album> returnedAlbums = dao.getAllAlbums();

		assertThat(returnedAlbums).isEqualTo(albums);
	}
}
