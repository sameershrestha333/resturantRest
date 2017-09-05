package com.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.User;
import com.rest.service.UserService;

@RestController
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	// CRUD

	// Retrieve
	@GetMapping
	public Object index() {
		return userService.findAll();

	}

	// Retrieve by email
	@GetMapping("/get-by-email")
	public String getByEmail(String email) {
		String userId="";
		
		try {
			User user=userService.findByEmail(email);
			userId=String.valueOf(user.getId());
			
		} catch (Exception e) {
			return "User not found";
		}
		
		return "The user id is : "+userId;

	}
	
	// Update User POST http().
		@PutMapping("/update/{id}")
		public String updateUser(@RequestBody User user, @PathVariable long id) {
			try {
				user.setId(id);
				userService.save(user);
				System.out.println("User updated successfully with Id :" + id);

			} catch (Exception ex) {
				System.out.println("Error in updating the user" + ex.toString());
			}
			return "User updated successfully with Id : " + id;
		}

	// Create User POST http().
	@PostMapping("/create")
	public String saveUser(@RequestBody User user) {
		String id = "";
		try {
			userService.save(user);
			id = String.valueOf(user.getId());
			System.out.println("User created successfully with Id :" + id);

		} catch (Exception ex) {
			System.out.println("Error in creating the user" + ex.toString());
		}
		return "User created successfully with Id : " + id;
	}

	// Delete
	// @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE,
	// headers = "Accept=application/json")
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable Long id) {
		try {
			User user = userService.findById(id);
			userService.delete(user);
			System.out.println("User Successfull deleted with id : " + id);
		} catch (Exception ex) {
			System.out.println("Error in deleting user." + ex.toString());

		}
		return "User Successfull deleted with id : " + id;
	}

}
