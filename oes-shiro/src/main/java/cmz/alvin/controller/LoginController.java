package cmz.alvin.controller;

import cmz.alvin.core.BaseController;
import cmz.alvin.core.BusinessException;
import cmz.alvin.core.TotalResult;
import cmz.alvin.core.UserErrorCode;
import cmz.alvin.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by e诺
 * on 16/8/2
 * Time 上午8:58
 */
@Controller
public class LoginController extends BaseController {
    @RequestMapping(value = "/login", method = {RequestMethod.GET, RequestMethod.POST}, produces = "application/json;charset=utf-8")
    @ResponseBody
    public Object userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();

        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            throw new BusinessException(UserErrorCode.USER_UNKNOWN_ERROR);
        } catch (IncorrectCredentialsException e) {
            throw new BusinessException(UserErrorCode.USER_PASSWORD_ERROR);
        } catch (AuthenticationException ex) {
            throw new BusinessException(UserErrorCode.USER_AUTHENTICATION_ERROR);
        }

        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        TotalResult totalResult = TotalResult.newIntance(user);
        return totalResult;
    }

    /*@RequestMapping(value = "/login")
    public String userLogin(@RequestParam("username") String username, @RequestParam("password") String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
            if (subject.isAuthenticated()) {
                System.out.println("登录成功");
            } else {
                System.out.println("用户名/密码错误");
            }

        } catch (AuthenticationException ex) {
            ex.printStackTrace();
        }
        Session session = subject.getSession();
        User user = (User) session.getAttribute("user");
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("user", user);
        return "index";
    }*/


}

