package com.desarrollo.barberia.rest;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.desarrollo.barberia.bussiness.AdminService;
import com.desarrollo.barberia.model.Admin;



@RestController
@RequestMapping("api")
public class AdminRest {
	@Autowired
	private AdminService adminService;
	@GetMapping("get")
	public String get() {
		return "Hello World";
	}

	
	
}
