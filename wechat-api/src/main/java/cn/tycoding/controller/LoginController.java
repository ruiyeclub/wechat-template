package cn.tycoding.controller;

import cn.tycoding.common.constants.enums.CommonEnum;
import cn.tycoding.common.exception.GlobalException;
import cn.tycoding.common.utils.R;
import org.springframework.web.bind.annotation.*;

/**
 * @author tycoding
 * @date 2020/6/9
 */
@RestController
public class LoginController {

    /**
     * 登录接口
     *
     * @param username
     * @param password
     * @return
     */
    @GetMapping("/login")
    public R login(@RequestParam(value = "username", required = false) String username,
                   @RequestParam(value = "password", required = false) String password) {
        if (username == null || password == null) {
            throw new GlobalException(CommonEnum.LOGIN_ERROR.getMsg());
        }
        return null;
    }
}
