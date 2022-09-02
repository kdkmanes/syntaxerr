package com.syntaxerror.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.syntaxerror.crud.entity.Users;
import com.syntaxerror.crud.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/allUsers")
	public ResponseEntity<List<Users>> getAllUsers(){
		List<Users>users=null;
		try {
			users=userService.getAllUsers();
			
		}catch (Exception e) {
			e.getMessage();
		}
		return new ResponseEntity<List<Users>>(users,HttpStatus.OK);
		
	}
	
}
