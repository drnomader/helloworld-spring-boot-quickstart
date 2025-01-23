package com.helloworld.quickstart.controller;

import com.helloworld.quickstart.dto.ItemDto;
import com.helloworld.quickstart.dto.ResponseDto;
import com.helloworld.quickstart.service.QuickService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
public class QuickController {

	@Autowired
	private QuickService quickService;

	@GetMapping("/dummy")
	public String dummy() {
		log.info("dummy");
		return "{}";
	}

	@GetMapping("/dummy2")
	public String dummy2() {
		log.info("dummy2");
		return "dummy2";
	}

	@GetMapping("/member")
	public String getMember(@RequestParam String empNo, @RequestParam int year) {
		log.info("empNo: {}", empNo);
		log.info("year: {}", year);
		return "OK";
	}

	@GetMapping("/company/{id}")
	public String getMember(@PathVariable String id) {
		log.info("id: {}", id);
		return "OK";
	}

	@PostMapping("/item")
	public ResponseDto registerItem(@RequestBody ItemDto item) {
		log.info("item: {}", item);

		boolean b = quickService.registerItem(item);

		if (b) {
			ResponseDto responseDto = new ResponseDto();
			responseDto.setMessage("OK");
			return responseDto;
		}

		ResponseDto responseDto = new ResponseDto();
		responseDto.setMessage("FAIL");
		return responseDto;
	}

	@GetMapping("/item")
	public ItemDto getItem(@RequestParam String id) {
		ItemDto res = quickService.getItemById(id);
		return res;
	}
}
