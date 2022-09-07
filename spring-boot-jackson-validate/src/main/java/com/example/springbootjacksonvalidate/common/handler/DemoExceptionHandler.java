package com.example.springbootjacksonvalidate.common.handler;

import com.example.springbootjacksonvalidate.common.constant.Status;
import com.example.springbootjacksonvalidate.common.exception.JsonException;
import com.example.springbootjacksonvalidate.common.model.ApiResponse;
import com.example.springbootjacksonvalidate.common.model.JsonFormatVaild;
import com.fasterxml.jackson.databind.JsonMappingException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Field;
import java.util.List;

/**
 *
 * @Description: 同意异常处理
 * @author: panyi
 * @date Created in 2022/8/26 13:46
 */
@ControllerAdvice(value = {"com.example.springbootjacksonvalidate.controller"})
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
    public ApiResponse jsonErrorHandler(JsonException jsonException) {
        log.error("【JsonException: {}】", jsonException.getMessage());
        return ApiResponse.ofException(jsonException);
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ApiResponse controllerException(Exception e) {
        log.error("【Exception:{}】", e.getMessage());
        String erroMessage = null;
        Throwable cause = e.getCause();
        if (cause instanceof JsonMappingException) {
            List<JsonMappingException.Reference> list = ((JsonMappingException) cause).getPath();
            for (JsonMappingException.Reference r : list) {
                Object object = r.getFrom();
                Class<?> c = object.getClass();
                String fieldName = r.getFieldName();
                Field field;
                try {
                    field = c.getDeclaredField(fieldName);
                    JsonFormatVaild jsonFormatVaild = field.getDeclaredAnnotation(JsonFormatVaild.class);
                    erroMessage = jsonFormatVaild.message();
                } catch (NoSuchFieldException noSuchFieldException) {
                    noSuchFieldException.printStackTrace();
                }
                if (erroMessage != null) {
                    break;
                }
            }
        }
        log.error("【erroMessage:{}】",erroMessage);
        return ApiResponse.ofFail(erroMessage);
    }
}