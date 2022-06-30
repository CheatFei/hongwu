package com.hw.dm.exception;

import com.hw.dm.domain.enums.errcode.ErrCode;

/**
 * @author Administrator
 */
public class ZeroException extends RuntimeException {

    private ErrCode<?> errCode;
    private Object[] args;

    private ZeroException() {
    }

    public ZeroException(ErrCode<?> errCode) {
        this.errCode = errCode;
    }

    public ZeroException withArgs(Object... args) {
        if (args != null) {
            this.args = args;
        }
        return this;
    }
    public ErrCode<?> getErrCode() {
        return errCode;
    }
    public Object[] getArgs() {
        return args;
    }
}
