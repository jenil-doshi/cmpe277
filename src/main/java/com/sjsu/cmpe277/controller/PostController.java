package com.sjsu.cmpe277.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sjsu.cmpe277.model.Posting;
import com.sjsu.cmpe277.service.PostService;

@Controller
public class PostController {

	@Autowired
	PostService landlordService;
	
	@RequestMapping(value = "/posting", method = RequestMethod.POST, consumes="application/json", headers = "content-type=application/x-www-form-urlencoded")
	public @ResponseBody Posting insertUserType(HttpServletRequest request) {
		Posting posting = new Posting();
		/*posting.setBath(request.getParameter("bath"));
		posting.setCity(request.getParameter("city"));
		posting.setContact(request.getParameter("contact"));
		posting.setDescription(request.getParameter("description"));
		posting.setEmail(request.getParameter("email"));
		posting.setPostingName(request.getParameter("postingName"));
		posting.setPrice(request.getParameter("price"));
		*/
		return landlordService.insertPosting(posting);
	}

}
