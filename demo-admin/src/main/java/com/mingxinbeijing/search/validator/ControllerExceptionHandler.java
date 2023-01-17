 package com.mingxinbeijing.search.validator;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mingxinbeijing.common.api.CommonResult;
import com.mingxinbeijing.common.api.ResultCode;

/**
 * 参数校验接口 Spring API
 * @author jiangzhiwei
 * @date 2022/12/14
 */
public class ControllerExceptionHandler {
	    @ResponseBody
	    @ExceptionHandler(MethodArgumentNotValidException.class)
	    public CommonResult<Integer> handle(MethodArgumentNotValidException e) {
	        FieldError fieldError = e.getBindingResult().getFieldError();
	        return CommonResult.failed(ResultCode.VALIDATE_FAILED, fieldError.getDefaultMessage());
	       
	    }

}
