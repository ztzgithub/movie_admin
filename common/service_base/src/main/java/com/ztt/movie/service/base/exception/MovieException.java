package com.ztt.movie.service.base.exception;

import com.ztt.movie.common.base.result.ResultCodeEnum;
import lombok.Data;

@Data
public class MovieException extends RuntimeException {

    //状态码
    private Integer code;

    /**
     * 接受状态码和消息
     * @param code
     * @param message
     */
    public MovieException(Integer code, String message) {
        super(message);
        this.code=code;
    }

    /**
     * 接收枚举类型
     * @param resultCodeEnum
     */
    public MovieException(ResultCodeEnum resultCodeEnum) {
        super(resultCodeEnum.getMessage());
        this.code = resultCodeEnum.getCode();
    }

    @Override
    public String toString() {
        return "MovieException{" +
                "code=" + code +
                ", message=" + this.getMessage() +
                '}';
    }
}