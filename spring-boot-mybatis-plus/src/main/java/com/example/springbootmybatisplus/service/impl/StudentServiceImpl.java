package com.example.springbootmybatisplus.service.impl;

import com.example.springbootmybatisplus.entity.Student;
import com.example.springbootmybatisplus.mapper.StudentMapper;
import com.example.springbootmybatisplus.service.StudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import lombok.extern.slf4j.Slf4j;


/**
* <p>
    *  服务实现类
    * </p>
*
* @author PanYi
* @since 2022-08-07
*/
@Slf4j
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {

}
