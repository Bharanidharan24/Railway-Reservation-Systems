package com.railway.controller;


import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.railway.entity.Train;
import com.railway.error.TrainNotFoundException;
import com.railway.service.TrainService;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class TrainController {
	@Autowired
	private TrainService trainService;
	private final Logger logger = LoggerFactory.getLogger(TrainController.class);

	@PostMapping("/trains")
	public String  save(@Valid @RequestBody Train train) {
		logger.info("Train Saved");
		 trainService.save(train);
		 return "Hi "+train.getTrainName()+" your train registeration successfully completed";
		
	}

	@GetMapping("/trains/{trainid}")
	public List<Train> geTrainById(@PathVariable("trainid") Long trainId) throws TrainNotFoundException {

		return trainService.getTrainById(trainId);
	}


	@GetMapping("/findAll")
	public List<Train> getAllTrains() {
		return trainService.findAllTrains();

	}

	@DeleteMapping("/trains/{trainid}")
	public String deleteTrainById(@PathVariable("trainid") Long trainId) throws TrainNotFoundException {
		trainService.trainDeleteById(trainId);
		return "Train is deleted";
	}

	@PutMapping("/Trains/{trainId}")
	public String trainUpdateById(@PathVariable("trainId") Long trainId, @RequestBody Train train)
			throws TrainNotFoundException {
		logger.info("Train updated ");
		 trainService.trainUpdateById(trainId, train);
		 return train.getTrainName()+" "+"TrainUpdated";
	}

	@GetMapping("/trains/trainname/{trainName}")

	public Long findByTrainName(@PathVariable("trainName") String trainName) {

		return trainService.findByTrainName(trainName);
	}
	@GetMapping("/trains/trainCapacity/{trainId}")
	public Long findByCapacity(@PathVariable("trainId") long trainId) {
		return trainService.findByCapacity(trainId);
		
	}

}

