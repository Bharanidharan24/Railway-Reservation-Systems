package com.railway.service;

import java.util.List;
import java.util.Optional;

import com.railway.entity.Train;
import com.railway.entity.User;
import com.railway.error.TrainNotFoundException;
import com.railway.error.UserNotFoundException;

public interface UserService {

	public User save(User user);

	public String userTicketBooking(Long userId, Long trainId);

	public List<User> getUserById(Long userId) throws UserNotFoundException ;


	public List<User> userDeleteById(Long userId) throws UserNotFoundException;

	public List<User> findAllUsers();

}

