package com.practicing.musicstore.repository;

import java.util.List;

import com.practicing.musicstore.model.Album;

public interface AlbumDao {

	void add(Album album);

	List<Album> getAllAlbums();

}
