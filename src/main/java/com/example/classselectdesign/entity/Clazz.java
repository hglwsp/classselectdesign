package com.example.classselectdesign.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Clazz {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;        //课程名
    private String number;      //课程号
    private String collage;      //学院
    @ManyToOne(fetch = FetchType.LAZY)
    private User teacher;


    public Clazz(int id) {
        this.id = id;
    }

    public Clazz(String name) {
        this.name = name;
    }


}