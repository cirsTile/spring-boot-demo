package com.example.springbootmybatisplus.common.constant;


import lombok.Data;
import lombok.Getter;

/**
 *
 * @Description:
 * @author: panyi
 * @date Created in 2022/8/26 11:21
 */
@Getter
public enum Status {

    /**
     * 操作成功
     */
    OK(200, "操作成功"),

    /**
     * 操作失败
     */
    UNKNOWN_ERROR(500, "服务出错啦");

    /**
     *  状态码
     */
    private Integer code;

    /**
     *  内容
     */
    private String message;

    Status(Integer code, String message) {
        this.code = code;
        this.message = message;
    }


}
