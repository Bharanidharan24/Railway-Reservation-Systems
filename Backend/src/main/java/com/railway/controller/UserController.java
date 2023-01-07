package com.railway.controller;



import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;

import com.railway.entity.User;
import com.railway.error.UserNotFoundException;
import com.railway.service.TrainService;
import com.railway.service.UserService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class UserController {
	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserService userService;

	@PostMapping("/user")
	public String save(@Validated @RequestBody User user) {
		logger.info("User Saved");
		 userService.save(user);
	return "Hi "  +user.getUserName()+" your registration  successfully completed";
	}

	@GetMapping("/users/{userId}")
	public List<User> getUserById(@PathVariable("userId") Long userId)throws UserNotFoundException  {
		return userService.getUserById(userId);
	}

	@ResponseBody
	@PutMapping("/userTicketBooking/{userId}/trains/{trainId}")
	public String userTicketBooking(@PathVariable Long userId, @PathVariable Long trainId) {
		System.out.println("Your seat is booked ");
		return userService.userTicketBooking(userId, trainId);

	}

	@GetMapping("/getAllusers")
	public List<User> findAllUsers(){
		return userService.findAllUsers();
	}

	@DeleteMapping("/delete/{id}")
	public List<User>deleteUserById(@PathVariable("id") Long userId) throws UserNotFoundException {
		 return userService.userDeleteById(userId);
		
	}

}
