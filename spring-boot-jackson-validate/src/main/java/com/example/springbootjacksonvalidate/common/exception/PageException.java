package com.example.springbootjacksonvalidate.common.exception;


import com.example.springbootjacksonvalidate.common.constant.Status;
import lombok.Getter;

/**
 *
 * @Description:
 * @author: panyi
 * @date Created in 2022/8/26 11:35
 */
@Getter
public class PageException extends BaseException{
    public PageException(Status status) {
        super(status);
    }

    public PageException(Integer code, String message) {
        super(code, message);
    }
}
