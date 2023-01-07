package com.railway.service;



import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.railway.entity.Train;
import com.railway.entity.User;
import com.railway.error.TrainNotFoundException;
import com.railway.repository.TrainRepository;
import com.railway.repository.UserRepository;

@Service
public class TrainServiceIml implements TrainService {

	@Autowired
	private TrainRepository trainRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public Train save(Train train) {
		// TODO Auto-generated method stub
		return trainRepository.save(train);
	}

	 @Override
	public List<Train> getTrainById(Long trainId) throws TrainNotFoundException {
		Optional<Train> dept = trainRepository.findById(trainId);

		if (!dept.isPresent()) {
			throw new TrainNotFoundException("Train Not Found");
		}
		Train t=trainRepository.findById(trainId).get();
		List<Train> tob=new ArrayList<>();
		tob.add(t);
		return tob;
	}

	@Override
	public void trainDeleteById(Long trainId) throws TrainNotFoundException {
		Optional<Train> dept = trainRepository.findById(trainId);
		if (!dept.isPresent()) {
			throw new TrainNotFoundException("Train Not Found");
		}
		trainRepository.deleteById(trainId);

	}

	@Override
	public Train trainUpdateById(Long trainId, Train train) throws TrainNotFoundException {
		Optional<Train> tr = trainRepository.findById(trainId);
		Train trainDB;
		if (!tr.isPresent()) {
			throw new TrainNotFoundException("Train Not Found");
		}

		else {
			trainDB = trainRepository.findById(trainId).get();

			if (Objects.nonNull(train.getTrainName()) && !"".equalsIgnoreCase(train.getTrainName())) {
				trainDB.setTrainName(train.getTrainName());
			}
			if (Objects.nonNull(train.getFrom_to()) && !"".equalsIgnoreCase(train.getFrom_to())) {
				trainDB.setFrom_to(train.getFrom_to());
			}
			if (Objects.nonNull(train.getTime()) && !"".equalsIgnoreCase(train.getFrom_to())) {
				trainDB.setTime(train.getTime());
			}

		}
		return trainRepository.save(trainDB);

	}

	@Override
	public List<Train> findAllTrains() {
		// TODO Auto-generated method stub
		return trainRepository.findAll();
	}

	@Override
	public Long findByTrainName(String trainName) {
		// TODO Auto-generated method stub
		return trainRepository.findByTrainName(trainName);
	}

	@Override
	public boolean isAvailable() {
		
		return false;
	}

	@Override
	public Long findByCapacity(Long trinId) {
		return trainRepository.findByCapacity(trinId);
	}

}

