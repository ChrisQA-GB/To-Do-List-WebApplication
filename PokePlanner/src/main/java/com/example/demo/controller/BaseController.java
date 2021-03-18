package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.DTO.PokeTaskDTO;

public class BaseController {

	@GetMapping("/test")
	@ResponseBody
	public PokeTaskDTO returnSomething() {
		return new PokeTaskDTO();
	}
	
}