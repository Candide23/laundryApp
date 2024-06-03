package com.example.laundryapp.service;

import com.example.laundryapp.dto.MachineDto;

import java.util.List;

public interface MachineService {

    MachineDto createMachine(MachineDto machineDto);
    MachineDto getMachineById(Long machineId);
    List<MachineDto> getAllMachines();
    MachineDto updateMachines(Long machineId, MachineDto updatedMachineDto);
    void deletedMachine(Long machineId);

    List<MachineDto> getMachinesByAddress(Long addressId);
}
