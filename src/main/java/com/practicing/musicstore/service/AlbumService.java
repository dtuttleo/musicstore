package com.practicing.musicstore.service;

import java.util.List;

import com.practicing.musicstore.model.Album;

public interface AlbumService {

	void createAlbum(Album album);

	List<Album> getAlbumList();
}
