package com.BusReservationApp.Entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "bus")
@AllArgsConstructor
@NoArgsConstructor
@Data
@JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long busId;

    @Column(name = "bus_number" , unique = true)
    private String busNumber;
    private String busType;
    private String price;
    private int totalSeats;
    private int availableSeats;

    //@OneToOne(mappedBy = "bus",fetch = FetchType.EAGER)
    //private Route route;

}
