package com.SpringBoot.FlightBookTicket.Transactional.Annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.FlightBookTicket.Transactional.Annotation.Controller.FlightBookingAcknowledgement;
import com.SpringBoot.FlightBookTicket.Transactional.Annotation.Controller.FlightBookingRequest;
import com.SpringBoot.FlightBookTicket.Transactional.Annotation.Service.FlightService;

@SpringBootApplication
@RestController
@EnableTransactionManagement
public class Application {

	@Autowired
	private FlightService service;


	@PostMapping("/bookFlightTicket")
	public FlightBookingAcknowledgement bookFlightTicket(@RequestBody FlightBookingRequest request){
		return service.bookFlightTicket(request);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
