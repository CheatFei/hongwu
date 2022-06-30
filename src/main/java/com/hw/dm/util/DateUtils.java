package com.hw.dm.util;

import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * 日期工具类
 */
public class DateUtils {

    public static LocalDateTime DEFAULT_DATE_TIME = LocalDateTime.of(1970, 1, 1, 0, 0, 0);

    public static String DAY_BEGIN = "00:00:00";
    public static String DAY_END = "23:59:59";

    public static String DAY_BEGIN_NO_SEC = "00:00";
    public static String DAY_END_NO_SEC = "23:59";


    public static String DATE_TIME_PATTERN = "yyyy-MM-dd HH:mm:ss";
    public static String GBAO_DATE_TIME_PATTERN = "yyyyMMddHHmmss";
    public static String TIME_PATTERN = "HH:mm:ss";
    public static String TIME_WITHOUT_SEC_PATTERN = "HH:mm";

    public static Long OVER_TIME_ZERO = 0L;
    public static Long MAX_OVER_TIME = 86400L;


    /**
     * 字符转日期
     */
    public static LocalDateTime parseDateTime(String datetime) {
        if (StringUtils.isBlank(datetime)) {
            return null;
        }
        try {
            return LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 字符转日期
     */
    public static LocalDateTime parseDateTimeLenient(String datetime) {
        if (StringUtils.isBlank(datetime)) {
            return null;
        }

        LocalDateTime localDateTime = null;
        try {
            localDateTime = LocalDateTime.parse(datetime, DateTimeFormatter.ofPattern(DATE_TIME_PATTERN));
        } catch (Exception e) {
            try {
                localDateTime = LocalDate.parse(datetime, DateTimeFormatter.ofPattern("yyyy-MM-dd")).atStartOfDay();
            } catch (Exception exception) {
            }
        }
        return localDateTime;
    }

    public static LocalDateTime parseGbaoPayTime(String payTime) {
        if (StringUtils.isBlank(payTime)) {
            return null;
        }
        try {
            return LocalDateTime.parse(payTime, DateTimeFormatter.ofPattern(GBAO_DATE_TIME_PATTERN));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 字符转转时间
     */
    public static LocalTime parseTime(String time) {
        if (StringUtils.isBlank(time)) {
            return null;
        }
        try {
            return LocalTime.parse(time, DateTimeFormatter.ofPattern(TIME_PATTERN));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 字符转转时间
     */
    public static LocalTime parseTime(String time, String pattern) {
        if (StringUtils.isBlank(time)) {
            return null;
        }
        try {
            return LocalTime.parse(time, DateTimeFormatter.ofPattern(pattern));
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 秒数转换成人类可读格式
     */
    public static String humanTime(long seconds) {
        if (seconds <= 0) {
            return StringUtils.EMPTY;
        }
        final int SECOND = 1000;
        final int MINUTE = 60 * SECOND;
        final int HOUR = 60 * MINUTE;
        final int DAY = 24 * HOUR;
        long ms = seconds * 1000;
        StringBuilder text = new StringBuilder("");
        if (ms > DAY) {
            text.append(ms / DAY).append("天");
            ms %= DAY;
        }
        if (ms > HOUR) {
            text.append(ms / HOUR).append("小时");
            ms %= HOUR;
        }
        if (ms > MINUTE) {
            text.append(ms / MINUTE).append("分");
            ms %= MINUTE;
        }
        if (ms > SECOND) {
            long s = ms / SECOND;
            if (s < 10) {
                text.append('0');
            }
            text.append(s).append("秒");
        }
        return text.toString();
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     *
     * @param date    日期
     * @param pattern 格式，如：DateUtils.DATE_TIME_PATTERN
     * @return 返回yyyy-MM-dd格式日期
     */
    public static String format(Date date, String pattern) {
        if (date != null) {
            SimpleDateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd
     *
     * @param date
     * @param pattern
     * @return
     */
    public static String format(LocalDateTime date, String pattern) {
        if (date != null) {
            DateTimeFormatter df = DateTimeFormatter.ofPattern(pattern);
            return df.format(date);
        }
        return null;
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd HH:mm:ss
     *
     * @param date 日期
     * @return 返回yyyy-MM-dd格式日期
     */
    public static String formatTime(Date date) {
        return format(date, DATE_TIME_PATTERN);
    }

    /**
     * 日期格式化 日期格式为：yyyy-MM-dd HH:mm:ss
     *
     * @param date
     * @return
     */
    public static String formatTime(LocalDateTime date) {
        return format(date, DATE_TIME_PATTERN);
    }


    /**
     * 获取过期时间,向后取30分钟
     * createTime:获取创建时间
     *
     * @return
     */
    public static LocalDateTime expireDate(LocalDateTime createTime) {
        return createTime.plusMinutes(30);
    }

    /**
     * @param createTime
     * @param difference 差值，单位分钟
     * @return
     */
    public static LocalDateTime expireDate(LocalDateTime createTime, int difference) {
        return createTime.plusMinutes(difference);
    }


    /**
     * 获取倒计时，两个两个日期的差值，如果为负值，返回0
     *
     * @param start
     * @param end
     * @return
     */
    public static Long countDown(LocalDateTime start, LocalDateTime end) {
        Duration between = Duration.between(start, end);
        long seconds = between.getSeconds();
        if (seconds < OVER_TIME_ZERO || seconds >= MAX_OVER_TIME) {
            return OVER_TIME_ZERO;
        }
        return seconds;
    }

    public static void main(String[] args) {
        LocalDateTime localDateTime = parseDateTime("2022-04-22 20:00:00");
        System.out.println(LocalDateTime.now());
        Long aLong = countDown(LocalDateTime.now(), localDateTime);
        System.out.println(aLong);
    }


}
