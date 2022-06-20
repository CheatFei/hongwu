package com.hw.dm.zero;


import cn.hutool.Hutool;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSON;
import cn.hutool.json.JSONUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Demo {

    private static Logger logger = LoggerFactory.getLogger(Demo.class);

    /**
     *
     * protected 在子类实现父类的方法或者方法中使用
     *
     * @param args
     */
    public static void main(String[] args) {

        boolean aNull = Objects.isNull(new BigDecimal("1"));
        System.out.println(aNull);
        boolean equals = Objects.equals(1, 2);
        System.out.println(equals);
        System.out.println("sss".hashCode());
        System.out.println(Objects.hash("sss"));


    }

    public void strDemo(){
        logger.info("init demo ,this is new demo = {}","hw");
        if(CollectionUtils.isEmpty(new ArrayList<>())){
            logger.info("this is a new array");
        }
        Set<String> setDemo = new HashSet<>(10);
        setDemo.add("hello ervery");
        JSON parse = JSONUtil.parse(setDemo);
        System.out.println(parse);
        DateTime date = DateUtil.date();
        System.out.println(date);
        DateTime date1 = DateUtil.date(LocalDateTime.now());
        System.out.println(date1);
        DateTime parse1 = DateUtil.parse("2022-1-1 00:11:11");
        System.out.println(parse1);
        System.out.println(DateUtil.beginOfDay(parse1));
        System.out.println(DateUtil.endOfDay(parse1));

        boolean blank = StrUtil.isBlank("11");
    }
}
