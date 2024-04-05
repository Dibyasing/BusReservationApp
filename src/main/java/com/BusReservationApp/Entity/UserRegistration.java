package com.BusReservationApp.Entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;
//user_registration
@Data
@Entity
@Table(name="user_registration")
@AllArgsConstructor
@NoArgsConstructor
public class UserRegistration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String username;
    private String email;
    private String password;
    @Lob
    @Column(name="profile_picture",length =1024)
    private byte[] profilePicture;


    }

