package com.railway.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.entity.Train;
import com.railway.entity.User;
import com.railway.error.TrainNotFoundException;
import com.railway.error.UserNotFoundException;
import com.railway.repository.TrainRepository;
import com.railway.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TrainRepository trainRepository;	
	@Override
	public User save(User user) {

		return userRepository.save(user);
	}

	@Override
	public String userTicketBooking(Long userId, Long trainId) {
		Train train = trainRepository.findById(trainId).get();

		User user = userRepository.findById(userId).get();
		user.userTicketBooking(train);
		
		long cap=train.getCapacity();
		if(cap>0) {
		cap=cap-1;
		System.out.println("capacity of the train"+cap);
		train.setCapacity(cap);
		trainRepository.save(train);
		return train.getTrainName()+ " train is booked successfully";
		}else {
			return "No tickets are available";
		}

	}

  @Override
	public List<User> getUserById(Long userId) throws UserNotFoundException {
		//Optional<User> user = userRepository.findById(userId);

		/*if (!user.isPresent()) {
			throw new UserNotFoundException("User Not Found");
		}*/
		User t=userRepository.findById(userId).get();
		List<User> tob=new ArrayList<>();
		tob.add(t);
		return tob;
	}

	
	@Override
	public List<User> userDeleteById(Long  userId) throws UserNotFoundException {
			Optional<User> user = userRepository.findById(userId);
			if (!user.isPresent()) {
				throw new UserNotFoundException("User Not Found");
			}
			userRepository.deleteById(userId);
            return userRepository.findAll();
		
	}

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
		
	}

}
