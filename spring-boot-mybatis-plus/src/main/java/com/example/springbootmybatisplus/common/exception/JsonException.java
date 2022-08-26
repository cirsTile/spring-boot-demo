package com.example.springbootmybatisplus.common.exception;

import com.example.springbootmybatisplus.common.constant.Status;
import lombok.Getter;

/**
 *
 * @Description: JSON 异常
 * @author: panyi
 * @date Created in 2022/8/26 11:34
 */
@Getter
public class JsonException extends BaseException{

    public JsonException(Status status) {
        super(status);
    }

    public JsonException(Integer code, String message) {
        super(code, message);
    }
}
