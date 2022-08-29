package com.example.springbootredis.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

/**
 * @description: 学生实体
 * @author: panyi
 * @date Created in 2022/08/29
 **/
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键id
     */
    private Long id;

    private String studentNumber;

    private String name;

    /**
     * 学生年龄
     */
    private Integer studentAge;
}
