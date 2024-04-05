package com.BusReservationApp.Controller;

import com.BusReservationApp.Entity.Bus;
import com.BusReservationApp.Entity.Route;
import com.BusReservationApp.Entity.SubRoute;
import com.BusReservationApp.Payload.BusDto;
import com.BusReservationApp.Payload.SearchListOfBusesDto;
import com.BusReservationApp.Repository.BusRepository;
import com.BusReservationApp.Repository.RouteRepository;
import com.BusReservationApp.Repository.SubRouteRepository;
import com.BusReservationApp.Service.BusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/bus")
public class BusController {
    @Autowired
    private BusService busService;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private SubRouteRepository subRouteRepository;
    @Autowired
    private BusRepository busRepository;

    //http://localhost:8080/api/v1/bus/add
    @PostMapping("/add")
    public ResponseEntity<Bus> addBus(@RequestBody BusDto busDto) {
        Bus bus = busService.addBus(busDto);
        return new ResponseEntity<>(bus, HttpStatus.CREATED);
    }

    //https://localhost:8080/api/v1/bus/add?fromLocation=&toLocation=&fromDate
    @GetMapping
    public List<SearchListOfBusesDto> getAllBuses(@RequestParam String fromLocation,
                                 @RequestParam String toLocation,
                                 @RequestParam String fromDate) {
        List<Route> routes = routeRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);
        List<SubRoute> subRoutes = subRouteRepository.findByFromLocationAndToLocationAndFromDate(fromLocation, toLocation, fromDate);

        List<SearchListOfBusesDto>buses = new ArrayList<>();
        if (routes!=null) {
            for (Route route : routes) {
                Bus bus = busRepository.findById(route.getBusId()).get();
                SearchListOfBusesDto searchListOfBusesDto = mapToSearchListOfBusesDto(bus, route);
                buses.add(searchListOfBusesDto);
            }
            return buses;
        }

        if (subRoutes!=null) {
            for (SubRoute route : subRoutes) {
                Bus bus = busRepository.findById(route.getBusId()).get();
                SearchListOfBusesDto searchListOfBusesDto = mapToSearchListOfBusesDto(bus, route);
                buses.add(searchListOfBusesDto);
            }
            return buses;
        }
        return null;
    }
  SearchListOfBusesDto mapToSearchListOfBusesDto(Bus bus , Route route){
      SearchListOfBusesDto searchListOfBusesDto = new SearchListOfBusesDto();
      searchListOfBusesDto.setBusId(bus.getBusId());
      searchListOfBusesDto.setBusNumber(bus.getBusNumber());
      searchListOfBusesDto.setPrice(bus.getPrice());
      searchListOfBusesDto.setBusType(bus.getBusType());
      searchListOfBusesDto.setTotalSeats(bus.getTotalSeats());
      searchListOfBusesDto.setAvailableSeats(bus.getAvailableSeats());
      searchListOfBusesDto.setFromLocation(route.getFromLocation());
      searchListOfBusesDto.setToLocation(route.getToLocation());
      searchListOfBusesDto.setFromDate(route.getFromDate());
      searchListOfBusesDto.setToDate(route.getToDate());
      searchListOfBusesDto.setRouteId(route.getId());
      searchListOfBusesDto.setTotalDuration(route.getTotalDuration());
      searchListOfBusesDto.setFromTime(route.getFromTime());
      searchListOfBusesDto.setToTime(route.getToTime());
      return searchListOfBusesDto;
  }
    SearchListOfBusesDto mapToSearchListOfBusesDto(Bus bus , SubRoute route){
        SearchListOfBusesDto searchListOfBusesDto = new SearchListOfBusesDto();
        searchListOfBusesDto.setBusId(bus.getBusId());
        searchListOfBusesDto.setBusNumber(bus.getBusNumber());
        searchListOfBusesDto.setPrice(bus.getPrice());
        searchListOfBusesDto.setBusType(bus.getBusType());
        searchListOfBusesDto.setTotalSeats(bus.getTotalSeats());
        searchListOfBusesDto.setAvailableSeats(bus.getAvailableSeats());
        searchListOfBusesDto.setFromLocation(route.getFromLocation());
        searchListOfBusesDto.setToLocation(route.getToLocation());
        searchListOfBusesDto.setFromDate(route.getFromDate());
        searchListOfBusesDto.setToDate(route.getToDate());
        searchListOfBusesDto.setRouteId(route.getId());
        searchListOfBusesDto.setTotalDuration(route.getTotalDuration());
        searchListOfBusesDto.setFromTime(route.getFromTime());
        searchListOfBusesDto.setToTime(route.getToTime());
        return searchListOfBusesDto;
    }
}