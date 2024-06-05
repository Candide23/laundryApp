package com.example.laundryapp.mapper;

import com.example.laundryapp.dto.ReservationDto;
import com.example.laundryapp.entity.Machine;
import com.example.laundryapp.entity.Reservation;
import com.example.laundryapp.entity.User;

public class ReservationMapper {
    public static Reservation mapToReservation(ReservationDto reservationDto, Machine machine, User user) {
        Reservation reservation = new Reservation();
        reservation.setCode(reservationDto.getCode());
        reservation.setStartTime(reservationDto.getStartTime());
        reservation.setEndTime(reservationDto.getEndTime());
        reservation.setMachine(machine);
        reservation.setUser(user);
        return reservation;
    }

    public static ReservationDto mapToReservationDto(Reservation reservation) {
        ReservationDto reservationDto = new ReservationDto();
        reservationDto.setId(reservation.getId());
        reservationDto.setCode(reservation.getCode());
        reservationDto.setStartTime(reservation.getStartTime());
        reservationDto.setEndTime(reservation.getEndTime());
        reservationDto.setMachineId(reservation.getMachine().getId());
        reservationDto.setUserId(reservation.getUser().getId());
        return reservationDto;
    }
}
