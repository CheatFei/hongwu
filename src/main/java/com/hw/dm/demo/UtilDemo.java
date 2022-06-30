package com.hw.dm.demo;

import com.hw.dm.domain.enums.errcode.ZeroErr;
import com.hw.dm.exception.ZeroException;
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

        BigDecimal bigDecimal = new BigDecimal("1.1151");

        BigDecimal c1 = bigDecimal.setScale(2, BigDecimal.ROUND_CEILING);
        BigDecimal c2 = bigDecimal.setScale(2, BigDecimal.ROUND_DOWN);
        BigDecimal c3 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_UP);
        BigDecimal c4 = bigDecimal.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        System.out.println(c1);
        System.out.println(c2);
        System.out.println(c3);
        System.out.println(c4);

        BigDecimal res = bigDecimal.divide(new BigDecimal("3")).setScale(2, BigDecimal.ROUND_CEILING);
        BigDecimal res2 = bigDecimal.divide(new BigDecimal("3"));
        System.out.println(res);
        System.out.println(res2);

        throw new ZeroException(ZeroErr.ZERO_ERR_001);

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
