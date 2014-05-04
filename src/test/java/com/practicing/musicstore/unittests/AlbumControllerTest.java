package com.practicing.musicstore.unittests;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.practicing.musicstore.controller.AlbumController;
import com.practicing.musicstore.model.Album;
import com.practicing.musicstore.service.AlbumService;

public class AlbumControllerTest {

	private AlbumService albumService = mock(AlbumService.class);
	private AlbumController albumController = new AlbumController(albumService);
	private MockMvc mockMvc;

	@Before
	public void setup() {
		this.mockMvc = MockMvcBuilders.standaloneSetup(albumController).build();
	}

	@Test
	public void shouldReturnCreateAlbumPage() throws Exception {
		ResultActions actions = this.mockMvc.perform(get("/album").accept(MediaType.TEXT_HTML));

		actions.andExpect(status().isOk()).andExpect(view().name("createAlbum"));
	}

	@Test
	public void shouldReturnSuccessCreatingNewAlbum() throws Exception {
		ResultActions actions = this.mockMvc.perform(post("/album").accept(MediaType.TEXT_HTML));

		actions.andExpect(status().isOk()).andExpect(model().attribute("success", true))
				.andExpect(view().name("index"));
	}

	@Test
	public void shouldCreateNewAlbum() throws Exception {

		Album album = new Album("Album 1", "Band 1", 1987);

		this.mockMvc.perform(post("/album").param("name", album.getName()).param("author", album.getAuthor())
				.param("yearOfRelease", String.valueOf(album.getYearOfRelease())));

		verify(albumService).createAlbum(album);
	}

	@Test
	public void shouldListAllAlbums() throws Exception {
		List<Album> albumList = Arrays.asList(new Album("album1", "artist1", 1687), new Album("album 2", "artist 2",
				1358));
		when(albumService.getAlbumList()).thenReturn(albumList);

		ResultActions actions = this.mockMvc.perform(get("/").accept(MediaType.TEXT_HTML));

		actions.andExpect(status().isOk()).andExpect(model().attribute("albums", albumList))
				.andExpect(view().name("index"));

	}

}
