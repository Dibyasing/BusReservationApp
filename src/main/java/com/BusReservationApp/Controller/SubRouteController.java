package com.BusReservationApp.Controller;

import com.BusReservationApp.Entity.Route;
import com.BusReservationApp.Entity.SubRoute;
import com.BusReservationApp.Service.SubRouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/subRoute")
public class SubRouteController {
    @Autowired
    private SubRouteService subRouteService;
    @PostMapping("/{busId}")
    public ResponseEntity<SubRoute> addRoute(@PathVariable long busId , @RequestBody SubRoute subRoute){
        SubRoute subRoute1 = subRouteService.createSubRoute(busId, subRoute);
        return new ResponseEntity<>(subRoute1, HttpStatus.CREATED);
    }
}
