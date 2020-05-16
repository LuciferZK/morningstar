package com.lucifer.morningstar.constant;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * author: lucifer
 * date: 2020/5/16 15:14
 * description: 异常枚举类
 */
@AllArgsConstructor
@Getter
public enum ErrorEnum {

    UNKNOWN_EXCEPTION(00000, "未知异常,请联系管理员"),
    VALIDATED_EXCEPTION(10001,"数据校验异常");

    private Integer code;

    private String msg;
}
