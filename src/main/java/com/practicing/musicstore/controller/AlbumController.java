package com.practicing.musicstore.controller;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String index() {

		return "index";
	}

	@RequestMapping(value = "/album", method = RequestMethod.GET)
	public String createAlbum(Model model) {

		model.addAttribute("album", new Album());
		return "createAlbum";
	}

	@RequestMapping(value = "/album", method = RequestMethod.POST)
	public String createAlbum(@ModelAttribute("album") Album album, BindingResult result, Model model) {

		if (result.hasErrors()) {
		}

		service.createAlbum(album);

		model.addAttribute("success", true);

		return "index";
	}

}
