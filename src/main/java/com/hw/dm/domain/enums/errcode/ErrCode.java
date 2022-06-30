package com.hw.dm.domain.enums.errcode;

import com.hw.dm.domain.ReturnMsg;
import com.hw.dm.domain.enums.CodeEnum;

public interface ErrCode<V extends Enum<V>> extends CodeEnum<Integer, V> {

    default <T> ReturnMsg<T> reply() {
        ReturnMsg<T> err = new ReturnMsg<>();
        err.setCode(getCode());
        err.setMsg(getDesc());
        return err;
    }
}
