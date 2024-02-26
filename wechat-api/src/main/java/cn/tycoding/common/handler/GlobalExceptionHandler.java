package cn.tycoding.common.handler;

import cn.tycoding.common.constants.CommonConstant;
import cn.tycoding.common.exception.GlobalException;
import cn.tycoding.common.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * 全局异常处理器
 *
 * @author tycoding
 * @date 2020/6/9
 */
@Slf4j
@RestControllerAdvice
@Order(value = Ordered.HIGHEST_PRECEDENCE)
public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public R exception(Exception e) {
        log.error("内部错误, {}", e.getMessage());
        e.printStackTrace();
        return new R(e);
    }

    @ExceptionHandler(value = GlobalException.class)
    public R globalExceptionHandle(GlobalException e) {
        log.error("全局异常, {}", e.getMessage());
        e.printStackTrace();
        return new R<>(CommonConstant.ERROR, e.getMsg());
    }
}
