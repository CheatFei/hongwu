package com.hw.dm.domain.base;

import com.hw.dm.domain.ReturnMsg;
import com.hw.dm.domain.enums.errcode.ErrCode;
import com.hw.dm.exception.ZeroException;
import com.hw.dm.util.DateUtils;
import com.hw.dm.util.EnvUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.ConstraintViolationException;
import java.beans.PropertyEditorSupport;
import java.time.LocalDateTime;

import static com.hw.dm.domain.enums.errcode.CommonErr.*;

public class BaseController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    @ExceptionHandler({Exception.class})
    @ResponseBody
    public ReturnMsg<Void> handler(Exception e) {
        if (e instanceof ZeroException) {
            ErrCode<?> ec = ((ZeroException) e).getErrCode();
            Object[] args = ((ZeroException) e).getArgs();
            ReturnMsg<Void> errReply = ec.reply();
            if (args != null) {
                errReply.setMsg(String.format(ec.getDesc(), args));
            }
            return errReply;
        }
        logger.error(ExceptionUtils.getStackTrace(e));
        if (e instanceof ConstraintViolationException ||
                e instanceof MissingServletRequestParameterException) {
            ReturnMsg<Void> reply = C_400.reply();
            if (EnvUtils.isDevMode()) {
                reply.setMsg(e.getMessage());
            }
            return reply;
        }
        ReturnMsg<Void> reply = C_500.reply();
        if (EnvUtils.isDevMode()) {
            reply.setMsg(e.getMessage());
        }
        return reply;

    }

    protected static <T> ReturnMsg<T> success(T data) {
        return ReturnMsg.success(data);
    }

    protected static <T> ReturnMsg<T> success() {
        return ReturnMsg.success(null);
    }

    @InitBinder
    protected void initBinder(WebDataBinder binder) {
        binder.registerCustomEditor(LocalDateTime.class, new PropertyEditorSupport() {
            @Override
            public void setAsText(String text) {
                setValue(DateUtils.parseDateTimeLenient(text));
            }
        });
    }

}
