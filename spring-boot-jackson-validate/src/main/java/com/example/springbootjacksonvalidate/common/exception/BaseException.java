package com.example.springbootjacksonvalidate.common.exception;

import com.example.springbootjacksonvalidate.common.constant.Status;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 *
 * @Description: 异常基类
 * @author: panyi
 * @date Created in 2022/8/26 11:29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BaseException extends RuntimeException{

    private Integer code;
    private String  message;

    public BaseException (Status status) {
        super(status.getMessage());
        this.code    = status.getCode();
        this.message = status.getMessage();
    }

    public BaseException (Integer code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }

}
