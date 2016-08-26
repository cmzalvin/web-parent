package service.user;

import cmz.alvin.pojo.User;
import cmz.alvin.service.user.UserAuthService;
import cmz.alvin.util.shiro.PasswordHelper;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by e诺
 * on 16/7/28
 * Time 上午9:07
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/config/spring*.xml"})
public class UserAuthServiceTest {

    Logger log = Logger.getLogger(UserAuthServiceTest.class);
    @Autowired
    private UserAuthService userAuthService;

    @Test
    public void getUserRoles() {
        userAuthService.getRoleById(3);

    }

    @Test
    public void getPermissions() {
        userAuthService.getPermissionById(3);
    }

    @Test
    public void createUser() {
        User user = new User();
        user.setUsername("alvin");
        user.setPassword("123456");
        PasswordHelper.encryptPassword(user);
        userAuthService.createUser(user);
    }

    @Test
    public void getUserByUsername() {
        log.info(userAuthService.getUserByUsername("alvin").toString());
    }

}
