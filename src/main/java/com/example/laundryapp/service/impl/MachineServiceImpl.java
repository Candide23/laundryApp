package com.example.laundryapp.service.impl;

import com.example.laundryapp.dto.MachineDto;
import com.example.laundryapp.entity.Machine;
import com.example.laundryapp.exception.ResourceNotFoundException;
import com.example.laundryapp.mapper.MachineMapper;
import com.example.laundryapp.repository.MachineRepository;
import com.example.laundryapp.repository.ReservationRepository;
import com.example.laundryapp.service.MachineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class MachineServiceImpl implements MachineService {

    private MachineRepository machineRepository;

    private ReservationRepository reservationRepository;


    @Override
    public MachineDto createMachine(MachineDto machineDto) {
        Machine machine = MachineMapper.mapToMachine(machineDto);
        Machine saveMachine = machineRepository.save(machine);

        return MachineMapper.mapToMachineDto(saveMachine);
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
    public List<MachineDto> getMachinesByAddress(String address) {
        return machineRepository.findByAddress(address);
    }


}
