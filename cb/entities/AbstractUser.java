package com.cap.cb.entities;


import javax.persistence.MappedSuperclass;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public  class  AbstractUser {
	String userName;
	String upassword;
	String address;
	String mobileNumber;
	String uemail;
}
