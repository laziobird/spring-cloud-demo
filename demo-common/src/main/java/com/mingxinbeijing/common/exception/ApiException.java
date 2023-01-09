package com.mingxinbeijing.common.exception;

import com.mingxinbeijing.common.api.IErrorCode;

/**
 * 
 * @author jiangzhiwei
 * @date 2023/01/09
 */
public class ApiException extends RuntimeException {
    private static final long serialVersionUID = -6166778046348921715L;
	private IErrorCode errorCode;

    public ApiException(IErrorCode errorCode) {
        super(errorCode.getMessage());
        this.errorCode = errorCode;
    }

    public ApiException(String message) {
        super(message);
    }

    public ApiException(Throwable cause) {
        super(cause);
    }

    public ApiException(String message, Throwable cause) {
        super(message, cause);
    }

    public IErrorCode getErrorCode() {
        return errorCode;
    }
}
