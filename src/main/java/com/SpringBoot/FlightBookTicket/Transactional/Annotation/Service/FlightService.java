package com.SpringBoot.FlightBookTicket.Transactional.Annotation.Service;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.SpringBoot.FlightBookTicket.Transactional.Annotation.Controller.FlightBookingAcknowledgement;
import com.SpringBoot.FlightBookTicket.Transactional.Annotation.Controller.FlightBookingRequest;
import com.SpringBoot.FlightBookTicket.Transactional.Annotation.Entity.PassengerInfo;
import com.SpringBoot.FlightBookTicket.Transactional.Annotation.Entity.PaymentInfo;
import com.SpringBoot.FlightBookTicket.Transactional.Annotation.Repository.PassengerInfoRepo;
import com.SpringBoot.FlightBookTicket.Transactional.Annotation.Repository.PaymentInfoRepo;
import com.SpringBoot.FlightBookTicket.Transactional.Annotation.utils.PaymentUtils;

@Service
public class FlightService {

    @Autowired
    private PassengerInfoRepo passengerInfoRepository;
    @Autowired
    private PaymentInfoRepo paymentInfoRepository;

    @Transactional//(readOnly = false,isolation = Isolation.READ_COMMITTED,propagation = Propagation.REQUIRED)
    public FlightBookingAcknowledgement bookFlightTicket(FlightBookingRequest request) {

        PassengerInfo passengerInfo = request.getPassengerInfo();
        passengerInfo = passengerInfoRepository.save(passengerInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), passengerInfo.getFare());

        paymentInfo.setPassengerId(passengerInfo.getpId());
        paymentInfo.setAmount(passengerInfo.getFare());
        paymentInfoRepository.save(paymentInfo);
        return new FlightBookingAcknowledgement("SUCCESS", passengerInfo.getFare(), UUID.randomUUID().toString().split("-")[0], passengerInfo);

    }
}
