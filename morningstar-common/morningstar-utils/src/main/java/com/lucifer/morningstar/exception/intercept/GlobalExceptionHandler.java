package com.lucifer.morningstar.exception.intercept;

import com.lucifer.morningstar.base.R;
import com.lucifer.morningstar.constant.ErrorEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

/**
 * author: lucifer
 * date: 2020/5/16 15:34
 * description: 全局异常处理器
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleValidException(MethodArgumentNotValidException e) {
        log.error("数据校验出错:{},异常类型:{}", e.getMessage(), e.getClass());
        BindingResult bindingResult = e.getBindingResult();

        Map<String, String> errorMap = new HashMap<>();
        bindingResult.getFieldErrors().forEach((fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        }));
        return R.error(ErrorEnum.VALIDATED_EXCEPTION.getCode(), ErrorEnum.VALIDATED_EXCEPTION.getMsg());
    }

    @ExceptionHandler(value = Throwable.class)
    public R handleException(Throwable e) {
        log.error("异常内容:{},异常类型:{}", e.getMessage(), e.getClass());
        return R.error(ErrorEnum.UNKNOWN_EXCEPTION.getCode(), ErrorEnum.UNKNOWN_EXCEPTION.getMsg());
    }

}





























