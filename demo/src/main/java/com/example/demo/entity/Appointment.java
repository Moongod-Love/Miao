package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;
import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Appointment {
    private Integer user_id;
    private Integer group_id;
    private String real_name;
    private String id_card;
    private String apt_time;
    private Integer set_type;
    private String set_option;

}
