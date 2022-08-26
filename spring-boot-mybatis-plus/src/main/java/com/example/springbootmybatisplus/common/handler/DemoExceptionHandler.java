package com.example.springbootmybatisplus.common.handler;

import com.example.springbootmybatisplus.common.exception.JsonException;
import com.example.springbootmybatisplus.common.model.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @Description: 同意一场处理
 * @author: panyi
 * @date Created in 2022/8/26 13:46
 */
@ControllerAdvice
@Slf4j
public class DemoExceptionHandler {
    private static final String DEFAULT_ERROR_VIEW = "error";


    /**
     * 统一 json 异常处理
     *
     * @param jsonException JsonException
     * @return 统一返回 json 格式
     */
    @ExceptionHandler(value = JsonException.class)
    @ResponseBody
    public ApiResponse jsonErrorHandler (JsonException jsonException) {
        log.error("【JsonException: {}】", jsonException.getMessage());
        return ApiResponse.ofException(jsonException);
    }


}
