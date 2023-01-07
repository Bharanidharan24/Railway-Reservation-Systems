package com.railway.entity;

import java.sql.Time;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity

public class Train {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long trainId;
	@NotBlank(message = "Please enter TrainName")
	private String trainName;
	private String from_to;
	@NotBlank(message = "Please enter Day")
	private String day;
	private String time;
	// private Time time;
	private Long capacity;

	private double charge;

	@JsonIgnore
	@OneToMany(mappedBy = "train")

//	@JoinColumn(name = "userId")
	private Set<User> user;

	public Train() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getTrainId() {
		return trainId;
	}

	public void setTrainId(Long trainId) {
		this.trainId = trainId;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getFrom_to() {
		return from_to;
	}

	public void setFrom_to(String from_to) {
		this.from_to = from_to;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public Long getCapacity() {
		return capacity;
	}

	public void setCapacity(Long capacity) {
		this.capacity = capacity;
	}

	public double getCharge() {
		return charge;
	}

	public void setCharge(double charge) {
		this.charge = charge;
	}

	public Set<User> getUser() {
		return user;
	}

	public void setUser(Set<User> user) {
		this.user = user;
	}

	public Train(Long trainId, String trainName, String from_to, String day, String time, Long capacity, double charge,
			Set<User> user) {
		super();
		this.trainId = trainId;
		this.trainName = trainName;
		this.from_to = from_to;
		this.day = day;
		this.time = time;
		this.capacity = capacity;
		this.charge = charge;
		this.user = user;
	}

	@Override
	public String toString() {
		return "Train [trainId=" + trainId + ", trainName=" + trainName + ", from_to=" + from_to + ", day=" + day
				+ ", time=" + time + ", capacity=" + capacity + ", charge=" + charge + ", user=" + user + "]";
	}

	
	public Long getCapacity( Long id) {
		return id;
	}

}
