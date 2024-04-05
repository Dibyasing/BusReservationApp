package com.BusReservationApp.Service;

import com.BusReservationApp.Entity.Bus;
import com.BusReservationApp.Entity.Route;
import com.BusReservationApp.Entity.SubRoute;
import com.BusReservationApp.Payload.BusDto;
import com.BusReservationApp.Payload.SubRouteDto;
import com.BusReservationApp.Repository.BusRepository;
import com.BusReservationApp.Repository.RouteRepository;
import com.BusReservationApp.Repository.SubRouteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BusService {
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private SubRouteRepository subRouteRepository;


    public Bus addBus(BusDto busDto) {

        //Create Route Entity
        //Route route = new Route();
        //route.setFromLocation(busDto.getRoute().getFromLocation());
        ///route.setToLocation(busDto.getRoute().getToLocation());
        // route.setFromDate(busDto.getRoute().getFromDate());
        // route.setToDate(busDto.getRoute().getToDate());
        //route.setTotalDuration(busDto.getRoute().getTotalDuration());
        // route.setFromTime(busDto.getRoute().getFromTime());
        // route.setToTime(busDto.getRoute().getToTime());

        // Route savedRoute = routeRepository.save(route);
        //Create Bus Entity
        Bus bus = new Bus();
        bus.setBusNumber(busDto.getBusNumber());
        bus.setBusType(busDto.getBusType());
        bus.setPrice(busDto.getPrice());
        bus.setTotalSeats(busDto.getTotalSeats());
        bus.setAvailableSeats(busDto.getAvailableSeats());
        //bus.setRoute(route);

        Bus savedBus = busRepository.save(bus);

        //Route routeUpdate = routeRepository.findById(savedRoute.getId()).get();
        //routeUpdate.setBus(savedBus);
        //routeRepository.save(routeUpdate);

        //create SubRoute Entity
        //if (busDto.getSubRoutes() != null && !busDto.getSubRoutes().isEmpty()) {
        //for (SubRouteDto subRouteDto : busDto.getSubRoutes()) {
        // SubRoute subRoute = new SubRoute();
        //subRoute.setFromLocation(subRouteDto.getFromLocation());
        //subRoute.setToLocation(subRouteDto.getToLocation());
        // subRoute.setFromDate(subRouteDto.getFromDate());
        //subRoute.setToDate(subRouteDto.getToDate());
        // subRoute.setTotalDuration(subRouteDto.getTotalDuration());
        //subRoute.setFromTime(subRouteDto.getFromTime());
        // subRoute.setToTime(subRouteDto.getToTime());

        // subRoute.setRoute(route);

        //subRouteRepository.save(subRoute);
        // }
        return savedBus;
    }

}
//}
//SubRouteDto subRouteDto : busDto.getSubRoutes()