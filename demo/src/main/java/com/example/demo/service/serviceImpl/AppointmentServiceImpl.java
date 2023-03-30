package com.example.demo.service.serviceImpl;

import com.example.demo.entity.Appointment;
import com.example.demo.mapper.AppointmentMapper;
import com.example.demo.service.AppointmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class AppointmentServiceImpl implements AppointmentService {
    @Resource
    private AppointmentMapper appointmentMapper;
    @Override
    public Appointment registService(Appointment appointment) {
        if (appointment.getUser_id() == null || appointment.getReal_name() == null
        || appointment.getId_card() == null || appointment.getApt_time() == null || appointment.getSet_type() == null
        || appointment.getSet_option() == null){
            return appointment;
        }else{
         Appointment newAppoint = appointment;
         if (appointmentMapper.addAppointment(newAppoint) == 1){
             newAppoint.setReal_name("");
             newAppoint.setId_card("");
         }
         return newAppoint;
        }
    }
}
