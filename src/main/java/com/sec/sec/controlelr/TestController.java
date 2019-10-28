package com.sec.sec.controlelr;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping
@RestController
public class TestController {

	@GetMapping(value = "ok")
	public String returnValue() {
		return "Helo Word";
	}
	
	@GetMapping(value = "block")
	public String returnValueBlock() {
		return "Helo Word - blocked";
	}
}
