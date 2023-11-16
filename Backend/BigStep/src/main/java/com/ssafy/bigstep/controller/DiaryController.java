package com.ssafy.bigstep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.bigstep.model.service.DiaryService;

@RestController
@RequestMapping("/diary")
@CrossOrigin("*")
public class DiaryController {
	
	@Autowired
	DiaryService dService;
	
	public ResponseEntity<?> exceptionHandling(Exception e) {
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
