package com.ssafy.bigstep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.bigstep.model.service.CommentService;

@RestController
@RequestMapping("/comment")
@CrossOrigin("*")
public class CommentController {
	
	@Autowired
	CommentService cService;
}
