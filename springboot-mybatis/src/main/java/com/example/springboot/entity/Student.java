package com.example.springboot.entity;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
public class Student {
    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;

    private String idCard;

}