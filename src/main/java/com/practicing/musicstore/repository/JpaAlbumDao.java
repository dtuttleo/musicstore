package com.practicing.musicstore.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.practicing.musicstore.model.Album;

@Repository
public class JpaAlbumDao implements AlbumDao {

	@PersistenceContext
	EntityManager entityManager;

	public JpaAlbumDao(EntityManager manager) {
		entityManager = manager;

	}

	public JpaAlbumDao() {

	}

	@Override
	public void add(Album album) {
		entityManager.persist(album);

	}

}
