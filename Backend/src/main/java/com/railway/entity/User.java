package com.railway.entity;

import java.sql.Date;
import javax.validation.Valid;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@NotBlank(message = "Please Enter UserName")
	private String userName;
	@NotBlank(message = "Please Enter Gender")
	private String gender;
	private Date date;
	private Long phNo;
	
	@Valid
	@NotNull(message = "adharNumber is mandatory")
	private Long adharNo;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "train_Id", referencedColumnName = "trainId")
//	@JsonIgnoreProperties("user")

	private Train train;

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Long getPhNo() {
		return phNo;
	}

	public void setPhNo(Long phNo) {
		this.phNo = phNo;
	}

	public Long getAdharNo() {
		return adharNo;
	}

	public void setAdharNo(Long adharNo) {
		this.adharNo = adharNo;
	}

	public Train getTrain() {
		return train;
	}

	public void setTrain(Train train) {
		this.train = train;
	}

	public User(Long userId, String userName, String gender, Date date, Long phNo, Long adharNo, Train train) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.gender = gender;
		this.date = date;
		this.phNo = phNo;
		this.adharNo = adharNo;
		this.train = train;
	}

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", userName=" + userName + ", gender=" + gender + ", date=" + date + ", phNo="
				+ phNo + ", adharNo=" + adharNo + ", train=" + train + "]";
	}
	public void userTicketBooking(Train train) {
		this.train=train;
	}

}