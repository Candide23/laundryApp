package com.example.laundryapp.mapper;

import com.example.laundryapp.dto.AddressDto;
import com.example.laundryapp.dto.MachineDto;
import com.example.laundryapp.dto.UserDto;
import com.example.laundryapp.entity.Address;
import com.example.laundryapp.entity.Machine;
import com.example.laundryapp.entity.User;

public class MachineMapper {

    public static Machine mapToMachine(MachineDto machineDto) {
        Machine machine = new Machine();
        machine.setId(machineDto.getId());
        machine.setType(machineDto.getType());
        machine.setStatus(machineDto.getStatus());
        machine.setAddress(AddressMapper.mapToAddress(machineDto.getAddress()));
        machine.setTimeRemaining(machineDto.getTimeRemaining());
        return machine;
    }

    public static MachineDto mapToMachineDto(Machine machine) {
        MachineDto machineDto = new MachineDto();
        machineDto.setId(machine.getId());
        machineDto.setType(machine.getType());
        machineDto.setStatus(machine.getStatus());
        machineDto.setAddress(AddressMapper.mapToAddressDto(machine.getAddress()));
        machineDto.setTimeRemaining(machine.getTimeRemaining());
        return machineDto;
    }


}
