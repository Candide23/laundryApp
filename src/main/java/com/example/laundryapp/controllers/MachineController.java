package com.example.laundryapp.controllers;


import com.example.laundryapp.dto.MachineDto;
import com.example.laundryapp.service.MachineService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/machine")
public class MachineController {

    private MachineService machineService;

    @PostMapping
    public ResponseEntity<MachineDto> createMachine(@RequestBody MachineDto machineDto) {

        MachineDto machine = machineService.createMachine(machineDto);

        return new ResponseEntity<>(machine, HttpStatus.CREATED);


    }

    @GetMapping("{id}")
    public ResponseEntity<MachineDto> getMachineById(@PathVariable("id") Long machineId){
        MachineDto machineDto= machineService.getMachineById(machineId);
        return ResponseEntity.ok(machineDto);
    }
}
