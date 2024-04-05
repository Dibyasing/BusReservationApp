package com.BusReservationApp.Controller;

import com.BusReservationApp.Entity.Bus;
import com.BusReservationApp.Entity.Passenger;
import com.BusReservationApp.Entity.Route;
import com.BusReservationApp.Entity.SubRoute;
import com.BusReservationApp.Repository.BusRepository;
import com.BusReservationApp.Repository.PassengerRepository;
import com.BusReservationApp.Repository.RouteRepository;
import com.BusReservationApp.Repository.SubRouteRepository;
import com.BusReservationApp.Util.EmailService;
import com.BusReservationApp.Util.PdfTickectGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/reservation")
public class ReservationController {
    @Autowired
    private PassengerRepository passengerRepository;
    @Autowired
    private BusRepository busRepository;
    @Autowired
    private RouteRepository routeRepository;
    @Autowired
    private SubRouteRepository subRouteRepository;
    @Autowired
    private PdfTickectGeneratorService pdfTickectGeneratorService;
    @Autowired
    private EmailService emailService;


    //http://localhost:8080/api/reservation?busId=1&routeId=1
    @PostMapping
    public ResponseEntity<String> bookTicket(
            @RequestParam long busId,
            @RequestParam long routeId,
            @RequestBody Passenger passenger
    ) {
        boolean busIsPresent = false;//initially it is false
        boolean routeIsPresent = false;
        boolean subRouteIsPresent = false;
        Optional<Bus> byId = busRepository.findById(busId);

        if (byId.isPresent()) {
            busIsPresent = true;//Then it will be the true
            Bus bus = byId.get();
        }
        Optional<Route> byrouteId = routeRepository.findById(routeId);
        if (byrouteId.isPresent()) {
            routeIsPresent = true;
            Bus bus = byId.get();
        }
        Optional<SubRoute> bySubRouteId = subRouteRepository.findById(routeId);
        if (byrouteId.isPresent()) {
            subRouteIsPresent = true;
            Bus bus = byId.get();
        }
        if (busIsPresent && routeIsPresent || busIsPresent && subRouteIsPresent) {
            //add passenger details
            Passenger p = new Passenger();
            p.setFirstName(passenger.getFirstName());
            p.setLastName(passenger.getLastName());
            p.setEmail(passenger.getEmail());
            p.setMobile(passenger.getMobile());
            p.setRouteId(routeId);
            p.setBusId(busId);
            Passenger savedPassenger = passengerRepository.save(p);
            byte[] pdfBytes = pdfTickectGeneratorService.generateTicket(
                    savedPassenger,
                    byrouteId.get().getFromLocation(),
                    byrouteId.get().getToLocation(),
                    byrouteId.get().getFromDate()
            );
            emailService.sendEmailWithAttachment(
                    passenger.getEmail(),
                    pdfBytes,
                    "ticket",
                    "Booking Confirmed...",
                    "Your Reservation id" + savedPassenger.getId()
            );
        }
        return new ResponseEntity<>("Done...", HttpStatus.CREATED);
    }

}
