package com.circleash.spring.lesson01;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/lesson01/test01")
public class Test01Controller {
	
	@RequestMapping("/1")
	@ResponseBody
	//String은 text/plain 형태로 변화되는데 컨버터를 통해 자동적으로 바뀌는 것임.
	//크롬이 html로 처리 하는것임. 내부적으로 봤을때는 text/plain
	public String printString() {
		String htmlString = "<h1>테스트 프로젝트 완성</h1> <br> <b>해당 프로젝트를 통해서 문제풀이를 진행합니다.</b>";
		
		return htmlString;
	}
	@RequestMapping("/2")
	@ResponseBody
	public Map<String, Integer> printMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("국어" , 80);
		map.put("수학" , 90);
		map.put("영어" , 85);
		
		return map;
	}
	
	
}
