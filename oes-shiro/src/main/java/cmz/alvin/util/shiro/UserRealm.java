package cmz.alvin.util.shiro;

import cmz.alvin.pojo.User;
import cmz.alvin.service.user.UserAuthService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

/**
 * Created by e诺
 * on 16/7/25
 * Time 上午10:31
 */
public class UserRealm extends AuthorizingRealm implements Serializable {

    @Autowired
    private UserAuthService userAuthService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        Integer userId = (Integer) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authenticationInfo = new SimpleAuthorizationInfo();
        authenticationInfo.setRoles(userAuthService.getRoleById(userId));
        authenticationInfo.setStringPermissions(userAuthService.getPermissionById(userId));
        return authenticationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) authenticationToken;
        String username = usernamePasswordToken.getUsername();

        User user = userAuthService.getUserByUsername(username);
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession();
        session.setAttribute("user", user);

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(
                user.getUsername(),
                user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),
                getName());
        return simpleAuthenticationInfo;
    }
}
