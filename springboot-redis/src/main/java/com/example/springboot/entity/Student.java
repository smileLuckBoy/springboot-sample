package com.example.springboot.entity;

import lombok.*;

@ToString
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private Integer id;

    private String name;

    private Integer age;

    private Integer sex;

    private String idCard;

}