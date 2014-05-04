package com.practicing.musicstore.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practicing.musicstore.model.Album;
import com.practicing.musicstore.repository.AlbumDao;

@Transactional(readOnly = true)
@Service
public class DefaultAlbumService implements AlbumService {

	private AlbumDao dao;

	@Inject
	public DefaultAlbumService(AlbumDao dao) {
		this.dao = dao;
	}

	@Override
	@Transactional(readOnly = false)
	public void createAlbum(Album album) {
		dao.add(album);
	}

	@Override
	public List<Album> getAlbumList() {
		return dao.getAllAlbums();
	}

}
