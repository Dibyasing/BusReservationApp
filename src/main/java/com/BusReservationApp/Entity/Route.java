package com.BusReservationApp.Entity;

import com.BusReservationApp.Payload.SubRouteDto;
import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Route {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fromLocation;
    private String toLocation;
    private String fromDate;
    private String toDate;
    private String totalDuration;
    private String fromTime;
    private String toTime;
    @Column(name="bus_id",unique=true,nullable = false)
    private long busId;

    //@OneToOne(fetch = FetchType.LAZY)
   // @JoinColumn(name="bus_id",referencedColumnName = "busId")
    //private Bus bus;

    //@OneToMany(mappedBy="route", fetch = FetchType.LAZY)
    //private List<SubRoute> subRoutes;
}
