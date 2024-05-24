package com.example.laundryapp.mapper;

import com.example.laundryapp.dto.MachineDto;
import com.example.laundryapp.dto.UserDto;
import com.example.laundryapp.entity.Machine;
import com.example.laundryapp.entity.User;

public class MachineMapper {

    public static MachineDto mapToMachineDto(Machine machine) {

        return new MachineDto(
                machine.getId(),
                machine.getType(),
                machine.getStatus()

        );
    }

    public static Machine mapToMachine(MachineDto machineDto) {

        return new Machine(
                machineDto.getId(),
                machineDto.getType(),
                machineDto.getStatus()
        );
    }
}
