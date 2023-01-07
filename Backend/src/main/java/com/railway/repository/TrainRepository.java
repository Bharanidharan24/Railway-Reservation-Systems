package com.railway.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.railway.entity.Train;

@Repository
public interface TrainRepository  extends JpaRepository <Train,Long> {

	@Query
	("select capacity from Train where train_id=:trainId")
public	Long findByCapacity(Long trainId);
	@Query
	("select capacity from Train where train_name=:trainName")
public	Long findByTrainName(String trainName);
}

