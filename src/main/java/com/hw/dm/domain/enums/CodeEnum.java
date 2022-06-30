package com.hw.dm.domain.enums;

/**
 * @author Administrator
 * 枚举类顶层接口
 */
public interface CodeEnum<K, V extends Enum<V>> {

    K getCode();

    String getDesc();
}
