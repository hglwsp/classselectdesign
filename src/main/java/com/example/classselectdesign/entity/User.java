package com.example.classselectdesign.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class User {
    public static final int Mannager_AUTHORITY = 0;            /*权限*/
    public static final int Teacher_AUTHORITY = 1;             /*判断是管理员，学生还是教师*/
    public static final int Student_AUTHORITY = 2;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String number;           /*编号：学号，教师号等等*/
    private String name;
    private String collage;          /*学院*/
    private String clazz;            /*课程,学生选课，老师任课*/
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;
    // 在没有声明时默认为2，学生
    private int authority = 2;
    @Column(columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP",
            updatable = false,
            insertable = false)
    private LocalDateTime insertTime;
    private int state;      /*0未分配，1已分配，2已完成*/

    public User(int id) {
        this.id = id;
    }

    public User(String name) {
        this.name = name;
    }


}