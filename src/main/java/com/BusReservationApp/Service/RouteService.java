package com.BusReservationApp.Service;

import com.BusReservationApp.Entity.Bus;
import com.BusReservationApp.Entity.Route;
import com.BusReservationApp.Exception.ResourceNotFound;
import com.BusReservationApp.Repository.BusRepository;
import com.BusReservationApp.Repository.RouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RouteService {
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private BusRepository busRepository;

    public Route createRoute(long busId , Route route){
        Bus bus = busRepository.findById(busId).orElseThrow(
                () -> new ResourceNotFound("Bus not added!!")
        );
        Route r = routeRepository.findByBusId(route.getBusId());

        if (r!=null){
            throw  new ResourceNotFound("Hogeya bhai aurr kitna add karega!!!!");
        }

        if(r==null){
            routeRepository.save(route);
            return route;
        }
      return null;
    }
}
