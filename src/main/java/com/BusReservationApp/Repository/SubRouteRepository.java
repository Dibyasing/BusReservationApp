package com.BusReservationApp.Repository;

import com.BusReservationApp.Entity.Route;
import com.BusReservationApp.Entity.SubRoute;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubRouteRepository extends JpaRepository<SubRoute , Long> {
    SubRoute findByBusId(long busId);
    List<SubRoute> findByFromLocationAndToLocationAndFromDate(String fromLocation, String toLocation, String fromDate);
}
