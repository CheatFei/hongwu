package com.hw.dm.domain.enums.errcode;

public enum  ZeroErr implements ErrCode {


    ZERO_ERR_001(-10001, "初始错误"),
            ;

    private final Integer code;
    private final String desc;

    ZeroErr(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    @Override
    public Object getCode() {
        return null;
    }

    @Override
    public String getDesc() {
        return null;
    }
}
