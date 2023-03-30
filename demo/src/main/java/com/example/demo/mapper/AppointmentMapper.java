package com.example.demo.mapper;

import com.example.demo.entity.Appointment;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AppointmentMapper {
    int addAppointment(Appointment appointment);
}
