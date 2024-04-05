package com.BusReservationApp.Service;

import com.BusReservationApp.Entity.UserRegistration;
import com.BusReservationApp.Payload.UserRegistrationDto;
import com.BusReservationApp.Repository.UserRegistrationRepository;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.stereotype.Service;


@Service
public class UserServiceImpl  {
    @Autowired
    private UserRegistrationRepository userRegistrationRepository;

   //post
    public UserRegistrationDto createUser(UserRegistration userRegistration){
        userRegistrationRepository.save(userRegistration);
        return null ;
    }
   //get
    public UserRegistration getUserById(long id){
        return userRegistrationRepository.findById(id).get();
    }
   //delete
    public void deleteUser(long id) {
         userRegistrationRepository.deleteById(id);
    }
}
