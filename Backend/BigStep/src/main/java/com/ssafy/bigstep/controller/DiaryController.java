package com.ssafy.bigstep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ssafy.bigstep.model.dto.Diary;
import com.ssafy.bigstep.model.service.DiaryService;

import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/diary-api")
@CrossOrigin("*")
public class DiaryController {
	
	@Autowired
	DiaryService dService;
	
	public ResponseEntity<?> exceptionHandling(Exception e) {
		return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@GetMapping("/diarys/{userId}")
	@ApiOperation(value="다이어리 목록 조회", notes="{userId}에 해당하는 유저가 작성한 diary 목록을 조회한다.")
	public ResponseEntity<?> getList(@PathVariable String userId){
		try {
			List<Diary> list = dService.selectDiarys(userId);
			if(list == null) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<List<Diary>>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@GetMapping("/diary/{diaryId}")
	@ApiOperation(value="다이어리 상세 조회", notes="{diaryId}에 해당하는 diary의 상세 정보를 조회한다.")
	public ResponseEntity<?> getDetail(@PathVariable int diaryId){
		try {
			Diary diary = dService.selectDiary(diaryId);
			if(diary == null) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Diary>(diary, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PostMapping("/diary")
	@ApiOperation(value="다이어리 등록", notes="JSON 형태로 입력받은 diary를 등록한다.")
	public ResponseEntity<?> insertDiary(@RequestBody Diary diary){
		try {
			int result = dService.insertDiary(diary);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Diary>(diary, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@PutMapping("/diary")
	@ApiOperation(value="다이어리 수정", notes="JSON 형태로 입력받은 diary 정보를 바탕으로 diary를  수정한다.")
	public ResponseEntity<?> updateDiary(@RequestBody Diary diary){
		try {
			int result = dService.updateDiary(diary);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Diary>(diary, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
	@DeleteMapping("/diary/{diaryId}")
	@ApiOperation(value="다이어리 삭제", notes="{diaryId}에 해당하는 diary를 삭제한다.")
	public ResponseEntity<?> deleteDiary(@PathVariable int diaryId){
		try {
			int result = dService.deleteDiary(diaryId);
			if(result == 0) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<Integer>(result, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	
}
