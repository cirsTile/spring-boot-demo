package com.example.springbootmybatisplus.service;

import com.example.springbootmybatisplus.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;


/**
* <p>
*  服务类
* </p>
*
* @author PanYi
* @since 2022-08-26
*/
public interface StudentService {

    List<Student> searchStudent();

}
