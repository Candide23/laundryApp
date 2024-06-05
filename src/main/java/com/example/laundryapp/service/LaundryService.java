package com.example.laundryapp.service;

import com.example.laundryapp.dto.AddressDto;
import com.example.laundryapp.dto.MachineDto;
import com.example.laundryapp.dto.ReservationDto;
import com.example.laundryapp.dto.UserDto;
import com.example.laundryapp.entity.Address;
import com.example.laundryapp.entity.Machine;
import com.example.laundryapp.entity.Reservation;
import com.example.laundryapp.entity.User;
import com.example.laundryapp.mapper.AddressMapper;
import com.example.laundryapp.mapper.MachineMapper;
import com.example.laundryapp.mapper.ReservationMapper;
import com.example.laundryapp.mapper.UserMapper;
import com.example.laundryapp.repository.AddressRepository;
import com.example.laundryapp.repository.MachineRepository;
import com.example.laundryapp.repository.ReservationRepository;
import com.example.laundryapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LaundryService {

    @Autowired
    private MachineRepository machineRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private UserRepository userRepository;

    public MachineDto createMachine(MachineDto machineDto) {
        AddressDto addressDto = machineDto.getAddress();
        Address address = AddressMapper.mapToAddress(addressDto);

        // Check if the address exists, if not create it
        if (address.getId() == null || !addressRepository.existsById(address.getId())) {
            address = addressRepository.save(address);
        } else {
            // Fetch the existing address from the database
            address = addressRepository.findById(address.getId()).orElseThrow(() -> new RuntimeException("Address not found"));
        }

        Machine machine = MachineMapper.mapToMachine(machineDto, address);
        Machine savedMachine = machineRepository.save(machine);
        return MachineMapper.mapToMachineDto(savedMachine);
    }

    public ReservationDto createReservation(ReservationDto reservationDto) {
        Optional<Machine> machineOpt = machineRepository.findById(reservationDto.getMachineId());
        Optional<User> userOpt = userRepository.findById(reservationDto.getUserId());
        if (machineOpt.isPresent() && userOpt.isPresent()) {
            Machine machine = machineOpt.get();
            User user = userOpt.get();
            Reservation reservation = ReservationMapper.mapToReservation(reservationDto, machine, user);
            Reservation savedReservation = reservationRepository.save(reservation);
            return ReservationMapper.mapToReservationDto(savedReservation);
        } else {
            throw new RuntimeException("Machine or User not found");
        }
    }

    public UserDto createUser(UserDto userDto) {
        User user = UserMapper.mapToUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapToUserDto(savedUser);
    }


    // Other service methods...
}
