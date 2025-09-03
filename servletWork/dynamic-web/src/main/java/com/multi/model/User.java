package com.multi.model;

import lombok.*;

import javax.servlet.annotation.WebServlet;

// model, domain, vo, dto
@Data //getter, setter, toString
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private int id;
    private String name;
    private int age;
}

