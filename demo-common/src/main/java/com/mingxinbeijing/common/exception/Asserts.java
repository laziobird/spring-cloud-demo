package com.mingxinbeijing.common.exception;

import com.mingxinbeijing.common.api.IErrorCode;

/**
 * 
 * @author jiangzhiwei
 * @date 2023/01/09
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}
