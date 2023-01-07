package com.railway.service;


import java.util.List;

import com.railway.entity.Train;
import com.railway.error.TrainNotFoundException;

public interface TrainService {

	public Train save(Train train);

	public List<Train> getTrainById(Long trainId) throws TrainNotFoundException;

	public void trainDeleteById(Long trainId) throws TrainNotFoundException;

	public Train trainUpdateById(Long trainId, Train train) throws TrainNotFoundException;

	public List<Train> findAllTrains();

	public Long findByTrainName(String trainName);

	public Long findByCapacity(Long trinId);

	public boolean isAvailable();

}

