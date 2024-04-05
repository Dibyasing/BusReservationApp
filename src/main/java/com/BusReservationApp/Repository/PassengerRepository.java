package com.BusReservationApp.Repository;

import com.BusReservationApp.Entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PassengerRepository extends JpaRepository<Passenger , Long> {
}
