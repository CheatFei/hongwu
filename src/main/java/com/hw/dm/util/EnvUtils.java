package com.hw.dm.util;

import com.hw.dm.common.SpringContextHolder;
import org.springframework.core.env.Environment;

import java.util.Arrays;

public class EnvUtils {

    public static boolean isDevMode() {
        Environment env = SpringContextHolder.getBean(Environment.class);
        if (env == null) {
            return false;
        }
        String[] activeProfiles = env.getActiveProfiles();
        if (activeProfiles.length == 0) {
            // 没有指定profile 使用的是default profile，为本地开发
            return true;
        }
        return Arrays.asList(env.getActiveProfiles()).contains("dev");

    }

}
