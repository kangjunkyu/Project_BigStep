package com.ssafy.bigstep.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.ssafy.bigstep.model.dto.Diary;
import com.ssafy.bigstep.model.service.DiaryService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/diary")
@CrossOrigin("*")
@Api(tags="다이어리 관리 Api")
public class DiaryController {
	
	@Autowired
	DiaryService dService;
	
	@Autowired
	ResourceLoader resLoader;
	
	public ResponseEntity<?> exceptionHandling(Exception e) {
		e.printStackTrace();
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
	
	@GetMapping("/{diaryId}")
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
	
	@PostMapping("/")
	@ApiOperation(value="다이어리 등록", notes="JSON 형태로 입력받은 diary를 등록한다.")
	public ResponseEntity<?> insertDiary(@ModelAttribute Diary diary, @RequestParam(required=false) MultipartFile file) 
		throws IllegalStateException, IOException{

		try {
			if(file != null && file.getSize() > 0) {
				Resource res = resLoader.getResource("classpath:/static/upload");
				diary.setImg(System.currentTimeMillis()+"_"+file.getOriginalFilename());
				diary.setOrgImg(file.getOriginalFilename());
				file.transferTo(new File(res.getFile().getCanonicalFile()+"/"+diary.getImg()));
			}
			
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
	
	@PutMapping("/")
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
	
	@DeleteMapping("/{diaryId}")
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
	@GetMapping("/diarys/following/{userId}")
	@ApiOperation(value="팔로잉 다이어리 조회", notes="{userId}에 해당하는 유저가 팔로우하는 유저들의 다이어리 조회")
	public ResponseEntity<?> selectFollowingDiarys(@PathVariable String userId){
		try {
			List<Diary> list = dService.selectFollowingDiarys(userId);
			if(list == null) {
				return new ResponseEntity<Void>(HttpStatus.BAD_REQUEST);
			}else {
				return new ResponseEntity<List<Diary>>(list, HttpStatus.OK);
			}
		} catch (Exception e) {
			return exceptionHandling(e);
		}
	}
	

	
}
