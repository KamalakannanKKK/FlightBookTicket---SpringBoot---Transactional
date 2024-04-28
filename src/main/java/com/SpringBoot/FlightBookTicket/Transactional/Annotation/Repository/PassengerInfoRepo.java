package com.SpringBoot.FlightBookTicket.Transactional.Annotation.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.SpringBoot.FlightBookTicket.Transactional.Annotation.Entity.PassengerInfo;

@Repository
public interface PassengerInfoRepo extends JpaRepository<PassengerInfo, Long>{

}
