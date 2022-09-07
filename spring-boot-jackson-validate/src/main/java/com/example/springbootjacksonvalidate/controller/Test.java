package com.example.springbootjacksonvalidate.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.springbootjacksonvalidate.common.model.ApiResponse;
import com.example.springbootjacksonvalidate.dto.Student;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.temporal.ChronoField;

/**
 * @author panyi
 * @ClassName Test.java
 * @Description TODO
 * @date Created in 2022/9/7 22:08
 */
@RestController
@RequestMapping("/demo")
@Slf4j
public class Test {

    @PostMapping("/test")
    @ResponseBody
    public ApiResponse test(@RequestBody @Valid Student student) {
//        Integer day = student.getBirthDay().getYear() * 10000 + student.getBirthDay().getMonthValue() * 100 + student.getBirthDay().getDayOfMonth();
        log.info("LocalDate is {}", JSONObject.toJSONString(student));
        return ApiResponse.ofSuccess(null);
    }

}
