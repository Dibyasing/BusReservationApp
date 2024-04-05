package com.BusReservationApp.Service;

import com.BusReservationApp.Entity.Bus;
import com.BusReservationApp.Entity.Route;
import com.BusReservationApp.Entity.SubRoute;
import com.BusReservationApp.Exception.ResourceNotFound;
import com.BusReservationApp.Repository.BusRepository;
import com.BusReservationApp.Repository.SubRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SubRouteService {
    @Autowired
    private SubRouteRepository subRouteRepository;
    @Autowired
    private BusRepository busRepository;

    public SubRoute createSubRoute(long busId , SubRoute subRoute){
        Bus bus = busRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFound("Bus not added!!")
        );
        SubRoute s = subRouteRepository.findByBusId(subRoute.getBusId());

        if (s!=null){
            throw  new ResourceNotFound("Hogeya bhai aurr kitna add karega!!!!");
        }

        if(s==null){
              subRouteRepository.save(subRoute);
              return subRoute;
        }
        return null;
    }

}
