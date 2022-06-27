package com.hw.dm.util;

import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 常用utils
 */
public class UtilDemo {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();
        System.out.println(CollectionUtils.isEmpty(strings));
        System.out.println(new BigDecimal(""));

    }

    /**
     *  Collections
     *  CollectionUtils
     *  Lists
     *  Objects
     *  BooleanUtils
     *  StringUtils
     *  Assert
     *  IOUtils
     *  MDC
     *  ClassUtils
     *  BeanUtils
     *  ReflectionUtils
     *  Base64Utils
     *  StandardCharsets
     *  DigestUtils
     *  SerializationUtils
     *  HttpStatus
     *  帖子地址：https://mp.weixin.qq.com/s/GHQDBSxW1MfZHDOvryklmA
     *
     */

}
