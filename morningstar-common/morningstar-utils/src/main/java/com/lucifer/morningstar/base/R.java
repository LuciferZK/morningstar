package com.lucifer.morningstar.base;

import com.lucifer.morningstar.constant.ErrorEnum;

import java.util.HashMap;
import java.util.Map;

/**
 * author: lucifer
 * date: 2020/5/16 15:14
 * description: 对返回结果的统一封装
 */
public class R extends HashMap<String, Object> {

    public R() {
        put("code", 0);
        put("msg", "success");
    }

    public static R error() {
        return error(ErrorEnum.UNKNOWN_EXCEPTION.getCode(), ErrorEnum.UNKNOWN_EXCEPTION.getMsg());
    }

    public static R error(String msg) {
        return error(ErrorEnum.UNKNOWN_EXCEPTION.getCode(), msg);
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }

    public static R ok(String msg) {
        R r = new R();
        r.put("msg", msg);
        return r;
    }

    public static R ok(Map<String, Object> map) {
        R r = new R();
        r.putAll(map);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

}
