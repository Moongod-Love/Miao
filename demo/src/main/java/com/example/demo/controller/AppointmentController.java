package com.example.demo.controller;

import com.example.demo.entity.Appointment;
import com.example.demo.service.AppointmentService;
import com.example.demo.utils.Result;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/appointment")
public class AppointmentController {
    @Resource
    private AppointmentService appointmentService;
    @PostMapping("/register")
    public Result<Appointment> registController(@RequestBody Appointment appointment){
        Appointment newAppointment = appointmentService.registService(appointment);
        if (appointment.getUser_id() == null || appointment.getReal_name() == null
                || appointment.getId_card() == null || appointment.getApt_time() == null || appointment.getSet_type() == null
                || appointment.getSet_option() == null){
            return Result.error("-1", "请完成必要信息填写！");
        }else{
            return Result.success(newAppointment, "预约成功！");
        }
    }
}
