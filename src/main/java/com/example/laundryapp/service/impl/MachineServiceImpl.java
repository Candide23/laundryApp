package com.example.laundryapp.service.impl;

import com.example.laundryapp.dto.AddressDto;
import com.example.laundryapp.dto.MachineDto;
import com.example.laundryapp.entity.Address;
import com.example.laundryapp.entity.Machine;
import com.example.laundryapp.exception.ResourceNotFoundException;
import com.example.laundryapp.mapper.AddressMapper;
import com.example.laundryapp.mapper.MachineMapper;
import com.example.laundryapp.repository.AddressRepository;
import com.example.laundryapp.repository.MachineRepository;
import com.example.laundryapp.repository.ReservationRepository;
import com.example.laundryapp.service.MachineService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MachineServiceImpl implements MachineService {

    @Autowired
    private MachineRepository machineRepository;

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private AddressRepository addressRepository;


    @Override
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

        Machine machine = MachineMapper.mapToMachine(machineDto);
        machine.setAddress(address);
        Machine savedMachine = machineRepository.save(machine);
        return MachineMapper.mapToMachineDto(savedMachine);
    }

    @Override
    public MachineDto getMachineById(Long machineId) {

        Machine machine = machineRepository.findById(machineId).orElseThrow(
                () -> new ResourceNotFoundException("Machine is not exists with a given id: "  + machineId)
        );
        return MachineMapper.mapToMachineDto(machine);
    }

    @Override
    public List<MachineDto> getAllMachines() {

        List<Machine> machines = machineRepository.findAll();
        return machines.stream().map((machine -> MachineMapper.mapToMachineDto(machine)))
                .collect(Collectors.toList());
    }

    @Override
    public MachineDto updateMachines(Long machineId, MachineDto updatedMachineDto) {

        Machine machine = machineRepository.findById(machineId).orElseThrow(
                () -> new ResourceNotFoundException("Machine is not exists with given id: " + machineId)
        );

        machine.setType(updatedMachineDto.getType());
        machine.setStatus(updatedMachineDto.getStatus());

        Machine updateMachineObj = machineRepository.save(machine);

        return  MachineMapper.mapToMachineDto(updateMachineObj);
    }

    @Override
    public void deletedMachine(Long machineId) {

        Machine machine = machineRepository.findById(machineId).orElseThrow(
                () -> new ResourceNotFoundException("Machine is not exists with given id: " + machineId)
        );

        machineRepository.deleteById(machineId);

    }

    @Override
    public List<MachineDto> getMachinesByAddress(Long addressId) {
        return machineRepository.findByAddress_Id(addressId);

    }


}
