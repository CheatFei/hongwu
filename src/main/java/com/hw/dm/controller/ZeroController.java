package com.hw.dm.controller;

import com.hw.dm.domain.Param;
import com.hw.dm.domain.ReturnMsg;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.MDC;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("zero")
@Slf4j
public class ZeroController {

    @GetMapping("test1")
    public ReturnMsg getTest(Param param) {
        log.info("请求参数：param={},method={}", param,"get");
        return ReturnMsg.success();
    }

    @PostMapping("test2")
    public ReturnMsg postTest(@Validated @RequestBody Param param) {
        log.info("traceId={}", MDC.get("traceId"));
        log.info("请求参数：param={},method={}", param,"post");
        return ReturnMsg.success();
    }
}
