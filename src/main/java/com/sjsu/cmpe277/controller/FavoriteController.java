package com.sjsu.cmpe277.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.sjsu.cmpe277.service.FavoriteService;

@Controller
public class FavoriteController {

	@Autowired
	FavoriteService favoriteService;

}
