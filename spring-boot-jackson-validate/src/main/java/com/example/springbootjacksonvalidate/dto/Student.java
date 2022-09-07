package com.example.springbootjacksonvalidate.dto;

import com.example.springbootjacksonvalidate.common.model.JsonFormatVaild;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.Date;

/**
 * @author panyi
 * @ClassName Student.java
 * @Description 学生类
 * @date Created in 2022/9/7 22:09
 */
@Data
public class Student {

    private Integer studentNumber;

    @NotNull(message = "学生姓名不能为空")
    private String name;

    @JsonFormat(shape = JsonFormat.Shape.STRING,pattern = "yyyy-MM-dd")
    @JsonFormatVaild(message = "出生日期格式不符合：yyyy-MM-dd")
    private LocalDate birthDay;

    @JsonFormat(pattern = "yyyy-MM")
    @JsonFormatVaild(message = "入学日期格式不符合：yyyy-MM")
    private YearMonth admissionDate;

}
