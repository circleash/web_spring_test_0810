package com.circleash.spring.lesson01;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/lesson01/test02")
@RestController
public class Test01RestController {
	
	@RequestMapping("/1")
	public List<Map<String, Object>> list() {
		//리스트를 생성
		List<Map<String, Object>> list = new ArrayList<>();
		//리스트에 저장할 map을 생성
		Map<String, Object> map = new HashMap<>(); 
		map.put("rate", 15);
		map.put("director", "봉준호");
		map.put("time", 131);
		map.put("title", "기생충");
		list.add(map);
		
		map = new HashMap<>(); 
		map.put("rate", 0);
		map.put("director", "로베르토 베니니");
		map.put("time", 116);
		map.put("title", "인생은 아름다워");
		list.add(map);
		
		map = new HashMap<>(); 
		map.put("rate", 12);
		map.put("director", "크리스토퍼 놀란");
		map.put("time", 147);
		map.put("title", "인셉션");
		list.add(map);
		
		map = new HashMap<>(); 
		map.put("rate", 19);
		map.put("director", "윤종빈");
		map.put("time", 133);
		map.put("title", "범죄와의 전쟁");
		list.add(map);
		
		map = new HashMap<>(); 
		map.put("rate", 15);
		map.put("director", "프란시스 로렌스");
		map.put("time", 137);
		map.put("title", "헝거게임");
		list.add(map);
		
		return list;
	}
	
	@RequestMapping("/2")
	//메소드 생성
	public List<boardContents> boardList() {
		List<boardContents> boardList = new ArrayList<>();
		//객체생성
		boardContents content = new boardContents();
		content.setTitle("안녕하세요 가입인사 드립니다");
		content.setUser("hagulu");
		content.setContent("가입완료 잘부탁");
		boardList.add(content);
		//변수 재사용
		content = new boardContents();
		content.setTitle("헐 대박");
		content.setUser("메리");
		content.setContent("오늘 목요일이구만");
		boardList.add(content);
		
		content = new boardContents();
		content.setTitle("크크크");
		content.setUser("루삥");
		content.setContent("오늘 힘드네");
		boardList.add(content);

		return boardList;
	}
	
	@RequestMapping("/3")
	public ResponseEntity<boardContents> entity() {
		boardContents content = new boardContents();
		content.setTitle("안녕하세요 가입인사 드립니다");
		content.setUser("hagulu");
		content.setContent("가입완료 잘부탁");
		
		ResponseEntity<boardContents> entity = new ResponseEntity<>(content, HttpStatus.INTERNAL_SERVER_ERROR);
		return entity;
		
	}
}
