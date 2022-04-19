package com.cap.cb.entities;


import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Driver extends AbstractUser implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int driverId;
	private String licenceNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name ="cabId", referencedColumnName = "cabId")
	private Cab cab;
	
	private float rating;
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "driverId",
			referencedColumnName = "driverId")
	List<TripBooking> tripBookings;
	
}
