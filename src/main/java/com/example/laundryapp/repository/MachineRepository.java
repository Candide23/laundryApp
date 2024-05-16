package com.example.laundryapp.repository;

import com.example.laundryapp.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MachineRepository extends JpaRepository<Machine, Long> {
}
