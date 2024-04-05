package com.BusReservationApp.Payload;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BusDto {
    private long busId;
    private String busNumber;
    private String busType;
    private String price;
    private int totalSeats;
    private int availableSeats;
    //private RouteDto route;
    //private List<SubRouteDto>subRoutes;


}
