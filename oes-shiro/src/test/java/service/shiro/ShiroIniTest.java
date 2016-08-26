package service.shiro;

import cmz.alvin.util.shiro.ShiroUtil;
import com.sun.security.sasl.gsskerb.FactoryImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

/**
 * Created by e诺
 * on 16/7/29
 * Time 上午8:39
 */
public class ShiroIniTest {
    @Test
    public void shiroIniTest() {

        Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
        SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken("zhang", "123");
        try {
            System.out.println("开始登陆!!!!!!!!!!");
            subject.login(token);
        } catch (AuthenticationException e) {
            System.out.println("身份验证失败");
        }

        Assert.assertEquals(true, subject.isAuthenticated()); //断言用户已经登录
        subject.logout();
    }

    @Test
    public void testHasRole() {
        ShiroUtil.login("classpath:shiro.ini", "zhang", "123");
        //判断拥有角色：role1
        Subject subject = SecurityUtils.getSubject();
        Assert.assertTrue(subject.hasRole("role1"));
        //判断拥有角色：role1 and role2
        Assert.assertTrue(subject.hasAllRoles(Arrays.asList("role1", "role2")));
        //判断拥有角色：role1 and role2 and !role3
        boolean[] result = subject.hasRoles(Arrays.asList("role1", "role2", "role3"));
        Assert.assertEquals(true, result[0]);
        Assert.assertEquals(true, result[1]);
        Assert.assertEquals(false, result[2]);
    }
}
