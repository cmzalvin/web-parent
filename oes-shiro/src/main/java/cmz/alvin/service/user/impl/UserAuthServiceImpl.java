package cmz.alvin.service.user.impl;

import cmz.alvin.dao.UserAuthMapper;
import cmz.alvin.pojo.User;
import cmz.alvin.service.user.UserAuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * Created by e诺
 * on 16/7/25
 * Time 上午10:50
 */
@Service("userAuthService")
public class UserAuthServiceImpl implements UserAuthService {
    @Autowired
    private UserAuthMapper userAuthMapper;

    @Override
    public Set<String> getRoleById(Integer userId) {
        Set<String> roles = userAuthMapper.getRoleById(userId);
        return roles;
    }

    @Override
    public Set<String> getPermissionById(Integer userId) {
        Set<String> permissions = userAuthMapper.getPermissionById(userId);
        return permissions;
    }

    @Override
    public void createUser(User user) {
        userAuthMapper.createUser(user);
    }

    @Override
    public User getUserByUsername(String username) {
        User user = userAuthMapper.getUserByUsername(username);
        return user;
    }
}
