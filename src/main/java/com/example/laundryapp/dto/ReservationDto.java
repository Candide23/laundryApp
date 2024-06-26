package com.example.laundryapp.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReservationDto {

    private Long id;
    private Long machineId;
    private Long userId;
    private String code;
    private Date startTime;
    private Date endTime;
}
