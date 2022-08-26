package com.example.springbootmybatisplus.common.model;

import com.example.springbootmybatisplus.common.constant.Status;
import com.example.springbootmybatisplus.common.exception.BaseException;
import lombok.Data;

/**
 *
 * @Description: 通用的 API 接口返回封装
 * @author: panyi
 * @date Created in 2022/8/26 11:36
 */
@Data
public class ApiResponse {

    private Integer code;

    private String  message;

    private Object  data;

    private ApiResponse () {}

    /**
     *
     * @Description: 全参构造函数
     *
     * @param code       状态码
     * @param message    返回消息
     * @param data       内容数据
     */
    public ApiResponse(Integer code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }


    /**
     *
     * @Description: 构造一个自定义的API返回
     *
     * @param code       状态码
     * @param message    返回消息
     * @param data       内容数据
     */
    public static ApiResponse of (Integer code, String message, Object data) {
        return new ApiResponse(code, message, data);
    }


    /**
     *
     * @Description: 构造一个成狗且带有数据的API返回
     *
     * @param  data         返回的内容数据
     * @return ApiResponse
     */
    public static ApiResponse ofSuccess(Object data) {
        return ofStatus(Status.OK, data);
    }



    /**
     *
     * @Description: 构造一个成功且自定义消息的API返回
     *
     * @param message 返回内容
     * @return ApiResponse
     */
    public static ApiResponse ofMessage(String message) {
        return of(Status.OK.getCode(), message, null);
    }



    /**
     *
     * @Description:
     * 构造一个带状态但是不带有数据的返回
     * @param status
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(Status status) {
        return ofStatus(status, null);
    }

    /**
     * 构造一个有状态且带数据的API返回
     *
     * @param status 状态 {@link Status}
     * @param data   返回数据
     * @return ApiResponse
     */
    public static ApiResponse ofStatus(Status status, Object data) {
        return new ApiResponse(status.getCode(), status.getMessage(), data);
    }

    /**
     * 构造一个异常且带数据的API返回
     *
     * @param t    异常
     * @param data 返回数据
     * @param <T>  {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> ApiResponse ofException(T t, Object data) {
        return of(t.getCode(), t.getMessage(), data);
    }

    /**
     * 构造一个异常且不带数据的API返回
     *
     * @param t   异常
     * @param <T> {@link BaseException} 的子类
     * @return ApiResponse
     */
    public static <T extends BaseException> ApiResponse ofException(T t) {
        return ofException(t, null);
    }

}
