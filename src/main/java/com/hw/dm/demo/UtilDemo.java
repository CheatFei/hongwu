package com.hw.dm.demo;


import com.hw.dm.util.DateUtils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 常用utils
 */
public class UtilDemo {

    public static void main(String[] args) {


    }

    public void changeLocalDate() {
        LocalDateTime beginDate = DateUtils.parseDateTimeLenient("2022-07-01");
        LocalDateTime endDate = DateUtils.parseDateTimeLenient("2022-07-04");

        long max = Math.max(ChronoUnit.DAYS.between(beginDate, endDate) + 1, 0);
        System.out.println(max);


        List<LocalDate> dayList = Stream
                .iterate(beginDate, (LocalDateTime i) -> i.plusDays(1))
                .limit(Math.max(ChronoUnit.DAYS.between(beginDate, endDate) + 1, 0))
                .map(LocalDateTime::toLocalDate).collect(Collectors.toList());
        System.out.println(dayList);
    }

    private void objectDemo() {
        UserDemo demo = new UserDemo("", "", 12);
        System.out.println(demo);
        changeUserInfo(demo);
        System.out.println(demo);
    }

    private void changeUserInfo(UserDemo demo) {
        demo.setName("张三");
        demo.setAge(22);
        demo.setSex("男");
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
