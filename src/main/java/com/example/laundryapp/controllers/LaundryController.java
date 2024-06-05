package com.example.laundryapp.controllers;


import com.example.laundryapp.dto.MachineDto;
import com.example.laundryapp.dto.ReservationDto;
import com.example.laundryapp.dto.UserDto;
import com.example.laundryapp.service.LaundryService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("http://localhost:3000")
@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class LaundryController {

    @Autowired
    private LaundryService laundryService;



    @PostMapping("/machines")
    public MachineDto createMachine(@RequestBody MachineDto machineDto) {
        return laundryService.createMachine(machineDto);
    }

    @PostMapping("/reservations")
    public ReservationDto createReservation(@RequestBody ReservationDto reservationDto) {
        return laundryService.createReservation(reservationDto);
    }

    @PostMapping("/users")
    public UserDto createUser(@RequestBody UserDto userDto) {
        return laundryService.createUser(userDto);
    }


}
