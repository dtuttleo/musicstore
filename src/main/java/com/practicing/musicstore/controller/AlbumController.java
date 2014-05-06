package com.practicing.musicstore.controller;

import java.util.List;
import java.util.Objects;

import javax.inject.Inject;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.support.PagedListHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.practicing.musicstore.model.Album;
import com.practicing.musicstore.service.AlbumService;

@Controller
public class AlbumController {

	AlbumService service;

	@Inject
	public AlbumController(AlbumService albumService) {
		this.service = albumService;
	}

	public AlbumController() {

	}

	@InitBinder
	public void setAllowedFields(WebDataBinder dataBinder) {
		dataBinder.setAllowedFields("name", "author", "yearOfRelease");
	}

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index(Model model, HttpSession session, @RequestParam(value = "page", required = false) String page) {

		if (Objects.isNull(page) || page.isEmpty()) {
			List<Album> albumList = service.getAlbumList();

			PagedListHolder<Album> pagedAlbumList = new PagedListHolder<>(albumList);

			model.addAttribute("albums", pagedAlbumList);
			session.setAttribute("albums", pagedAlbumList);

			return "index";
		} else {
			@SuppressWarnings("unchecked")
			PagedListHolder<Album> pagedAlbumList = (PagedListHolder<Album>) session.getAttribute("albums");
			switch (page) {
			case "next":
				pagedAlbumList.nextPage();
				break;
			case "previous":
				pagedAlbumList.previousPage();
				break;
			}
			return "index";
		}
	}

	@RequestMapping(value = "/album", method = RequestMethod.GET)
	public String createAlbum(Model model) {

		model.addAttribute("album", new Album());
		return "createAlbum";
	}

	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String createAlbum(@ModelAttribute("album") @Valid Album album, BindingResult result, HttpSession session,
			Model model) {

		if (result.hasErrors()) {

			return "createAlbum";
		}

		service.createAlbum(album);

		model.addAttribute("success", true);
		model.addAttribute("album", new Album());

		return "createAlbum";

	}

}
