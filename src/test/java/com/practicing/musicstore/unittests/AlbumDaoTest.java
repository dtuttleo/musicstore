package com.practicing.musicstore.unittests;

import static org.fest.assertions.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.junit.Test;

import com.practicing.musicstore.model.Album;
import com.practicing.musicstore.provider.AlbumProvider;
import com.practicing.musicstore.repository.AlbumDao;
import com.practicing.musicstore.repository.JpaAlbumDao;

public class AlbumDaoTest {

	@Test
	public void shouldPersistAlbum() {
		EntityManager manager = mock(EntityManager.class);
		AlbumDao dao = new JpaAlbumDao(manager);
		Album album = AlbumProvider.timeStampedAlbum();

		dao.add(album);

		verify(manager).persist(album);
	}

	@Test
	public void shouldReturnAllAlbums() {
		EntityManager manager = mock(EntityManager.class);
		Query query = mock(Query.class);
		AlbumDao dao = new JpaAlbumDao(manager);
		List<Album> albums = AlbumProvider.getAlbums(5);

		when(manager.createQuery("from Album")).thenReturn(query);
		when(query.getResultList()).thenReturn(albums);

		List<Album> returnedAlbums = dao.getAllAlbums();

		assertThat(returnedAlbums).isEqualTo(albums);
	}
}
