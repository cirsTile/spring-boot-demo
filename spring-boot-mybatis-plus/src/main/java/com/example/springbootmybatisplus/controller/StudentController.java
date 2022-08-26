package com.example.springbootmybatisplus.controller;


import com.example.springbootmybatisplus.common.constant.Status;
import com.example.springbootmybatisplus.common.exception.JsonException;
import com.example.springbootmybatisplus.common.model.ApiResponse;
import org.springframework.web.bind.annotation.*;
import com.example.springbootmybatisplus.service.StudentService;
import org.springframework.web.bind.annotation.RestController;


/**
* <p>
*  前端控制器
* </p>
*
* @author PanYi
* @since 2022-08-26
* @version v1.0
*/
@RestController
@RequestMapping("/demo")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/json")
    public ApiResponse jsonException() {
        throw new JsonException(Status.UNKNOWN_ERROR);
    }

    @PostMapping("/test")
    public ApiResponse success() {
        return ApiResponse.ofMessage("成功");
    }

    @PostMapping("/list")
    public ApiResponse searchStudentForList() {
        return ApiResponse.ofSuccess(studentService.searchStudent());
    }

}
