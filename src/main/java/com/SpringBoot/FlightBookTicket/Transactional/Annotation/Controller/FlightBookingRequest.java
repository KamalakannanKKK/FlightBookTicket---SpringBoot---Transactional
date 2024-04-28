package com.SpringBoot.FlightBookTicket.Transactional.Annotation.Controller;

import com.SpringBoot.FlightBookTicket.Transactional.Annotation.Entity.PassengerInfo;
import com.SpringBoot.FlightBookTicket.Transactional.Annotation.Entity.PaymentInfo;

public class FlightBookingRequest {


    private PassengerInfo passengerInfo;

    private PaymentInfo paymentInfo;

	public PassengerInfo getPassengerInfo() {
		return passengerInfo;
	}

	public void setPassengerInfo(PassengerInfo passengerInfo) {
		this.passengerInfo = passengerInfo;
	}

	public PaymentInfo getPaymentInfo() {
		return paymentInfo;
	}

	public void setPaymentInfo(PaymentInfo paymentInfo) {
		this.paymentInfo = paymentInfo;
	}

	public FlightBookingRequest(PassengerInfo passengerInfo, PaymentInfo paymentInfo) {
		super();
		this.passengerInfo = passengerInfo;
		this.paymentInfo = paymentInfo;
	}

	public FlightBookingRequest() {
		super();
	}
    
    
    
}
