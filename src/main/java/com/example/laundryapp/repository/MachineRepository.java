package com.example.laundryapp.repository;

import com.example.laundryapp.entity.Machine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface MachineRepository extends JpaRepository<Machine, Long> {
    List<Machine> findByAddress(String address);

}
