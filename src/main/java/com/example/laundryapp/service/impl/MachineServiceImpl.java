package com.example.laundryapp.service.impl;

import com.example.laundryapp.dto.MachineDto;
import com.example.laundryapp.entity.Machine;
import com.example.laundryapp.mapper.MachineMapper;
import com.example.laundryapp.repository.MachineRepository;
import com.example.laundryapp.service.MachineService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class MachineServiceImpl implements MachineService {

    private MachineRepository machineRepository;


    @Override
    public MachineDto createMachine(MachineDto machineDto) {
        Machine machine = MachineMapper.mapToMachine(machineDto);
        Machine saveMachine = machineRepository.save(machine);

        return MachineMapper.mapToMachineDto(saveMachine);
    }
}
