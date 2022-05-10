package com.system.car;

import com.system.car.address.address;
import com.system.car.address.addressRepository;
import com.system.car.car.car;
import com.system.car.car.carRepository;
import com.system.car.person.person;
import com.system.car.person.personRepository;
import org.apache.tomcat.jni.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class CarManagementApplication  implements CommandLineRunner {

	@Autowired
	personRepository pRepo;

	@Autowired
	addressRepository aRepo;

	@Autowired
	carRepository cRepo;
	public static void main(String[] args) {
		SpringApplication.run(CarManagementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {





	}
}
